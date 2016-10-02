package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:53 p.m.
 */
public class Hardware {

    private Double heightMM;
    private Boolean microSD;
    private Integer microSDMaxGB;
    private String processor;
    private Integer ramGB;
    private Integer storageGB;
    private Double thicknessMM;
    private Integer weightGR;
    private Double widthMM;

    public Double getHeightMM() {
        return heightMM;
    }

    public void setHeightMM(Double heightMM) {
        this.heightMM = heightMM;
    }

    public Boolean isMicroSD() {
        return microSD;
    }

    public void setMicroSD(Boolean microSD) {
        this.microSD = microSD;
    }

    public Integer getMicroSDMaxGB() {
        return microSDMaxGB;
    }

    public void setMicroSDMaxGB(Integer microSDMaxGB) {
        this.microSDMaxGB = microSDMaxGB;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRamGB() {
        return ramGB;
    }

    public void setRamGB(Integer ramGB) {
        this.ramGB = ramGB;
    }

    public Integer getStorageGB() {
        return storageGB;
    }

    public void setStorageGB(Integer storageGB) {
        this.storageGB = storageGB;
    }

    public Double getThicknessMM() {
        return thicknessMM;
    }

    public void setThicknessMM(Double thicknessMM) {
        this.thicknessMM = thicknessMM;
    }

    public Integer getWeightGR() {
        return weightGR;
    }

    public void setWeightGR(Integer weightGR) {
        this.weightGR = weightGR;
    }

    public Double getWidthMM() {
        return widthMM;
    }

    public void setWidthMM(Double widthMM) {
        this.widthMM = widthMM;
    }
}
