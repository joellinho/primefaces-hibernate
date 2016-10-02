/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.PoDAO;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.ProductDAO;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.SearchProductItemDAO;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer.Customer;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Product;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.SearchProductItem;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.*;
import static pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.ProductService.initProducts;
import static pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.ProductService.products;

/**
 *
 * @author u14138
 */
public class OrderService extends BaseService {

    public static HashMap<Integer, Order> orders = new HashMap<>();

    public static OrderItem createOrderItem(int productID, int quantity) {
        OrderItem item = new OrderItem();
        item.setItemID(SystemService.generateID("orderItem"));
        item.setProductID(productID);
        item.setQuantity(quantity);
        ProductService service = new ProductService();
        double price = service.getSearchProductItem(productID).getPrice();
        item.setUnitPrice(price);
        item.setSubTotal(quantity * price);
        return item;
    }

    public static Order createOrder(int customerID, int[] products, int status) {
        Order order = new Order();
        int orderID = SystemService.generateID("order");
        order.setOrderID(orderID);
        order.setItems(new HashMap<Integer, OrderItem>());
        order.setCustomerID(customerID);
        CustomerService service = new CustomerService();
        Customer customer = service.getCustomer(customerID);
        //Customer customer = CustomerService.customers.get(customerID);
        order.setCustomerFullName(customer.getFirstName() + " " + customer.getLastName());
        Random r = new Random();
        double subTotal = 0;

        for (int productID : products) {
            OrderItem item = createOrderItem(productID, r.nextInt(5) + 1);
            order.getItems().put(productID, item);
            subTotal += item.getSubTotal();
        }

        order.setSubTotal(subTotal);
        order.setTaxAmount(subTotal * 0.18);
        order.setTotal(subTotal + order.getTaxAmount());

        Calendar c = Calendar.getInstance();
        c.roll(Calendar.DATE, (r.nextInt(90) + 1) * -1);
        order.setCreatedOn(c.getTime());
        c.roll(Calendar.DATE, (r.nextInt(5) + 1));
        order.setDeliveryDate(c.getTime());
        order.setStatus(status);

        if (status == -1) {
            c.roll(Calendar.DATE, r.nextInt(3));
            order.setCancelledOn(c.getTime());
        } else {
            c.roll(Calendar.DATE, r.nextInt(4));

            if (status > 1) {
                order.setProcessedOn(c.getTime());
            }

            c.roll(Calendar.DATE, r.nextInt(2) + 1);

            if (status > 2) {
                order.setDeliveredOn(c.getTime());
            }
        }

        orders.put(orderID, order);
        return order;
    }

    public static void initOrders() {
        createOrder(1, new int[]{10, 15}, -1);
        createOrder(1, new int[]{5, 8}, 2);
        createOrder(1, new int[]{21, 28, 7}, 1);
        // Cancelled = 1, Pending = 1, Processed = 1, Delivered = 0

        createOrder(2, new int[]{2, 11, 18}, 3);
        createOrder(2, new int[]{23, 24, 25, 26}, 2);
        createOrder(2, new int[]{14}, 1);
        createOrder(2, new int[]{19, 9}, 1);
        // Cancelled = 0, Pending = 2, Processed = 1, Delivered = 1

        // Total: 7 orders
    }

