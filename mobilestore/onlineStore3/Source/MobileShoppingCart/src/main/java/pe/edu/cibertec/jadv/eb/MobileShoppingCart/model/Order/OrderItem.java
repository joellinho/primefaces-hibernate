package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order;

import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.SearchProductItem;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:54 p.m.
 */
public class OrderItem {

    private Integer itemID;
    private Integer productID;
    private Integer quantity;
    private Double subTotal;
    private Double unitPrice;
    private SearchProductItem product;

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public SearchProductItem getProduct() {
        return product;
    }

    public void setProduct(SearchProductItem product) {
        this.product = product;
    }
}
