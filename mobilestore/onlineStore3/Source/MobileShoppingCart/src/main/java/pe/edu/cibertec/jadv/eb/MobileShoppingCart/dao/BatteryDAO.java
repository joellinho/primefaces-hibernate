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
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Battery;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.ProductService;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SystemService;

/**
 *
 * @author u14138
 */
//@Entity
//@Table(name = "battery")
//@XmlRootElement
@Embeddable
public class BatteryDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "charge_time")
    private Integer chargeTime;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "mah")
    private Integer mah;
    @Column(name = "stand_by")
    private Integer standBy;
    //@Id
    //@Basic(optional = false)
    //@NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "product_id")
//    private Integer productId;
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.EAGER)
//    private ProductDAO productDAO;
    @JoinColumn(name = "battery_type_id", referencedColumnName = "battery_type_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BatteryTypeDAO batteryType;

    public BatteryDAO() {
    }

//    public BatteryDAO(Integer productId) {
//        this.productId = productId;
//    }
    
//    public BatteryDAO(ProductDAO productDAO) {
//        this.productId = productDAO.getProductId();
//        this.productDAO = productDAO;
//    }

    public BatteryDAO(Battery battery) {
        updateFromDTO(battery);
    }
    
    public void updateFromDTO(Battery battery) {
        this.chargeTime = battery.getChargeTimeHours();
        this.duration = battery.getDurationHours();
        this.mah = battery.getMah();
        this.standBy = battery.getStandByHours();
        this.batteryType = new BatteryTypeDAO(SystemService.findMapKey(ProductService.batteryTypes, battery.getType()), battery.getType());
    }
    
    public Battery getDTO() {
        Battery battery = new Battery();
        battery.setChargeTimeHours(chargeTime);
        battery.setDurationHours(duration);
        battery.setMah(mah);
        battery.setStandByHours(standBy);
        battery.setType(batteryType.getItemDescription());
        
        return battery;
    }
    
    public Integer getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Integer chargeTime) {
        this.chargeTime = chargeTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMah() {
        return mah;
    }

    public void setMah(Integer mah) {
        this.mah = mah;
    }

    public Integer getStandBy() {
        return standBy;
    }

    public void setStandBy(Integer standBy) {
        this.standBy = standBy;
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

    public BatteryTypeDAO getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(BatteryTypeDAO batteryType) {
        this.batteryType = batteryType;
    }

////    @Override
////    public int hashCode() {
////        int hash = 0;
////        hash += (productId != null ? productId.hashCode() : 0);
////        return hash;
////    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BatteryDAO)) {
//            return false;
//        }
//        BatteryDAO other = (BatteryDAO) object;
//        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
//            return false;
//        }
//        return true;
//    }

//    @Override
//    public String toString() {
//        return "BatteryDAO[ productId=" + productId + " ]";
//    }
    
}
