/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.UserDAO;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer.Customer;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.*;

/**
 *
 * @author Kike
 */
public class SecurityService extends BaseService {

    public static final String DEFAULT_PASSWORD = "xxxxxxxxxx";
    public static HashMap<String, User> users = new HashMap<>();
    public static HashMap<Integer, String> roles = new HashMap<>();

//    public static void initRoles() {
//        roles.put(1, "Administrator");
//        roles.put(2, "Customer");
//    }

    public static void loadCatalogs() {
        EntityManager em = SystemService.createEntityManager();
        SystemService.loadCatalog(em, roles, "RoleDAO.findAll");
        
//        Query q = em.createNamedQuery("RoleDAO.findAll");
//        List<RoleDAO> roleList = q.getResultList();
//
//        if (roleList.isEmpty()) {
//            initRoles();
//
//            em.getTransaction().begin();
//            for (int id : roles.keySet()) {
//                RoleDAO role = new RoleDAO(id, roles.get(id));
//                em.persist(role);
//            }
//            em.getTransaction().commit();
//        } else {
//            for (RoleDAO role : roleList) {
//                roles.put(role.getRoleId(), role.getName());
//            }
//        }

        em.close();
    }

    public static void initUsers() {
        // Creating user admin
        User user = new User();
        user.setUserID(SystemService.generateID("user"));
        user.setUserLogin("ebassallo");
        user.setPassword("P@ssw0rd");
        user.setRoleID(1);
        UserDetail userDetail = new UserDetail();
        userDetail.setFirstName("Enrique");
        userDetail.setLastName("Bassallo");
        user.setUserDetail(userDetail);
        users.put("ebassallo", user);

        CustomerService customerService = new CustomerService();
        customerService.initConnection();

        // Creating user customer 1
        user = new User();
        user.setUserID(SystemService.generateID("user"));
        user.setUserLogin("kinga");
        user.setPassword("P@ssw0rd");
        user.setRoleID(2);
        Customer customer = customerService.getCustomer(1, true);
        userDetail = new UserDetail();
        userDetail.setCustomerID(customer.getCustomerID());
        userDetail.setFirstName(customer.getFirstName());
        userDetail.setLastName(customer.getLastName());
        user.setUserDetail(userDetail);
        users.put("kinga", user);

        // Creating user customer 2
        user = new User();
        user.setUserID(SystemService.generateID("user"));
        user.setUserLogin("tbassallo");
        user.setPassword("P@ssw0rd");
        user.setRoleID(2);
        customer = customerService.getCustomer(2, true);
        userDetail = new UserDetail();
        userDetail.setCustomerID(customer.getCustomerID());
        userDetail.setFirstName(customer.getFirstName());
        userDetail.setLastName(customer.getLastName());
        user.setUserDetail(userDetail);
        users.put("tbassallo", user);
        
        customerService.closeConnection();
    }

