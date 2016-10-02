package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product;

import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.OrderItem;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:54 p.m.
 */
public class SearchProductItem {

    private String brand;
    private String description;
    private String imageUrl;
    private String model;
    private String os;
    private int productID;
    private double price;
    private boolean addedToOrder;
    private OrderItem orderItem;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAddedToOrder() {
        return addedToOrder;
    }

    public void setAddedToOrder(boolean addedToOrder) {
        this.addedToOrder = addedToOrder;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
