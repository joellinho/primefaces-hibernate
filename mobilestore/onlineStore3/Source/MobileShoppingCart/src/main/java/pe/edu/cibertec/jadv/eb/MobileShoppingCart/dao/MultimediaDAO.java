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
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Multimedia;

/**
 *
 * @author u14138
 */
//@Entity
//@Table(name = "multimedia")
//@XmlRootElement
@Embeddable
public class MultimediaDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "main_cam")
    private Integer mainCam;
    @Column(name = "frontal_cam")
    private Integer frontalCam;
    @Column(name = "cam_digital_zoom")
    private Integer camDigitalZoom;
    @Column(name = "video_resolution")
    private Integer videoResolution;
    @Column(name = "video_digital_zoom")
    private Integer videoDigitalZoom;
    @Column(name = "has_flash")
    private Boolean hasFlash;
    @Column(name = "face_detection")
    private Boolean faceDetection;
    @Column(name = "radio_am")
    private Boolean radioAm;
    @Column(name = "radio_fm")
    private Boolean radioFm;
    @Column(name = "analog_tv")
    private Boolean analogTv;
    @Column(name = "digital_tv")
    private Boolean digitalTv;
//    @Id
    //@Basic(optional = false)
    //@NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name = "product_id")
//    private Integer productId;
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.EAGER)
//    private ProductDAO productDAO;

    public MultimediaDAO() {
    }

//    public MultimediaDAO(Integer productId) {
//        this.productId = productId;
//    }
//
//    public MultimediaDAO(Integer productId, Integer mainCam) {
//        this.productId = productId;
//        this.mainCam = mainCam;
//    }
    
//    public MultimediaDAO(ProductDAO productDAO) {
//        this.productId = productDAO.getProductId();
//        this.productDAO = productDAO;
//    }

    public MultimediaDAO(Multimedia multimedia) {
        updateFromDTO(multimedia);
    }
    
    public void updateFromDTO(Multimedia multimedia) {
        this.analogTv = multimedia.isAnalogTV();
        this.camDigitalZoom = multimedia.getCamDigitalZoom();
        this.digitalTv = multimedia.isDigitalTV();
        this.faceDetection = multimedia.isFaceDetection();
        this.frontalCam = multimedia.getFrontalCam();
        this.hasFlash = multimedia.isHasFlash();
        this.mainCam = multimedia.getMainCam();
        this.radioAm = multimedia.isRadioAM();
        this.radioFm = multimedia.isRadioFM();
        this.videoDigitalZoom = multimedia.getVideoDigitalZoom();
        this.videoResolution = multimedia.getVideoResolution();
    }

    public Multimedia getDTO() {
        Multimedia m = new Multimedia();
        m.setAnalogTV(analogTv);
        m.setCamDigitalZoom(camDigitalZoom);
        m.setDigitalTV(digitalTv);
        m.setFaceDetection(faceDetection);
        m.setFrontalCam(frontalCam);
        m.setHasFlash(hasFlash);
        m.setMainCam(mainCam);
        m.setRadioAM(radioAm);
        m.setRadioFM(radioFm);
        m.setVideoDigitalZoom(videoDigitalZoom);
        m.setVideoResolution(videoResolution);
        
        return m;        
    }

    public Integer getMainCam() {
        return mainCam;
    }

    public void setMainCam(Integer mainCam) {
        this.mainCam = mainCam;
    }

    public Integer getFrontalCam() {
        return frontalCam;
    }

    public void setFrontalCam(Integer frontalCam) {
        this.frontalCam = frontalCam;
    }

    public Integer getCamDigitalZoom() {
        return camDigitalZoom;
    }

    public void setCamDigitalZoom(Integer camDigitalZoom) {
        this.camDigitalZoom = camDigitalZoom;
    }

    public Integer getVideoResolution() {
        return videoResolution;
    }

    public void setVideoResolution(Integer videoResolution) {
        this.videoResolution = videoResolution;
    }

    public Integer getVideoDigitalZoom() {
        return videoDigitalZoom;
    }

    public void setVideoDigitalZoom(Integer videoDigitalZoom) {
        this.videoDigitalZoom = videoDigitalZoom;
    }

    public Boolean getHasFlash() {
        return hasFlash;
    }

    public void setHasFlash(Boolean hasFlash) {
        this.hasFlash = hasFlash;
    }

    public Boolean getFaceDetection() {
        return faceDetection;
    }

    public void setFaceDetection(Boolean faceDetection) {
        this.faceDetection = faceDetection;
    }

    public Boolean getRadioAm() {
        return radioAm;
    }

    public void setRadioAm(Boolean radioAm) {
        this.radioAm = radioAm;
    }

    public Boolean getRadioFm() {
        return radioFm;
    }

    public void setRadioFm(Boolean radioFm) {
        this.radioFm = radioFm;
    }

    public Boolean getAnalogTv() {
        return analogTv;
    }

    public void setAnalogTv(Boolean analogTv) {
        this.analogTv = analogTv;
    }

    public Boolean getDigitalTv() {
        return digitalTv;
    }

    public void setDigitalTv(Boolean digitalTv) {
        this.digitalTv = digitalTv;
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
//        if (!(object instanceof MultimediaDAO)) {
//            return false;
//        }
//        MultimediaDAO other = (MultimediaDAO) object;
//        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "MultimediaDAO[ productId=" + productId + " ]";
//    }
    
}
