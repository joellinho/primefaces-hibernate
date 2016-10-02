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
@Table(name = "brand")
@XmlRootElement
@NamedQuery(name = "BrandDAO.findAll", query = "SELECT b FROM BrandDAO b")
public class BrandDAO implements Serializable, ICatalogItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brand_id")
    private Integer brandId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandId", fetch = FetchType.LAZY)
//    private List<ProductDAO> productDAOList;

    public BrandDAO() {
    }

    public BrandDAO(Integer brandId) {
        this.brandId = brandId;
    }

    public BrandDAO(Integer brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getItemId() {
        return this.brandId;
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
        hash += (brandId != null ? brandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandDAO)) {
            return false;
        }
        BrandDAO other = (BrandDAO) object;
        if ((this.brandId == null && other.brandId != null) || (this.brandId != null && !this.brandId.equals(other.brandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BrandDAO[ brandId=" + brandId + " ]";
    }
    
}
