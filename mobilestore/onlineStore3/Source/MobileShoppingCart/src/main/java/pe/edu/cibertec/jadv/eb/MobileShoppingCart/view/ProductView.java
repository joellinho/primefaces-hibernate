/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.ProductController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.SecurityController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.*;

/**
 *
 * @author Kike
 */
@ManagedBean(name = "productView")
@ViewScoped
public class ProductView {

    private String contextPath;
    private Product product;
    private String[] selectedConnectivity;
    private String[] selectedMultimedia;
    private String[] selectedTechnology;

    @ManagedProperty(value = "#{securityController}")
    private SecurityController securityController;

    @ManagedProperty(value = "#{productController}")
    private ProductController productController;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        contextPath = context.getExternalContext().getApplicationContextPath();
        int productID = (int) context.getExternalContext().getRequestMap().get("productID");
        product = productController.getProduct(productID);
        selectedMultimedia = new String[6];
        selectedConnectivity = new String[7];
        selectedTechnology = new String[6];

        Multimedia m = product.getMultimedia();
        selectedMultimedia[0] = m.isHasFlash() ? "hasFlash" : "";
        selectedMultimedia[1] = m.isFaceDetection() ? "faceDetection" : "";
        selectedMultimedia[2] = m.isAnalogTV() ? "analogTV" : "";
        selectedMultimedia[3] = m.isDigitalTV() ? "digitalTV" : "";
        selectedMultimedia[4] = m.isRadioAM() ? "radioAM" : "";
        selectedMultimedia[5] = m.isRadioFM() ? "radioFM" : "";

        Technology t = product.getTechnology();
        selectedTechnology[0] = t.isLte() ? "lte" : "";
        selectedTechnology[1] = t.isEdge() ? "edge" : "";
        selectedTechnology[2] = t.isGsm() ? "gsm" : "";
        selectedTechnology[3] = t.isGprs() ? "gprs" : "";
        selectedTechnology[4] = t.isHsdpa() ? "hsdpa" : "";
        selectedTechnology[5] = t.isHspaPlus() ? "hspaPlus" : "";

        Connectivity c = product.getConnectivity();
        selectedConnectivity[0] = c.isMicroUSB() ? "microusb" : "";
        selectedConnectivity[1] = c.isUsb() ? "usb" : "";
        selectedConnectivity[2] = c.isWifi() ? "wifi" : "";
        selectedConnectivity[3] = c.isGps() ? "gps" : "";
        selectedConnectivity[4] = c.isNfc() ? "nfc" : "";
        selectedConnectivity[5] = c.isTethering() ? "tethering" : "";
        selectedConnectivity[6] = c.isInfrared() ? "infrared" : "";
    }

    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public SecurityController getSecurityController() {
        return securityController;
    }

    public void setSecurityController(SecurityController securityController) {
        this.securityController = securityController;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String[] getSelectedMultimedia() {
        return selectedMultimedia;
    }

    public void setSelectedMultimedia(String[] selectedMultimedia) {
        this.selectedMultimedia = selectedMultimedia;
    }

    public String[] getSelectedConnectivity() {
        return selectedConnectivity;
    }

    public void setSelectedConnectivity(String[] selectedConnectivity) {
        this.selectedConnectivity = selectedConnectivity;
    }

    public String[] getSelectedTechnology() {
        return selectedTechnology;
    }

    public void setSelectedTechnology(String[] selectedTechnology) {
        this.selectedTechnology = selectedTechnology;
    }
}
