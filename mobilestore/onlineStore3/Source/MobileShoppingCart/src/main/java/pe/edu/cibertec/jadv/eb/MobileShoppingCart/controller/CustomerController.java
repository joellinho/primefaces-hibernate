/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.User;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.CustomerService;

/**
 *
 * @author u14138
 */
@ManagedBean(name = "customerController")
@SessionScoped
public class CustomerController {

    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;

    public List<Customer> getCustomerList() {
        CustomerService service = new CustomerService();
        return service.getCustomerList();
    }

    public Customer getCustomer(int customerID) {
        CustomerService service = new CustomerService();
        return service.getCustomer(customerID);
    }

    public int registerCustomer(Customer customer, User user) {
        if (!securityController.validateUserLogin(user.getUserLogin(), customer.getCustomerID()))
            return 1; 
        
        CustomerService service = new CustomerService();
        if (!service.registerCustomer(customer))
            return 2;
        
        user.getUserDetail().setCustomerID(customer.getCustomerID());
        user.getUserDetail().setFirstName(customer.getFirstName());
        user.getUserDetail().setLastName(customer.getLastName());
        if (!securityController.registerUser(user))
            return 3;
        
        return 0;
    }

    public int updateCustomer(Customer customer, User user, String previousUserLogin) {
        if (!securityController.validateUserLogin(user.getUserLogin(), customer.getCustomerID()))
            return 1; 
        
        CustomerService service = new CustomerService();
        if (!service.updateCustomer(customer))
            return 4;
        
        user.getUserDetail().setFirstName(customer.getFirstName());
        user.getUserDetail().setLastName(customer.getLastName());
        if (!securityController.updateUser(previousUserLogin, user))
            return 5;
        
        return 0;
    }

    public Map<Integer, String> getCities() {
        return CustomerService.getCities();
    }

    public Map<Integer, String> getStates() {
        return CustomerService.getStates();
    }

    public SecurityController getSecurityController() {
        return securityController;
    }

    public void setSecurityController(SecurityController securityController) {
        this.securityController = securityController;
    }
}
