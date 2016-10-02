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
@Table(name = "os")
@XmlRootElement
@NamedQuery(name = "OsDAO.findAll", query = "SELECT o FROM OsDAO o")
public class OsDAO implements Serializable, ICatalogItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "os_id")
    private Integer osId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osId", fetch = FetchType.LAZY)
//    private List<ProductDAO> productDAOList;

    public OsDAO() {
    }

    public OsDAO(Integer osId) {
        this.osId = osId;
    }

    public OsDAO(Integer osId, String name) {
        this.osId = osId;
        this.name = name;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getItemId() {
        return this.osId;
    }

    @Override
    public String getItemDescription() {
        return this.name;
    }

//    @XmlTransient
//    public List<ProductDAO> getProductDAOList() {
//        return productDAOList;
//    }
//
//    public void setProductDAOList(List<ProductDAO> productDAOList) {
//        this.productDAOList = productDAOList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osId != null ? osId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsDAO)) {
            return false;
        }
        OsDAO other = (OsDAO) object;
        if ((this.osId == null && other.osId != null) || (this.osId != null && !this.osId.equals(other.osId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OsDAO[ osId=" + osId + " ]";
    }
    
}
