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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Connectivity;

/**
 *
 * @author u14138
 */
//@Entity
//@Table(name = "connectivity")
//@XmlRootElement
@Embeddable
public class ConnectivityDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "sim_count")
    private Integer simCount;
    @Size(max = 30)
    @Column(name = "bluetooth")
    private String bluetooth;
    @Column(name = "wifi")
    private Boolean wifi;
    @Column(name = "usb")
    private Boolean usb;
    @Column(name = "micro_usb")
    private Boolean microUsb;
    @Column(name = "gps")
    private Boolean gps;
    @Column(name = "infrared")
    private Boolean infrared;
    @Column(name = "tethering")
    private Boolean tethering;
    @Column(name = "nfc")
    private Boolean nfc;
    //@Id
    //@Basic(optional = false)
    //@NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "product_id")
//    private Integer productId;
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.EAGER)
//    private ProductDAO productDAO;

    public ConnectivityDAO() {
    }

//    public ConnectivityDAO(Integer productId) {
//        this.productId = productId;
//    }

//    public ConnectivityDAO(ProductDAO productDAO) {
//        this.productId = productDAO.getProductId();
//        this.productDAO = productDAO;
//    }

    public ConnectivityDAO(Connectivity c) {
        updateFromDTO(c);
    }

    public void updateFromDTO(Connectivity c) {
        this.bluetooth = c.getBluetooth();
        this.gps = c.isGps();
        this.infrared = c.isInfrared();
        this.microUsb = c.isMicroUSB();
        this.nfc = c.isNfc();
        this.simCount = c.getSimCount();
        this.tethering = c.isTethering();
        this.usb = c.isUsb();
        this.wifi = c.isWifi();
    }

    public Connectivity getDTO() {
        Connectivity c = new Connectivity();
        c.setBluetooth(bluetooth);
        c.setGps(gps);
        c.setInfrared(infrared);
        c.setMicroUSB(microUsb);
        c.setNfc(nfc);
        c.setSimCount(simCount);
        c.setTethering(tethering);
        c.setUsb(usb);
        c.setWifi(wifi);
        
        return c;
    }

    public Integer getSimCount() {
        return simCount;
    }

    public void setSimCount(Integer simCount) {
        this.simCount = simCount;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getUsb() {
        return usb;
    }

    public void setUsb(Boolean usb) {
        this.usb = usb;
    }

    public Boolean getMicroUsb() {
        return microUsb;
    }

    public void setMicroUsb(Boolean microUsb) {
        this.microUsb = microUsb;
    }

    public Boolean getGps() {
        return gps;
    }

    public void setGps(Boolean gps) {
        this.gps = gps;
    }

    public Boolean getInfrared() {
        return infrared;
    }

    public void setInfrared(Boolean infrared) {
        this.infrared = infrared;
    }

    public Boolean getTethering() {
        return tethering;
    }

    public void setTethering(Boolean tethering) {
        this.tethering = tethering;
    }

    public Boolean getNfc() {
        return nfc;
    }

    public void setNfc(Boolean nfc) {
        this.nfc = nfc;
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
//        if (!(object instanceof ConnectivityDAO)) {
//            return false;
//        }
//        ConnectivityDAO other = (ConnectivityDAO) object;
//        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "ConnectivityDAO[ productId=" + productId + " ]";
//    }
    
}
