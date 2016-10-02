/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.OrderController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.ProductController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.SecurityController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.Order;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.*;

/**
 *
 * @author Kike
 */
@ManagedBean(name = "orderListView")
@ViewScoped
public class OrderListView {

    private String contextPath;
    private String[] selectedStatus;
    private OrderParam orderParam;
    private List<Order> orderList;
    
    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;
    
    @ManagedProperty(value = "#{productController}")
    private ProductController productController;

    @ManagedProperty(value = "#{orderController}")
    private OrderController orderController;

    
    @PostConstruct
    public void init() {
        contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();

        OrderFilter filter = new OrderFilter();
        if (!securityController.isAdmin())
            filter.setCustomerID(securityController.getUser().getUserDetail().getCustomerID());
        
        SortParam sorting = new SortParam();
        sorting.setAscending(true);
        //sorting.setField("delivery");
        sorting.setField("deliveryDate");
        PagingParam paging = new PagingParam();
        paging.setPageNo(1);
        paging.setPageSize(10);
        
        orderParam = new OrderParam();
        orderParam.setFilter(filter);
        orderParam.setSort(sorting);
        orderParam.setPaging(paging);
        filterOrders();
    }
    
    public void filterOrders() {
        orderList = orderController.getOrders(orderParam);
    }

    public String listOrders() {
        filterOrders();
        return "orders";
    }
    
    public void cancelOrder(Order order) {
        orderController.cancelOrder(order);
    }

    public void processOrder(Order order) {
        orderController.processOrder(order);
    }

    public void deliverOrder(Order order) {
        orderController.deliverOrder(order);
    }
    
    public String viewOrder(int orderID) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("orderID", orderID);
        return "order";
    }
    
    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String[] getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(String[] selectedStatus) {
        this.selectedStatus = selectedStatus;
        this.orderParam.getFilter().getStatus().clear();

        for (String status : selectedStatus) {
            this.orderParam.getFilter().getStatus().add(Integer.parseInt(status));
        }
    }

    public OrderParam getOrderParam() {
        return orderParam;
    }

    public void setOrderParam(OrderParam orderParam) {
        this.orderParam = orderParam;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public SecurityController getSecurityController() {
        return securityController;
    }

    public void setSecurityController(SecurityController securityController) {
        this.securityController = securityController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
