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
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Customer.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.CustomerService;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SystemService;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDAO.countAll", query = "SELECT count(c) FROM CustomerDAO c"),
    @NamedQuery(name = "CustomerDAO.findAll", query = "SELECT c FROM CustomerDAO c"),
    @NamedQuery(name = "CustomerDAO.findByCustomerId", query = "SELECT c FROM CustomerDAO c WHERE c.customerId = :customerId")//,
/*
    @NamedQuery(name = "CustomerDAO.findByFirstName", query = "SELECT c FROM CustomerDAO c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CustomerDAO.findByLastName", query = "SELECT c FROM CustomerDAO c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CustomerDAO.findByDocumentNumber", query = "SELECT c FROM CustomerDAO c WHERE c.documentNumber = :documentNumber"),
*/
/*
    @NamedQuery(name = "CustomerDAO.findByAddress", query = "SELECT c FROM CustomerDAO c WHERE c.address = :address"),
    @NamedQuery(name = "CustomerDAO.findByPhone", query = "SELECT c FROM CustomerDAO c WHERE c.phone = :phone"),
    @NamedQuery(name = "CustomerDAO.findByMobile", query = "SELECT c FROM CustomerDAO c WHERE c.mobile = :mobile"),
    @NamedQuery(name = "CustomerDAO.findByEmail1", query = "SELECT c FROM CustomerDAO c WHERE c.email1 = :email1"),
    @NamedQuery(name = "CustomerDAO.findByEmail2", query = "SELECT c FROM CustomerDAO c WHERE c.email2 = :email2"),
    @NamedQuery(name = "CustomerDAO.findByFacebook", query = "SELECT c FROM CustomerDAO c WHERE c.facebook = :facebook"),
    @NamedQuery(name = "CustomerDAO.findByLinkedin", query = "SELECT c FROM CustomerDAO c WHERE c.linkedin = :linkedin"),
    @NamedQuery(name = "CustomerDAO.findByTwitter", query = "SELECT c FROM CustomerDAO c WHERE c.twitter = :twitter")
*/
})
public class CustomerDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "document_type_id")
    private Integer documentTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "document_number")
    private String documentNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "mobile")
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "email1")
    private String email1;
    @Basic(optional = false)
    @Size(min = 1, max = 120)
    @Column(name = "email2")
    private String email2;
    @Basic(optional = false)
    @Size(min = 1, max = 120)
    @Column(name = "facebook")
    private String facebook;
    @Basic(optional = false)
    @Size(min = 1, max = 120)
    @Column(name = "linkedin")
    private String linkedin;
    @Basic(optional = false)
    @Size(min = 1, max = 120)
    @Column(name = "twitter")
    private String twitter;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private StateDAO state;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CityDAO city;
/*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<PoDAO> poDAOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<UserDAO> userDAOList;
*/

    public CustomerDAO() {
    }

    public CustomerDAO(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerDAO(Integer customerId, String firstName, String lastName, Integer documentTypeId, String documentNumber, String address, String phone, String mobile, String email1, String email2, String facebook, String linkedin, String twitter) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.address = address;
        this.phone = SystemService.getDBValue(phone);
        this.mobile = mobile;
        this.email1 = email1;
        this.email2 = SystemService.getDBValue(email2);
        this.facebook = SystemService.getDBValue(facebook);
        this.linkedin = SystemService.getDBValue(linkedin);
        this.twitter = SystemService.getDBValue(twitter);
    }

    public CustomerDAO(Customer customer) {
        updateFromDTO(customer);
    }
    
    public void updateFromDTO(Customer customer) {
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.documentTypeId = customer.getDocType();
        this.documentNumber = customer.getDocID();
        
        CustomerAddress customerAddress = customer.getCustomerAddress();
        this.address = customerAddress.getAddress();
        String itemName = CustomerService.cities.get(customerAddress.getCity());
        this.city = new CityDAO(customerAddress.getCity(), itemName);
        itemName = CustomerService.states.get(customerAddress.getState());
        this.state = new StateDAO(customerAddress.getState(), itemName);
        
        CustomerVirtual virtual = customer.getCustomerVirtual();
        this.phone = SystemService.getDBValue(virtual.getPhone());
        this.mobile = virtual.getMobile();
        this.email1 = virtual.getEmail1();
        this.email2 = SystemService.getDBValue(virtual.getEmail2());
        this.facebook = SystemService.getDBValue(virtual.getFacebook());
        this.linkedin = SystemService.getDBValue(virtual.getLinkedin());
        this.twitter = SystemService.getDBValue(virtual.getTwitter());
    }

    public Customer getCustomerDTO() {        
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setAddress(address);
        customerAddress.setCity(city.getCityId());
        customerAddress.setState(state.getStateId());
        
        CustomerVirtual virtual = new CustomerVirtual();
        virtual.setPhone(phone);
        virtual.setMobile(mobile);
        virtual.setEmail1(email1);
        virtual.setEmail2(email2);
        virtual.setFacebook(facebook);
        virtual.setLinkedin(linkedin);
        virtual.setTwitter(twitter);
        
        Customer customer = new Customer();
        customer.setCustomerID(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setDocType(documentTypeId);
        customer.setDocID(documentNumber);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerVirtual(virtual);
        
        return customer;        
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public StateDAO getState() {
        return state;
    }

    public void setState(StateDAO state) {
        this.state = state;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public CityDAO getCity() {
        return city;
    }

    public void setCity(CityDAO city) {
        this.city = city;
    }
/*
    @XmlTransient
    public List<PoDAO> getPoDAOList() {
        return poDAOList;
    }

    public void setPoDAOList(List<PoDAO> poDAOList) {
        this.poDAOList = poDAOList;
    }

    @XmlTransient
    public List<UserDAO> getUserDAOList() {
        return userDAOList;
    }

    public void setUserDAOList(List<UserDAO> userDAOList) {
        this.userDAOList = userDAOList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDAO)) {
            return false;
        }
        CustomerDAO other = (CustomerDAO) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerDAO[ customerId=" + customerId + " ]";
    }
    
}
