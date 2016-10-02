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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.OrderItem;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "po_item")
@XmlRootElement
public class PoItemDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "po_item_id")
    private Integer poItemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price")
    private Double unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private Double subTotal;
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    @ManyToOne(optional = false, fetch = FetchType.EAGER)
//    private SearchProductItemDAO product;
//    @JoinColumn(name = "po_id", referencedColumnName = "po_id")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private PoDAO poId;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "po_id")
    private Integer poId;

    public PoItemDAO() {
    }

    public PoItemDAO(Integer poItemId) {
        this.poItemId = poItemId;
    }

    public PoItemDAO(Integer poItemId, Integer quantity, Double unitPrice, Double subTotal) {
        this.poItemId = poItemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
    }

    public PoItemDAO(OrderItem item) {
        //this.poItemId = item.getItemID();
        updateFromDTO(item);
    }
    
    public void updateFromDTO(OrderItem item) {
        this.quantity = item.getQuantity();
        this.unitPrice = item.getUnitPrice();
        this.subTotal = item.getSubTotal();
        this.productId = item.getProductID();
        //this.poId = orderID;
    }
    
    public OrderItem getDTO() {
        OrderItem item = new OrderItem();
        item.setItemID(this.poItemId);
        item.setProductID(this.productId);
        item.setQuantity(this.quantity);
        item.setSubTotal(this.subTotal);
        item.setUnitPrice(this.unitPrice);
        //item.setProduct(product.getDTO());
        
        return item;
    }

    public Integer getPoItemId() {
        return poItemId;
    }

    public void setPoItemId(Integer poItemId) {
        this.poItemId = poItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

//    public SearchProductItemDAO getProduct() {
//        return product;
//    }
//
//    public void setProduct(SearchProductItemDAO product) {
//        this.product = product;
//    }

//    public ProductDAO getProductDAO() {
//        return product;
//    }
//
//    public void setProductDAO(ProductDAO product) {
//        this.product = product;
//    }

//    public PoDAO getPoId() {
//        return poId;
//    }
//
//    public void setPoId(PoDAO poId) {
//        this.poId = poId;
//    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (poItemId != null ? poItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoItemDAO)) {
            return false;
        }
        PoItemDAO other = (PoItemDAO) object;
        if ((this.poItemId == null && other.poItemId != null) || (this.poItemId != null && !this.poItemId.equals(other.poItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PoItemDAO[ poItemId=" + poItemId + " ]";
    }
    
}
