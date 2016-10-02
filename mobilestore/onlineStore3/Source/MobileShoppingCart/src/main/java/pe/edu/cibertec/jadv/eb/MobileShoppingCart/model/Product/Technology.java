package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:54 p.m.
 */
public class Technology {

    private boolean edge;
    private boolean gprs;
    private boolean gsm;
    private boolean hsdpa;
    private boolean hspaPlus;
    private boolean lte;

    public boolean isEdge() {
        return edge;
    }

    public void setEdge(boolean edge) {
        this.edge = edge;
    }

    public boolean isGprs() {
        return gprs;
    }

    public void setGprs(boolean gprs) {
        this.gprs = gprs;
    }

    public boolean isGsm() {
        return gsm;
    }

    public void setGsm(boolean gsm) {
        this.gsm = gsm;
    }

    public boolean isHsdpa() {
        return hsdpa;
    }

    public void setHsdpa(boolean hsdpa) {
        this.hsdpa = hsdpa;
    }

    public boolean isHspaPlus() {
        return hspaPlus;
    }

    public void setHspaPlus(boolean hspaPlus) {
        this.hspaPlus = hspaPlus;
    }

    public boolean isLte() {
        return lte;
    }

    public void setLte(boolean lte) {
        this.lte = lte;
    }
}
