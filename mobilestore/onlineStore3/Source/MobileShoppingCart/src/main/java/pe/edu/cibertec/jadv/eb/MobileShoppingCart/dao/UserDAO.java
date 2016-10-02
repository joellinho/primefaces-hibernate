/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.User;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.UserDetail;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SecurityService;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    //@NamedQuery(name = "UserDAO.findAll", query = "SELECT u FROM UserDAO u"),
    @NamedQuery(name = "UserDAO.countAll", query = "SELECT count(u) FROM UserDAO u"),
    @NamedQuery(name = "UserDAO.findByUserId", query = "SELECT u FROM UserDAO u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserDAO.findByUserLogin", query = "SELECT u FROM UserDAO u WHERE u.userLogin = :userLogin"),
    @NamedQuery(name = "UserDAO.findByCustomerId", query = "SELECT u FROM UserDAO u WHERE u.customerId = :customerId")//,
    //@NamedQuery(name = "UserDAO.findByPassword", query = "SELECT u FROM UserDAO u WHERE u.password = :password"),
    //@NamedQuery(name = "UserDAO.findByFirstName", query = "SELECT u FROM UserDAO u WHERE u.firstName = :firstName"),
    //@NamedQuery(name = "UserDAO.findByLastName", query = "SELECT u FROM UserDAO u WHERE u.lastName = :lastName")
})
public class UserDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_login")
    private String userLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Size(max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 30)
    @Column(name = "last_name")
    private String lastName;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RoleDAO role;
    @Column(name = "customer_id")
    private Integer customerId;
    /*
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CustomerDAO customer;
    */

    public UserDAO() {
    }

    public UserDAO(Integer userId) {
        this.userId = userId;
    }

    public UserDAO(Integer userId, String userLogin, String password) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.password = password;
    }

    public UserDAO(User user) {
        updateFromDTO(user);
    }
    
    public void updateFromDTO(User user) {
        this.userLogin = user.getUserLogin();
        this.password = user.getPassword();
        this.role = new RoleDAO(user.getRoleID(), SecurityService.roles.get(user.getRoleID()));
        this.firstName = user.getUserDetail().getFirstName();
        this.lastName = user.getUserDetail().getLastName();
        this.customerId = user.getUserDetail().getCustomerID();
    }
    
    public User getUserDTO() {
        UserDetail detail = new UserDetail();
        detail.setCustomerID(customerId);
        detail.setFirstName(firstName);
        detail.setLastName(lastName);
        
        User user = new User();
        user.setUserID(userId);
        user.setUserLogin(userLogin);
        user.setRoleID(role.getRoleId());
        user.setUserDetail(detail);
        
        return user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RoleDAO getRole() {
        return role;
    }

    public void setRole(RoleDAO role) {
        this.role = role;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    /*
    public CustomerDAO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDAO customer) {
        this.customer = customer;
    }
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDAO)) {
            return false;
        }
        UserDAO other = (UserDAO) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserDAO[ userId=" + userId + " ]";
    }
    
}
