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
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.CustomerController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.SecurityController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer.*;

/**
 *
 * @author Kike
 */
@ManagedBean(name = "customerListView")
@ViewScoped
public class CustomerListView {

    private String contextPath;
    private List<Customer> customerList;
    
    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;
    
    @ManagedProperty(value = "#{customerController}")
    private CustomerController customerController;
    
    @PostConstruct
    public void init() {
        contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        getCustomers();
    }
    
    public void getCustomers() {
        customerList = customerController.getCustomerList();
    }

    public String listCustomers() {
        getCustomers();
        return "customers";
    }
    
    public String newCustomer() {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("customerID", -1);
        return "customer";
    }
    
    public String editCustomer(int customerID) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("customerID", customerID);
        return "customer";
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

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }
}
