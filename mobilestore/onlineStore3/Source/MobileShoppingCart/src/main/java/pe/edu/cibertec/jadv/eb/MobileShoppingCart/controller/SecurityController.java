/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SecurityService;

/**
 *
 * @author Java_VS
 */
@ManagedBean(name = "securityController")
@SessionScoped
public class SecurityController {

    public static final String DEFAULT_PASSWORD = SecurityService.DEFAULT_PASSWORD;
    private String contextPath;
    private User user;

    @PostConstruct
    public void init() {
        contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        user = null;
    }

    public void goToPage(String relativeUrl) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + relativeUrl);
    }

    public void login() throws IOException {
        if (user != null) {
            if (isAdmin()) {
                goToPage("/order/listOrders.xhtml");
            } else {
                goToPage("/product/searchProduct.xhtml");
            }
        }
    }

    public void validateSession() throws IOException {
        if (user == null) {
            goToPage("/security/login.xhtml");
        }
    }

    public User authenticate(UserLogin userLogin) {
        SecurityService security = new SecurityService();
        user = security.authenticate(userLogin);
        return user;
    }

    public String logout() {
        user = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    public boolean isAdmin() {
        return user != null && user.getRoleID() == 1;
    }

    public String getUserFullName() {
        UserDetail userDetail = user.getUserDetail();
        return userDetail.getFirstName() + " " + userDetail.getLastName();
    }

    public Integer getCustomerID() {
        UserDetail userDetail = user.getUserDetail();
        return userDetail.getCustomerID();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserByCustomerID(int customerID) {
        SecurityService service = new SecurityService();
        return service.getUserByCustomerID(customerID);
    }

    public boolean validateUserLogin(String userLogin, int customerID) {
        SecurityService service = new SecurityService();
        return service.validateUserLogin(userLogin, customerID);
    }

    public boolean registerUser(User user) {
        SecurityService service = new SecurityService();
        return service.registerUser(user);
    }
    
    public boolean updateUser(String previousUserLogin, User user) {
        SecurityService service = new SecurityService();
        return service.updateUser(previousUserLogin, user);
    }
}