    public static void loadUsers() {
        EntityManager em = SystemService.createEntityManager();
        Query q = em.createNamedQuery("UserDAO.countAll");
        Long size = (Long) q.getSingleResult();

        if (size == 0) {
            try {
                initUsers();

                em.getTransaction().begin();
                for (String userLogin : users.keySet()) {
                    User user = users.get(userLogin);
                    UserDAO userDAO = new UserDAO(user);
                    em.persist(userDAO);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }

        em.close();
    }

    static {
        //initRoles();
        //initUsers();
        loadCatalogs();
        loadUsers();
    }

//    private void fillUser(User userBase, User userClone) {
//        userClone.setUserID(userBase.getUserID());
//        userClone.setUserLogin(userBase.getUserLogin());
//        userClone.setPassword(userBase.getPassword());
//        userClone.setRoleID(userBase.getRoleID());
//        
//        UserDetail detail = userClone.getUserDetail(); 
//        detail.setCustomerID(userBase.getUserDetail().getCustomerID());
//        detail.setFirstName(userBase.getUserDetail().getFirstName());
//        detail.setLastName(userBase.getUserDetail().getLastName());
//    }
//
//    private User loadUser(User user) {
//        if (user == null)
//            return null;
//        
//        User result = new User();
//        UserDetail detail = new UserDetail();   
//        result.setUserDetail(detail);
//        fillUser(user, result);
//        return result;
//    }
//    public User authenticate(UserLogin userLogin) {
//        User user = loadUser(users.get(userLogin.getUserLogin()));
//
//        if (user != null && user.getPassword().equals(userLogin.getPassword())) {
//            user.setPassword(null);
//            return user;
//        }
//
//        return null;
//    }
    private UserDAO findByUserLogin(String userLogin) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("userLogin", userLogin);
        return (UserDAO) getSingleResult("UserDAO.findByUserLogin", params);
    }

    public User authenticate(UserLogin userLogin) {
        UserDAO userDAO = findByUserLogin(userLogin.getUserLogin());

        if (userDAO != null && userDAO.getPassword().equals(userLogin.getPassword())) {
            return userDAO.getUserDTO();
        }

        return null;
    }

//    public User getUserByCustomerID(int customerID) {
//        for (String userLogin : users.keySet()) {
//            User user = users.get(userLogin);
//            if (user.getUserDetail().getCustomerID() == customerID)
//                return loadUser(user);
//        }
//        
//        return null;
//    }
    public User getUserByCustomerID(int customerID) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("customerId", customerID);
        UserDAO userDAO = (UserDAO) getSingleResult("UserDAO.findByCustomerId", params);

        if (userDAO != null) {
            return userDAO.getUserDTO();
        }

        return null;
    }

//    public boolean validateUserLogin(String userLogin, int customerID) {
//        if (userLogin == null || "".equals(userLogin))
//            return false;
//        
//        User user = users.get(userLogin);        
//        return user == null || (user.getUserLogin().equals(userLogin) && user.getUserDetail().getCustomerID() == customerID);
//    }
    public boolean validateUserLogin(String userLogin, int customerID) {
        if (userLogin == null || "".equals(userLogin)) {
            return false;
        }

        UserDAO userDAO = findByUserLogin(userLogin);
        return userDAO == null || (userDAO.getUserLogin().equals(userLogin) && userDAO.getCustomerId() == customerID);
    }

//    public boolean registerUser(User user) {
//        user.setUserID(SystemService.generateID("user"));
//        User newUser = new User();
//        UserDetail detail = new UserDetail();
//        newUser.setUserDetail(detail);
//        fillUser(user, newUser);
//        users.put(newUser.getUserLogin(), newUser);
//        return true;
//    }
    
    public boolean registerUser(User user) {
        try {
            UserDAO userDAO = new UserDAO(user);
            initTransaction();
            getEntityManager().persist(userDAO);
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            return false;
        }

        return true;
    }

//    public boolean updateUser(String previousUserLogin, User user) {
//        User previousUser = users.remove(previousUserLogin);
//
//        if (user.getPassword().equals(DEFAULT_PASSWORD)) {
//            user.setPassword(previousUser.getPassword());
//        }
//
//        User updatedUser = new User();
//        UserDetail detail = new UserDetail();
//        updatedUser.setUserDetail(detail);
//        fillUser(user, updatedUser);
//        users.put(updatedUser.getUserLogin(), updatedUser);
//        return true;
//    }

    public boolean updateUser(String previousUserLogin, User user) {
        UserDAO userDAO = findByUserLogin(previousUserLogin);
        
        if (user.getPassword().equals(DEFAULT_PASSWORD)) {
            user.setPassword(userDAO.getPassword());
        }
        
        try {
            userDAO.updateFromDTO(user);
            initTransaction();
            getEntityManager().merge(userDAO);
            commitTransaction();
        }
        catch(Exception e) {
            rollbackTransaction();
            return false;
        }
        
        return true;
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static void setUsers(HashMap<String, User> users) {
        SecurityService.users = users;
    }

    public static HashMap<Integer, String> getRoles() {
        return roles;
    }

    public static void setRoles(HashMap<Integer, String> roles) {
        SecurityService.roles = roles;
    }
}
