/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.Order;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.OrderParam;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.OrderService;

/**
 *
 * @author u14138
 */
@ManagedBean(name = "orderController")
@SessionScoped
public class OrderController {

    public List<Order> getOrders(OrderParam params) {
        OrderService service = new OrderService();
        return service.getOrders(params);
    }
    
    public boolean checkout(Order order) {
        OrderService service = new OrderService();
        return service.checkout(order);
    }
    
    public boolean cancelOrder(Order order) {
        OrderService service = new OrderService();
        return service.cancelOrder(order);
    }
    
    public boolean processOrder(Order order) {
        OrderService service = new OrderService();
        return service.processOrder(order);
    }
    
    public boolean deliverOrder(Order order) {
        OrderService service = new OrderService();
        return service.deliverOrder(order);
    }
    
    public Order getOrder(int orderID) {
        OrderService service = new OrderService();
        return service.getOrder(orderID);
    }
}
