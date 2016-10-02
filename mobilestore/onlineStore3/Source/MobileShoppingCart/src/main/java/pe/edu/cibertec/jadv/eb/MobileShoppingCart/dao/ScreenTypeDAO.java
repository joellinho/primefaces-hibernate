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
@Table(name = "screen_type")
@XmlRootElement
@NamedQuery(name = "ScreenTypeDAO.findAll", query = "SELECT s FROM ScreenTypeDAO s")
public class ScreenTypeDAO implements Serializable, ICatalogItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "screen_type_id")
    private Integer screenTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screenType", fetch = FetchType.EAGER)
//    private List<ScreenDAO> screenDAOList;

    public ScreenTypeDAO() {
    }

    public ScreenTypeDAO(Integer screenTypeId) {
        this.screenTypeId = screenTypeId;
    }

    public ScreenTypeDAO(Integer screenTypeId, String name) {
        this.screenTypeId = screenTypeId;
        this.name = name;
    }

    public Integer getScreenTypeId() {
        return screenTypeId;
    }

    public void setScreenTypeId(Integer screenTypeId) {
        this.screenTypeId = screenTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @XmlTransient
//    public List<ScreenDAO> getScreenDAOList() {
//        return screenDAOList;
//    }
//
//    public void setScreenDAOList(List<ScreenDAO> screenDAOList) {
//        this.screenDAOList = screenDAOList;
//    }

    @Override
    public Integer getItemId() {
        return this.screenTypeId;
    }

    @Override
    public String getItemDescription() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (screenTypeId != null ? screenTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScreenTypeDAO)) {
            return false;
        }
        ScreenTypeDAO other = (ScreenTypeDAO) object;
        if ((this.screenTypeId == null && other.screenTypeId != null) || (this.screenTypeId != null && !this.screenTypeId.equals(other.screenTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.ScreenTypeDAO[ screenTypeId=" + screenTypeId + " ]";
    }
    
}
