/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.CustomerDAO;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer.*;
import static pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SystemService.createEntityManager;

/**
 *
 * @author u14138
 */
public class CustomerService extends BaseService {

    public static HashMap<Integer, Customer> customers = new HashMap<>();
    public static HashMap<Integer, String> cities = new HashMap<>();
    public static HashMap<Integer, String> states = new HashMap<>();

//    public static void initCities() {
//        cities.put(1, "Lima");
//        cities.put(2, "Miraflores");
//        cities.put(3, "Punta Sal");
//        cities.put(4, "Trujillo");
//        cities.put(5, "Chiclayo");
//        cities.put(6, "Surco");
//        cities.put(7, "Mancora");
//        cities.put(8, "Tarapoto");
//        cities.put(9, "Casma");
//        cities.put(10, "Paracas");
//    }
//
//    public static void initStates() {
//        states.put(1, "Lima");
//        states.put(2, "Ancash");
//        states.put(3, "La Libertad");
//        states.put(4, "Lambayeque");
//        states.put(5, "Ica");
//        states.put(6, "Tumbes");
//        states.put(7, "Piura");
//        states.put(8, "San Martin");
//    }

    public static void loadCatalogs() {
        EntityManager em = createEntityManager();
        SystemService.loadCatalog(em, cities, "CityDAO.findAll");
        SystemService.loadCatalog(em, states, "StateDAO.findAll");
        em.close();
    }

    public static CustomerAddress createCustomerAddress(String street, int city, int state) {
        CustomerAddress address = new CustomerAddress();
        address.setAddress(street);
        address.setCity(city);
        address.setState(state);
        return address;
    }

    public static CustomerVirtual createCustomerVirtual(int customerID) {
        CustomerVirtual virtual = new CustomerVirtual();
        virtual.setEmail1("customer" + customerID + ".main@jsf.org");
        virtual.setEmail2("customer" + customerID + ".auxiliar@jsf.org");
        virtual.setFacebook("https://facebook.com/customer" + customerID);
        virtual.setLinkedin("https://pe.linkedin.com/in/customer" + customerID);
        virtual.setMobile("11111111" + customerID);
        virtual.setPhone("111111" + customerID);
        virtual.setTwitter("https://twitter.com/#!/customer" + customerID);
        return virtual;
    }

    public static Customer createCustomer(String firstName, String lastName) {
        Customer customer = new Customer();
        int customerID = SystemService.generateID("customer");
        customer.setCustomerID(customerID);
        customer.setCustomerVirtual(createCustomerVirtual(customerID));
        customer.setCustomerAddress(createCustomerAddress("Address-Customer" + customerID, customerID, 1));
        customer.setDocType(1);
        customer.setDocID("1111111" + customerID);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customers.put(customerID, customer);
        return customer;
    }

    public static void initCustomers() {
        createCustomer("Karina", "Inga");
        createCustomer("Tiziana", "Bassallo");
        // Total: 2 customers
    }

    public static void loadCustomers() {
        EntityManager em = SystemService.createEntityManager();
        Query q = em.createNamedQuery("CustomerDAO.countAll");
        Long size = (Long) q.getSingleResult();

        if (size == 0) {
            try {
                initCustomers();

                em.getTransaction().begin();
                for (Integer customerID : customers.keySet()) {
                    CustomerDAO customerDAO = new CustomerDAO(customers.get(customerID));
                    em.persist(customerDAO);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }

        em.close();
    }

    static {
        //initCities();
        //initStates();
        //initCustomers();
        loadCatalogs();
        loadCustomers();
    }

//    private void fillCustomer(Customer customerBase, Customer customerClone) {
//        customerClone.setCustomerID(customerBase.getCustomerID());
//        customerClone.setDocID(customerBase.getDocID());
//        customerClone.setDocType(customerBase.getDocType());
//        customerClone.setFirstName(customerBase.getFirstName());
//        customerClone.setLastName(customerBase.getLastName());
//
//        CustomerAddress customerAddress = customerClone.getCustomerAddress();
//        customerAddress.setAddress(customerBase.getCustomerAddress().getAddress());
//        customerAddress.setCity(customerBase.getCustomerAddress().getCity());
//        customerAddress.setState(customerBase.getCustomerAddress().getState());
//
//        CustomerVirtual customerVirtual = customerClone.getCustomerVirtual();
//        customerVirtual.setEmail1(customerBase.getCustomerVirtual().getEmail1());
//        customerVirtual.setEmail2(customerBase.getCustomerVirtual().getEmail2());
//        customerVirtual.setFacebook(customerBase.getCustomerVirtual().getFacebook());
//        customerVirtual.setLinkedin(customerBase.getCustomerVirtual().getLinkedin());
//        customerVirtual.setMobile(customerBase.getCustomerVirtual().getMobile());
//        customerVirtual.setPhone(customerBase.getCustomerVirtual().getPhone());
//        customerVirtual.setTwitter(customerBase.getCustomerVirtual().getTwitter());
//    }

    /*
    public List<Customer> getCustomerList() {
        ArrayList result = new ArrayList(customers.size());

        for (Integer customerID : customers.keySet()) {
            result.add(customers.get(customerID));
        }

        return result;
    }
    */

    public List<Customer> getCustomerList() {
        List<CustomerDAO> list = (List<CustomerDAO>)getResultList("CustomerDAO.findAll", null);
        List<Customer> result = new ArrayList<>(list.size());
        
        for (CustomerDAO customer : list) {
            result.add(customer.getCustomerDTO());
        }
        
        return result;
    }
    
    /*
    public Customer getCustomer(int customerID) {
        Customer customerDB = CustomerService.customers.get(customerID);
        Customer customer = new Customer();
        CustomerAddress customerAddress = new CustomerAddress();
        CustomerVirtual customerVirtual = new CustomerVirtual();
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerVirtual(customerVirtual);
        fillCustomer(customerDB, customer);
        return customer;
    }
    */
    
    public Customer getCustomer(int customerID) {
        return getCustomer(customerID, false);
    }

    public Customer getCustomer(int customerID, boolean connectionExists) {
        CustomerDAO customerDAO = (CustomerDAO)findById(CustomerDAO.class, customerID, connectionExists);
        
        if (customerDAO != null)
            return customerDAO.getCustomerDTO();
        
        return null;
    }

    public boolean registerCustomer(Customer customer) {
        try {
            CustomerDAO customerDAO = new CustomerDAO(customer);
            initTransaction();
            getEntityManager().persist(customerDAO);
            commitTransaction();
            customer.setCustomerID(customerDAO.getCustomerId());
        }
        catch(Exception e) {
            rollbackTransaction();
            return false;
        }

        return true;
    }

    public boolean updateCustomer(Customer customer) {
        try {            
            CustomerDAO customerDAO = (CustomerDAO)findById(CustomerDAO.class, customer.getCustomerID());
            customerDAO.updateFromDTO(customer);
            initTransaction();
            getEntityManager().merge(customerDAO);
            commitTransaction();
        }
        catch(Exception e) {
            rollbackTransaction();
            return false;
        }

        return true;
    }

    public static HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(HashMap<Integer, Customer> customers) {
        CustomerService.customers = customers;
    }

    public static HashMap<Integer, String> getCities() {
        return cities;
    }

    public static void setCities(HashMap<Integer, String> cities) {
        CustomerService.cities = cities;
    }

    public static HashMap<Integer, String> getStates() {
        return states;
    }

    public static void setStates(HashMap<Integer, String> states) {
        CustomerService.states = states;
    }
}
