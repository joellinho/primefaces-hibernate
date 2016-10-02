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
@Table(name = "city")
@XmlRootElement
@NamedQuery(name = "CityDAO.findAll", query = "SELECT c FROM CityDAO c")
public class CityDAO implements Serializable, ICatalogItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city", fetch = FetchType.LAZY)
//    private List<CustomerDAO> customerDAOList;

    public CityDAO() {
    }

    public CityDAO(Integer cityId) {
        this.cityId = cityId;
    }

    public CityDAO(Integer cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getItemId() {
        return this.getCityId();
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
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityDAO)) {
            return false;
        }
        CityDAO other = (CityDAO) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CityDAO[ cityId=" + cityId + " ]";
    }
    
}
