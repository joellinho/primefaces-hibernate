/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Technology;

/**
 *
 * @author u14138
 */
//@Entity
//@Table(name = "technology")
//@XmlRootElement
@Embeddable
public class TechnologyDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "edge")
    private Boolean edge;
    @Column(name = "gprs")
    private Boolean gprs;
    @Column(name = "gsm")
    private Boolean gsm;
    @Column(name = "hsdpa")
    private Boolean hsdpa;
    @Column(name = "hspa_plus")
    private Boolean hspaPlus;
    @Column(name = "lte")
    private Boolean lte;
//    @Id
    //@Basic(optional = false)
    //@NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "product_id")
//    private Integer productId;
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.EAGER)
//    private ProductDAO productDAO;

    public TechnologyDAO() {
    }

//    public TechnologyDAO(Integer productId) {
//        this.productId = productId;
//    }

//    public TechnologyDAO(ProductDAO productDAO) {
//        this.productId = productDAO.getProductId();
//        this.productDAO = productDAO;
//    }

    public TechnologyDAO(Technology t) {
        updateFromDTO(t);
    }
    
    public void updateFromDTO(Technology t) {
        this.edge = t.isEdge();
        this.gprs = t.isGprs();
        this.gsm = t.isGsm();
        this.hsdpa = t.isHsdpa();
        this.hspaPlus = t.isHspaPlus();
        this.lte = t.isLte();
    }

    public Technology getDTO() {
        Technology t = new Technology();
        t.setEdge(edge);
        t.setGprs(gprs);
        t.setGsm(gsm);
        t.setHsdpa(hsdpa);
        t.setHspaPlus(hspaPlus);
        t.setLte(lte);
        
        return t;
    }

    public Boolean getEdge() {
        return edge;
    }

    public void setEdge(Boolean edge) {
        this.edge = edge;
    }

    public Boolean getGprs() {
        return gprs;
    }

    public void setGprs(Boolean gprs) {
        this.gprs = gprs;
    }

    public Boolean getGsm() {
        return gsm;
    }

    public void setGsm(Boolean gsm) {
        this.gsm = gsm;
    }

    public Boolean getHsdpa() {
        return hsdpa;
    }

    public void setHsdpa(Boolean hsdpa) {
        this.hsdpa = hsdpa;
    }

    public Boolean getHspaPlus() {
        return hspaPlus;
    }

    public void setHspaPlus(Boolean hspaPlus) {
        this.hspaPlus = hspaPlus;
    }

    public Boolean getLte() {
        return lte;
    }

    public void setLte(Boolean lte) {
        this.lte = lte;
    }

//    public Integer getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }

//    public ProductDAO getProductDAO() {
//        return productDAO;
//    }
//
//    public void setProductDAO(ProductDAO productDAO) {
//        this.productDAO = productDAO;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (productId != null ? productId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof TechnologyDAO)) {
//            return false;
//        }
//        TechnologyDAO other = (TechnologyDAO) object;
//        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "TechnologyDAO[ productId=" + productId + " ]";
//    }
    
}
