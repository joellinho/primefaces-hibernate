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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Screen;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.ProductService;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SystemService;

/**
 *
 * @author u14138
 */
//@Entity
//@Table(name = "screen")
//@XmlRootElement
@Embeddable
public class ScreenDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "resolution")
    private String resolution;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "size")
    private Double size;
//    @Id
    //@Basic(optional = false)
    //@NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "product_id")
//    private Integer productId;
    @JoinColumn(name = "screen_type_id", referencedColumnName = "screen_type_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ScreenTypeDAO screenType;
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.EAGER)
//    private ProductDAO productDAO;

    public ScreenDAO() {
    }

//    public ScreenDAO(Integer productId) {
//        this.productId = productId;
//    }
    
//    public ScreenDAO(ProductDAO productDAO) {
//        this.productId = productDAO.getProductId();
//        this.productDAO = productDAO;
//    }

    public ScreenDAO(Screen s) {
        updateFromDTO(s);
    }
    
    public void updateFromDTO(Screen s) {
        this.resolution = s.getResolution();
        this.size = s.getSize();
        this.screenType = new ScreenTypeDAO(SystemService.findMapKey(ProductService.screenTypes, s.getType()), s.getType());
    }

    public Screen getDTO() {
        Screen s = new Screen();
        s.setResolution(resolution);
        s.setSize(size);
        s.setType(screenType.getItemDescription());
        
        return s;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

//    public Integer getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }

    public ScreenTypeDAO getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenTypeDAO screenType) {
        this.screenType = screenType;
    }

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
//        if (!(object instanceof ScreenDAO)) {
//            return false;
//        }
//        ScreenDAO other = (ScreenDAO) object;
//        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "ScreenDAO[ productId=" + productId + " ]";
//    }
    
}