    public static void loadOrders() {
        EntityManager em = SystemService.createEntityManager();
        Query q = em.createNamedQuery("PoDAO.countAll");
        Long size = (Long) q.getSingleResult();

        if (size == 0) {
            try {
                initOrders();

                em.getTransaction().begin();
                for (Integer id : orders.keySet()) {
                    Order order = orders.get(id);
                    PoDAO orderDAO = new PoDAO(order);
                    em.persist(orderDAO);
                    orderDAO.updateItemsFromDTO(order);
                    em.merge(orderDAO);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }

        em.close();
    }

    static {
        //initOrders();
        loadOrders();
    }

//    public boolean filterOrder(Order order, OrderFilter filter) {
//        HashSet<Integer> filterStatus = filter.getStatus();
//
//        if (filterStatus.size() > 0 && !filterStatus.contains(order.getStatus())) {
//            return false;
//        }
//
//        if (filter.getCustomerID() > 0 && order.getCustomerID() != filter.getCustomerID()) {
//            return false;
//        }
//
//        if (filter.getBefore() != null || filter.getAfter() != null) {
//            switch (filter.getFilterByDate()) {
//                case "delivery":
//                    if (filter.getAfter() != null && order.getDeliveryDate().compareTo(filter.getAfter()) <= 0) {
//                        return false;
//                    }
//
//                    if (filter.getBefore() != null && order.getDeliveryDate().compareTo(filter.getBefore()) > 0) {
//                        return false;
//                    }
//
//                    break;
//                case "delivered":
//                    if (filter.getAfter() != null && order.getDeliveredOn().compareTo(filter.getAfter()) <= 0) {
//                        return false;
//                    }
//
//                    if (filter.getBefore() != null && order.getDeliveredOn().compareTo(filter.getBefore()) > 0) {
//                        return false;
//                    }
//
//                    break;
//                case "processed":
//                    if (filter.getAfter() != null && order.getProcessedOn().compareTo(filter.getAfter()) <= 0) {
//                        return false;
//                    }
//
//                    if (filter.getBefore() != null && order.getProcessedOn().compareTo(filter.getBefore()) > 0) {
//                        return false;
//                    }
//
//                    break;
//                case "created":
//                    if (filter.getAfter() != null && order.getCreatedOn().compareTo(filter.getAfter()) <= 0) {
//                        return false;
//                    }
//
//                    if (filter.getBefore() != null && order.getCreatedOn().compareTo(filter.getBefore()) > 0) {
//                        return false;
//                    }
//
//                    break;
//                case "cancelled":
//                    if (filter.getAfter() != null && order.getCancelledOn().compareTo(filter.getAfter()) <= 0) {
//                        return false;
//                    }
//
//                    if (filter.getBefore() != null && order.getCancelledOn().compareTo(filter.getBefore()) > 0) {
//                        return false;
//                    }
//
//                    break;
//            }
//        }
//
//        return true;
//    }

//    public List<Order> getOrders(OrderParam params) {
//        OrderComparator comparator = new OrderComparator(params.getSort());
//        TreeSet<Order> tree = new TreeSet<>(comparator);
//
//        for (Integer orderID : orders.keySet()) {
//            Order order = orders.get(orderID);
//
//            if (filterOrder(order, params.getFilter())) {
//                tree.add(order);
//            }
//        }
//
//        List<Order> result = new ArrayList<>(tree.size());
//        Iterator<Order> iterator;
//
//        if (params.getSort().isAscending()) {
//            iterator = tree.iterator();
//        } else {
//            iterator = tree.descendingIterator();
//        }
//
//        while (iterator.hasNext()) {
//            result.add(iterator.next());
//        }
//
//        return result;
//    }
    private Query createOrderQuery(OrderParam params) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT o FROM PoDAO o");

        OrderFilter filter = params.getFilter();
        HashSet<Integer> filterStatus = filter.getStatus();
        HashMap<String, Object> queryParams = new HashMap<>();

        if (!filterStatus.isEmpty() || filter.getCustomerID() > 0) {
            Integer paramCount = 0;
            builder.append(" WHERE ");

            if (!filterStatus.isEmpty()) {
                builder.append("o.status IN (");

                for (Integer id : filterStatus) {
                    paramCount++;
                    String p = addParamToBuilder(builder, paramCount, paramCount == filterStatus.size());
                    queryParams.put(p, id);
                }
            }

            if (filter.getCustomerID() > 0) {
                if (!filterStatus.isEmpty()) {
                    builder.append(" AND ");
                }

                builder.append("o.customerId = :customerId");
                queryParams.put("customerId", filter.getCustomerID());
            }
        }

        addSortToBuilder(builder, params.getSort());
        Query result = getEntityManager().createQuery(builder.toString(), PoDAO.class);
        setQueryParams(result, queryParams);

        return result;
    }

    public List<Order> getOrders(OrderParam params) {
        initConnection();
        Query q = createOrderQuery(params);
        List<PoDAO> list = q.getResultList();
        closeConnection();

        List<Order> result = new ArrayList<>(list.size());

        for (PoDAO item : list) {
            result.add(item.getDTO());
        }

        return result;
    }

//    public boolean checkout(Order order) {
//        
//        for (Integer productID : order.getItems().keySet()) {
//            OrderItem item = order.getItems().get(productID);
//            Integer itemID = SystemService.generateID("orderItem");
//            item.setItemID(itemID);
//            item.setProduct(null);
//        }
//        
//        Calendar c = Calendar.getInstance();
//        Integer orderID = SystemService.generateID("order");
//        order.setOrderID(orderID);        
//        order.setCreatedOn(c.getTime());        
//        order.setStatus(1); // Pending
//        orders.put(orderID, order);
//        
//        return true;
//    }

    public boolean checkout(Order order) {

        for (Integer productID : order.getItems().keySet()) {
            OrderItem item = order.getItems().get(productID);
            //Integer itemID = SystemService.generateID("orderItem");
            //item.setItemID(itemID);
            item.setProduct(null);
        }

        Calendar c = Calendar.getInstance();
        //Integer orderID = SystemService.generateID("order");
        //order.setOrderID(orderID);
        order.setCreatedOn(c.getTime());
        order.setStatus(1); // Pending
        //orders.put(orderID, order);
        
        try {
            initTransaction();
            PoDAO orderDAO = new PoDAO(order);
            getEntityManager().persist(orderDAO);
            orderDAO.updateItemsFromDTO(order);
            getEntityManager().merge(orderDAO);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            return false;
        }

        return true;
    }
    
    private boolean updateOrder(Order order) {
        try {
            initTransaction();
            PoDAO orderDAO = (PoDAO) findById(PoDAO.class, order.getOrderID(), true);
            orderDAO.updateFromDTO(order);
            getEntityManager().merge(orderDAO);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            return false;
        }

        return true;
    }

    public boolean cancelOrder(Order order) {
        order.setStatus(-1);
        order.setCancelledOn(SystemService.getDate());
        return updateOrder(order);
    }

    public boolean processOrder(Order order) {
        order.setStatus(2);
        order.setProcessedOn(SystemService.getDate());
        return updateOrder(order);
    }

    public boolean deliverOrder(Order order) {
        order.setStatus(3);
        order.setDeliveredOn(SystemService.getDate());
        return updateOrder(order);
    }

//    public Order getOrder(int orderID) {
//        return orders.get(orderID);
//    }

    public Order getOrder(int orderID) {
        PoDAO orderDAO = (PoDAO) findById(PoDAO.class, orderID);
        return orderDAO.getDTO();
    }

    public static HashMap<Integer, Order> getOrders() {
        return orders;
    }

    public static void setOrders(HashMap<Integer, Order> orders) {
        OrderService.orders = orders;
    }
}
