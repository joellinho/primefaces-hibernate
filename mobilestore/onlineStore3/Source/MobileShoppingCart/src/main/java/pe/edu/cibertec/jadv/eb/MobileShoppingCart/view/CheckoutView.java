/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.view;

import java.util.Collection;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.OrderController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.ProductController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.SecurityController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.SearchProductItem;

/**
 *
 * @author Kike
 */
@ManagedBean(name = "checkoutView")
@ViewScoped
public class CheckoutView {

    private String contextPath;
    
    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;
    
    @ManagedProperty(value = "#{productController}")
    private ProductController productController;

    @ManagedProperty(value = "#{orderController}")
    private OrderController orderController;

    
    @PostConstruct
    public void init() {
        contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        Order order = getOrder();
        Map<Integer, SearchProductItem> products = productController.getProductsOfOrder(order);
        
        for (Integer productID : order.getItems().keySet()) {
            SearchProductItem product = products.get(productID);
            OrderItem item = order.getItems().get(productID);
            product.setAddedToOrder(true);
            product.setOrderItem(item);
            item.setProduct(product);
        }
    }

    public String showCheckout() {
        return "checkout";
    }
    
    public String checkout() {
        if (orderController.checkout(getOrder())) {
            productController.initOrder();
            return "orders";
        }            
        
        return "";
    }
    
    public void increaseProductQty(OrderItem item) {
        SearchProductItem product = item.getProduct();
        productController.increaseProductQty(product);
    }

    public void decreaseProductQty(OrderItem item) {
        SearchProductItem product = item.getProduct();
        productController.decreaseProductQty(product);
    }
    
    public void removeProductFromOrder(OrderItem item) {
        SearchProductItem product = item.getProduct();
        productController.removeProductFromOrder(product);
    }
    
    public Order getOrder() {
        return productController.getOrder();
    }
    
    public Collection<OrderItem> getOrderItems() {
        return getOrder().getItems().values();
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
