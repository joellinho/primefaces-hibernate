/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.CustomerController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.SecurityController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.User;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.UserDetail;

/**
 *
 * @author Kike
 */
@ManagedBean(name = "customerView")
@ViewScoped
public class CustomerView {

    private String contextPath;
    private Customer customer;
    private User user;
    private String confirmPassword;
    private String previousUserLogin;
    private List<SelectItem> cityItems;
    private List<SelectItem> stateItems;

    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;

    @ManagedProperty(value = "#{customerController}")
    private CustomerController customerController;

    private void initValues(int customerID) {
        if (customerID > 0) {
            customer = customerController.getCustomer(customerID);
            user = securityController.getUserByCustomerID(customerID);
            previousUserLogin = user.getUserLogin();
            confirmPassword = SecurityController.DEFAULT_PASSWORD;
            user.setPassword(SecurityController.DEFAULT_PASSWORD);
        } else {
            customer = new Customer();
            customer.setCustomerID(-1);
            CustomerAddress address = new CustomerAddress();
            CustomerVirtual virtual = new CustomerVirtual();
            customer.setCustomerAddress(address);
            customer.setCustomerVirtual(virtual);

            user = new User();
            user.setUserID(-1);
            user.setRoleID(2); //Customer
            UserDetail detail = new UserDetail();
            detail.setCustomerID(-1);
            user.setUserDetail(detail);
        }
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        contextPath = context.getExternalContext().getApplicationContextPath();
        cityItems = buildSelectList(customerController.getCities());
        stateItems = buildSelectList(customerController.getStates());

        int customerID = (int) context.getExternalContext().getRequestMap().get("customerID");

        if (securityController.isAdmin() || securityController.getCustomerID() == customerID) {
            initValues(customerID);
        }
    }

    public List<SelectItem> buildSelectList(Map<Integer, String> map) {
        List<SelectItem> result = new ArrayList<>(map.size());

        for (Integer id : map.keySet()) {
            result.add(new SelectItem(id, map.get(id)));
        }

        return result;
    }

    public boolean validatePassword() {
        if (SecurityController.DEFAULT_PASSWORD.equals(user.getPassword())
                && SecurityController.DEFAULT_PASSWORD.equals(confirmPassword)) {
            return true;
        }

        if (confirmPassword != null && !"".equals(confirmPassword) && confirmPassword.equals(user.getPassword())) {
            return true;
        }

        if (user.getPassword() != null && !"".equals(user.getPassword()) && user.getPassword().equals(confirmPassword)) {
            return true;
        }

        return false;
    }

    public void saveChanges() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle rb = ResourceBundle.getBundle("messages", context.getViewRoot().getLocale());
        FacesMessage fm;

        if (!validatePassword())
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString("different_password"), "");
        else {
            int resultCode;

            if (customer.getCustomerID() > 0) {
                resultCode = customerController.updateCustomer(customer, user, previousUserLogin);
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, rb.getString("customer_saved"), "");
            } else {
                resultCode = customerController.registerCustomer(customer, user);
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, rb.getString("customer_registered"), "");
            }

            switch (resultCode) {
                case 0:
                    initValues(customer.getCustomerID());
                    break;
                case 1:
                    fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString("user_login_exists"), "");
                    break;
                case 2:
                    fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString("customer_not_registered"), "");
                    break;
                case 3:
                    fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString("user_not_registered"), "");
                    break;
                case 4:
                    fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString("customer_not_saved"), "");
                    break;
                case 5:
                    fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, rb.getString("user_not_saved"), "");
                    break;
            }
        }

        context.addMessage(null, fm);
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

    public CustomerController getCustomerController() {
        return customerController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SelectItem> getCityItems() {
        return cityItems;
    }

    public void setCityItems(List<SelectItem> cityItems) {
        this.cityItems = cityItems;
    }

    public List<SelectItem> getStateItems() {
        return stateItems;
    }

    public void setStateItems(List<SelectItem> stateItems) {
        this.stateItems = stateItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPreviousUserLogin() {
        return previousUserLogin;
    }

    public void setPreviousUserLogin(String previousUserLogin) {
        this.previousUserLogin = previousUserLogin;
    }
}
