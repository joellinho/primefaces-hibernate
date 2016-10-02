package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:53 p.m.
 */
public class Connectivity {

    private String bluetooth;
    private boolean gps;
    private boolean infrared;
    private boolean microUSB;
    private boolean nfc;
    private int simCount;
    private boolean tethering;
    private boolean usb;
    private boolean wifi;

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isInfrared() {
        return infrared;
    }

    public void setInfrared(boolean infrared) {
        this.infrared = infrared;
    }

    public boolean isMicroUSB() {
        return microUSB;
    }

    public void setMicroUSB(boolean microUSB) {
        this.microUSB = microUSB;
    }

    public boolean isNfc() {
        return nfc;
    }

    public void setNfc(boolean nfc) {
        this.nfc = nfc;
    }

    public int getSimCount() {
        return simCount;
    }

    public void setSimCount(int simCount) {
        this.simCount = simCount;
    }

    public boolean isTethering() {
        return tethering;
    }

    public void setTethering(boolean tethering) {
        this.tethering = tethering;
    }

    public boolean isUsb() {
        return usb;
    }

    public void setUsb(boolean usb) {
        this.usb = usb;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
