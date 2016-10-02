/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.view;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.SecurityController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.User;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.UserLogin;

/**
 *
 * @author Kike
 */
@ManagedBean(name = "loginView")
@ViewScoped
public class LoginView {

    private String contextPath;
    private UserLogin userLogin;
    
    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;
    
    @PostConstruct
    public void init() {
        contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
        userLogin = new UserLogin();        
    }
    
    public String authenticate() {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        //System.out.println("Locale: " + locale.getLanguage());
        ResourceBundle rb = ResourceBundle.getBundle("messages", locale);
        User user = securityController.authenticate(userLogin);
        
        if (user == null) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    rb.getString("incorrect_login_summary"),
                    rb.getString("incorrect_login_detail"));
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return null;
        }
        
        userLogin = null;
        
        if (securityController.isAdmin())
            return "orders";
        
        return "searchProduct";
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

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
}
