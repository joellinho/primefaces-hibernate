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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "state")
@XmlRootElement
@NamedQuery(name = "StateDAO.findAll", query = "SELECT s FROM StateDAO s")
public class StateDAO implements Serializable, ICatalogItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "state_id")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state", fetch = FetchType.LAZY)
//    private List<CustomerDAO> customerDAOList;

    public StateDAO() {
    }

    public StateDAO(Integer stateId) {
        this.stateId = stateId;
    }

    public StateDAO(Integer stateId, String name) {
        this.stateId = stateId;
        this.name = name;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getItemId() {
        return this.stateId;
    }

    @Override
    public String getItemDescription() {
        return this.name;
    }

//    @XmlTransient
//    public List<CustomerDAO> getCustomerDAOList() {
//        return customerDAOList;
//    }
//
//    public void setCustomerDAOList(List<CustomerDAO> customerDAOList) {
//        this.customerDAOList = customerDAOList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateDAO)) {
            return false;
        }
        StateDAO other = (StateDAO) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StateDAO[ stateId=" + stateId + " ]";
    }
    
}
