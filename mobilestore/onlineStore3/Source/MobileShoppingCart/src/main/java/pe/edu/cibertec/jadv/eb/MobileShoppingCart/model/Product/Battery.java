package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:53 p.m.
 */
public class Battery {

    private int chargeTimeHours;
    private int durationHours;
    private int mah;
    private int standByHours;
    private String type;

    public int getChargeTimeHours() {
        return chargeTimeHours;
    }

    public void setChargeTimeHours(int chargeTimeHours) {
        this.chargeTimeHours = chargeTimeHours;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public int getMah() {
        return mah;
    }

    public void setMah(int mah) {
        this.mah = mah;
    }

    public int getStandByHours() {
        return standByHours;
    }

    public void setStandByHours(int standByHours) {
        this.standByHours = standByHours;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
