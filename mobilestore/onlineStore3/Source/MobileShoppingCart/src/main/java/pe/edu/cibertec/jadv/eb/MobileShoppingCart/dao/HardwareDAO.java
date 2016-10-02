/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Hardware;

/**
 *
 * @author u14138
 */
//@Entity
//@Table(name = "hardware")
//@XmlRootElement
@Embeddable
public class HardwareDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "processor")
    private String processor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ram")
    private Integer ram;
    @Basic(optional = false)
    @NotNull
    @Column(name = "storage")
    private Integer storage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "width")
    private Double width;
    @Column(name = "height")
    private Double height;
    @Column(name = "thickness")
    private Double thickness;
    @Column(name = "micro_sd")
    private Boolean microSd;
    @Column(name = "micro_sd_limit")
    private Integer microSdLimit;
    @Column(name = "weight")
    private Integer weight;
//    @Id
    //@Basic(optional = false)
    //@NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "product_id")
//    private Integer productId;
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.EAGER)
//    private ProductDAO productDAO;

    public HardwareDAO() {
    }

//    public HardwareDAO(Integer productId) {
//        this.productId = productId;
//    }

//    public HardwareDAO(Integer productId, String processor, Integer ram, Integer storage) {
//        this.productId = productId;
//        this.processor = processor;
//        this.ram = ram;
//        this.storage = storage;
//    }

//    public HardwareDAO(ProductDAO productDAO) {
//        this.productId = productDAO.getProductId();
//        this.productDAO = productDAO;
//    }

    public HardwareDAO(Hardware hw) {
        updateFromDTO(hw);
    }

    public void updateFromDTO(Hardware hw) {
        this.processor = hw.getProcessor();
        this.ram = hw.getRamGB();
        this.storage = hw.getStorageGB();
        this.width = hw.getWidthMM();
        this.height = hw.getHeightMM();
        this.thickness = hw.getThicknessMM();
        this.microSd = hw.isMicroSD();
        this.microSdLimit = hw.getMicroSDMaxGB();
        this.weight = hw.getWeightGR();
    }
    
    public Hardware getDTO() {
        Hardware hw = new Hardware();
        hw.setHeightMM(height);
        hw.setMicroSD(microSd);
        hw.setMicroSDMaxGB(microSdLimit);
        hw.setProcessor(processor);
        hw.setRamGB(ram);
        hw.setStorageGB(storage);
        hw.setThicknessMM(thickness);
        hw.setWeightGR(weight);
        hw.setWidthMM(width);
        
        return hw;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public Boolean getMicroSd() {
        return microSd;
    }

    public void setMicroSd(Boolean microSd) {
        this.microSd = microSd;
    }

    public Integer getMicroSdLimit() {
        return microSdLimit;
    }

    public void setMicroSdLimit(Integer microSdLimit) {
        this.microSdLimit = microSdLimit;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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
//        Integer hash = 0;
//        hash += (productId != null ? productId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof HardwareDAO)) {
//            return false;
//        }
//        HardwareDAO other = (HardwareDAO) object;
//        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "HardwareDAO[ productId=" + productId + " ]";
//    }

}
