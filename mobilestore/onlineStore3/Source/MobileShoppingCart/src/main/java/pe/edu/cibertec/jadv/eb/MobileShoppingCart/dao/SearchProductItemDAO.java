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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.SearchProductItem;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "product")
public class SearchProductItemDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BrandDAO brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "model")
    private String model;
    @JoinColumn(name = "os_id", referencedColumnName = "os_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OsDAO os;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "image_url")
    private String imageUrl;

    public SearchProductItemDAO() {
    }

    public SearchProductItemDAO(Integer productId, BrandDAO brand, String model, OsDAO os, Double price, String imageUrl) {
        this.productId = productId;
        this.model = model;
        this.price = price;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.os = os;        
    }

    public SearchProductItem getDTO() {
        SearchProductItem item = new SearchProductItem();
        item.setProductID(productId);
        item.setBrand(brand.getItemDescription());
        item.setModel(model);
        item.setOs(os.getItemDescription());
        item.setPrice(price);
        item.setImageUrl(imageUrl);
        item.setAddedToOrder(false);

        return item;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public OsDAO getOs() {
        return os;
    }

    public void setOs(OsDAO os) {
        this.os = os;
    }

    public BrandDAO getBrand() {
        return brand;
    }

    public void setBrand(BrandDAO brand) {
        this.brand = brand;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchProductItemDAO)) {
            return false;
        }
        SearchProductItemDAO other = (SearchProductItemDAO) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SearchProductItemDAO[ productId=" + productId + " ]";
    }

}
