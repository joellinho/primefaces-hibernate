/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.Order;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.OrderItem;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Product;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.SearchProductItem;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SearchProductParam;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.ProductService;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SystemService;

/**
 *
 * @author Java_VS
 */
@ManagedBean(name = "productController")
@SessionScoped
public class ProductController {

    private Order order;

    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;

    @PostConstruct
    public void init() {
        initOrder();
    }

    public void initOrder() {
        order = new Order();
        
        if (!securityController.isAdmin()) {            
            order.setOrderID(SystemService.generateTempID("order"));
            order.setCustomerID(securityController.getCustomerID());
            order.setCustomerFullName(securityController.getUserFullName());
            order.setStatus(0); // checkout
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 7);
            order.setDeliveryDate(c.getTime());
            order.setItems(new HashMap<Integer, OrderItem>());
        }
    }

    public HashMap<Integer, String> getBrands() {
        return ProductService.getBrands();
    }

    public HashMap<Integer, String> getOperatingSystems() {
        return ProductService.getOperatingSystems();
    }

    public List<SearchProductItem> searchProducts(SearchProductParam params) {
        ProductService productService = new ProductService();
        List<SearchProductItem> products = productService.searchProducts(params);

        for (SearchProductItem product : products) {
            product.setAddedToOrder(productInOrder(product));
            product.setOrderItem(getOrderItem(product));
        }

        return products;
    }

    public OrderItem getOrderItem(SearchProductItem product) {
        return order.getItems().get(product.getProductID());
    }

    public boolean productInOrder(SearchProductItem product) {
        return getOrderItem(product) != null;
    }

    public void addProductToOrder(SearchProductItem product) {
        int productID = product.getProductID();
        OrderItem item = order.getItems().get(productID);

        if (item == null) {
            item = new OrderItem();
            item.setItemID(SystemService.generateTempID("orderItem"));
            item.setProductID(productID);
            item.setQuantity(1);
            item.setUnitPrice(product.getPrice());
            item.setSubTotal(product.getPrice());
            order.getItems().put(productID, item);
        }

        product.setAddedToOrder(true);
        product.setOrderItem(item);
        updateOrder();
    }

    public void removeProductFromOrder(SearchProductItem product) {
        order.getItems().remove(product.getProductID());
        product.setAddedToOrder(false);
        product.setOrderItem(null);
        updateOrder();
    }

    public void increaseProductQty(SearchProductItem product) {
        OrderItem item = product.getOrderItem();
        int qty = item.getQuantity() + 1;
        item.setQuantity(qty);
        item.setSubTotal(qty * item.getUnitPrice());
        updateOrder();
    }

    public void decreaseProductQty(SearchProductItem product) {
        OrderItem item = product.getOrderItem();
        int qty = item.getQuantity() - 1;

        if (qty > 0) {
            item.setQuantity(qty);
            item.setSubTotal(qty * item.getUnitPrice());
        } else {
            removeProductFromOrder(product);
        }

        updateOrder();
    }

    public void updateOrder() {
        order.setSubTotal(Double.valueOf(0));

        for (Integer productID : order.getItems().keySet()) {
            OrderItem item = order.getItems().get(productID);
            order.setSubTotal(order.getSubTotal() + item.getSubTotal());
        }

        order.setTaxAmount(order.getSubTotal() * 0.18);
        order.setTotal(order.getSubTotal() + order.getTaxAmount());
    }

    public Map<Integer, SearchProductItem> getProductsOfOrder(Order order) {
        ProductService productService = new ProductService();
        return productService.getProductsOfOrder(order);
    }
    
    public Product getProduct(int productID) {
        ProductService productService = new ProductService();
        return productService.getProduct(productID);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SecurityController getSecurityController() {
        return securityController;
    }

    public void setSecurityController(SecurityController securityController) {
        this.securityController = securityController;
    }
}
