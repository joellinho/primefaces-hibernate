/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "customer")
public class CustomerGeneralDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "customer_id")
    private Integer customerId;
    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 1, max = 30)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "document_type_id")
    private Integer documentTypeId;
    @Size(min = 1, max = 20)
    @Column(name = "document_number")
    private String documentNumber;
    @Size(min = 1, max = 20)
    @Column(name = "mobile")
    private String mobile;
    @Size(min = 1, max = 120)
    @Column(name = "email1")
    private String email1;

    public CustomerGeneralDAO() {
    }

    public CustomerGeneralDAO(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerGeneralDAO(Integer customerId, String firstName, String lastName, Integer documentTypeId, String documentNumber, String mobile, String email1) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.mobile = mobile;
        this.email1 = email1;
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

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerGeneralDAO)) {
            return false;
        }
        CustomerGeneralDAO other = (CustomerGeneralDAO) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerGeneralDAO[ customerId=" + customerId + " ]";
    }
    
}
