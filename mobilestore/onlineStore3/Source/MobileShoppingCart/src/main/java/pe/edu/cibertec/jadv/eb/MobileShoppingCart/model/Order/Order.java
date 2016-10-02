package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order;

//import parameter.AddProductParam;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Enrique Bassallo
 * @version 1.0
 * @created 16-ago-2016 06:15:54 p.m.
 */
public class Order {

    private Date cancelledOn;
    private Date createdOn;
    private Integer customerID;
    private String customerFullName;
    private Date deliveredOn;
    private Date deliveryDate;
    private Integer itemCount;
    private Integer orderID;
    private Date processedOn;
    private String reference;
    private Double subTotal;
    private Double taxAmount;
    private Double total;
    private Date updatedOn;
    private Integer status;
    public HashMap<Integer, OrderItem> items;

//	/**
//	 * 
//	 * @param productParams
//	 */
//	public boolean addProduct(AddProductParam productParams){
//		return false;
//	}
//
//	public clear(){
//
//	}
//
//	/**
//	 * 
//	 * @param productID
//	 */
//	public OrderItem getProduct(Integer productID){
//		return null;
//	}
//
//	public boolean hasProducts(){
//		return false;
//	}
//
//	/**
//	 * 
//	 * @param productParams
//	 */
//	public boolean removeProduct(RemoveProductParam productParams){
//		return false;
//	}
//
//	/**
//	 * 
//	 * @param item
//	 * @param productParams
//	 */
//	public updateProductValues(OrderItem item, AddProductParam productParams){
//
//	}
    public Date getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(Date cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Date getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(Date deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getProcessedOn() {
        return processedOn;
    }

    public void setProcessedOn(Date processedOn) {
        this.processedOn = processedOn;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public HashMap<Integer, OrderItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, OrderItem> items) {
        this.items = items;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }
}
