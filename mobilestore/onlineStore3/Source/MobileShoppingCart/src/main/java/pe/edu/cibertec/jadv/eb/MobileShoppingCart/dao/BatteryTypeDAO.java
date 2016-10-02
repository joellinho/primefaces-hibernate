/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "battery_type")
@XmlRootElement
@NamedQuery(name = "BatteryTypeDAO.findAll", query = "SELECT b FROM BatteryTypeDAO b")
public class BatteryTypeDAO implements Serializable, ICatalogItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "battery_type_id")
    private Integer batteryTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batteryType", fetch = FetchType.LAZY)
//    private List<BatteryDAO> batteryDAOList;

    public BatteryTypeDAO() {
    }

    public BatteryTypeDAO(Integer batteryTypeId) {
        this.batteryTypeId = batteryTypeId;
    }

    public BatteryTypeDAO(Integer batteryTypeId, String name) {
        this.batteryTypeId = batteryTypeId;
        this.name = name;
    }

    public Integer getBatteryTypeId() {
        return batteryTypeId;
    }

    public void setBatteryTypeId(Integer batteryTypeId) {
        this.batteryTypeId = batteryTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @XmlTransient
//    public List<BatteryDAO> getBatteryDAOList() {
//        return batteryDAOList;
//    }
//
//    public void setBatteryDAOList(List<BatteryDAO> batteryDAOList) {
//        this.batteryDAOList = batteryDAOList;
//    }

    @Override
    public Integer getItemId() {
        return this.batteryTypeId;
    }

    @Override
    public String getItemDescription() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batteryTypeId != null ? batteryTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatteryTypeDAO)) {
            return false;
        }
        BatteryTypeDAO other = (BatteryTypeDAO) object;
        if ((this.batteryTypeId == null && other.batteryTypeId != null) || (this.batteryTypeId != null && !this.batteryTypeId.equals(other.batteryTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BatteryTypeDAO[ batteryTypeId=" + batteryTypeId + " ]";
    }
    
}
