/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.Order;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.OrderItem;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "po")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoDAO.findAll", query = "SELECT p FROM PoDAO p"),
    @NamedQuery(name = "PoDAO.countAll", query = "SELECT count(p) FROM PoDAO p")//,
//    @NamedQuery(name = "PoDAO.findByPoId", query = "SELECT p FROM PoDAO p WHERE p.poId = :poId"),
//    @NamedQuery(name = "PoDAO.findBySubTotal", query = "SELECT p FROM PoDAO p WHERE p.subTotal = :subTotal"),
//    @NamedQuery(name = "PoDAO.findByTax", query = "SELECT p FROM PoDAO p WHERE p.tax = :tax"),
//    @NamedQuery(name = "PoDAO.findByTotal", query = "SELECT p FROM PoDAO p WHERE p.total = :total"),
//    @NamedQuery(name = "PoDAO.findByStatus", query = "SELECT p FROM PoDAO p WHERE p.status = :status"),
//    @NamedQuery(name = "PoDAO.findByDeliveryDate", query = "SELECT p FROM PoDAO p WHERE p.deliveryDate = :deliveryDate"),
//    @NamedQuery(name = "PoDAO.findByCreatedOn", query = "SELECT p FROM PoDAO p WHERE p.createdOn = :createdOn"),
//    @NamedQuery(name = "PoDAO.findByProcessedOn", query = "SELECT p FROM PoDAO p WHERE p.processedOn = :processedOn"),
//    @NamedQuery(name = "PoDAO.findByDeliveredOn", query = "SELECT p FROM PoDAO p WHERE p.deliveredOn = :deliveredOn"),
//    @NamedQuery(name = "PoDAO.findByCancelledOn", query = "SELECT p FROM PoDAO p WHERE p.cancelledOn = :cancelledOn"),
//    @NamedQuery(name = "PoDAO.findByUpdatedOn", query = "SELECT p FROM PoDAO p WHERE p.updatedOn = :updatedOn")
})
public class PoDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "po_id")
    private Integer poId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private Double subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private Double tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private Double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Integer status;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "processed_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processedOn;
    @Column(name = "delivered_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveredOn;
    @Column(name = "cancelled_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelledOn;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private CustomerDAO customerId;
    @Column(name = "customer_id")
    private Integer customerId;
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CustomerDAO customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poId", fetch = FetchType.EAGER)
    private List<PoItemDAO> poItemDAOList;

    public PoDAO() {
    }

    public PoDAO(Integer poId) {
        this.poId = poId;
    }

    public PoDAO(Integer poId, Double subTotal, Double tax, Double total, Integer status) {
        this.poId = poId;
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
        this.status = status;
    }

    public PoDAO(Order order) {
        updateFromDTO(order);
    }

    public void updateFromDTO(Order order) {
        this.subTotal = order.getSubTotal();
        this.tax = order.getTaxAmount();
        this.total = order.getTotal();
        this.status = order.getStatus();
        this.customerId = order.getCustomerID();
        this.cancelledOn = order.getCancelledOn();
        this.createdOn = order.getCreatedOn();
        this.deliveredOn = order.getDeliveredOn();
        this.deliveryDate = order.getDeliveryDate();
        this.processedOn = order.getProcessedOn();
        this.updatedOn = order.getUpdatedOn();
    }
    
    public void updateItemsFromDTO(Order order) {
        this.poItemDAOList = new ArrayList<>(order.items.size());
        
        for (Entry<Integer, OrderItem> entry : order.items.entrySet()) {
            PoItemDAO item = new PoItemDAO(entry.getValue());
            item.setPoId(poId);
            this.poItemDAOList.add(item);
        }
    }
    
    public Order getDTO() {
        Order order = new Order();
        order.setOrderID(this.poId);
        order.setCancelledOn(cancelledOn);
        order.setCreatedOn(createdOn);
        order.setCustomerID(customerId);
        order.setDeliveredOn(deliveredOn);
        order.setDeliveryDate(deliveryDate);
        order.setProcessedOn(processedOn);
        order.setStatus(status);
        order.setSubTotal(subTotal);
        order.setTaxAmount(tax);
        order.setTotal(total);
        order.setUpdatedOn(updatedOn);
        order.setCustomerFullName(customer.getFirstName() + " " + customer.getLastName());
        
        HashMap<Integer, OrderItem> items = new HashMap<>();
        for (PoItemDAO item : poItemDAOList) {
            items.put(item.getProductId(), item.getDTO());
        }
        
        order.setItems(items);
        return order;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getProcessedOn() {
        return processedOn;
    }

    public void setProcessedOn(Date processedOn) {
        this.processedOn = processedOn;
    }

    public Date getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(Date deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

    public Date getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(Date cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerDAO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDAO customer) {
        this.customer = customer;
    }

//    public CustomerDAO getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(CustomerDAO customerId) {
//        this.customerId = customerId;
//    }

    @XmlTransient
    public List<PoItemDAO> getPoItemDAOList() {
        return poItemDAOList;
    }

    public void setPoItemDAOList(List<PoItemDAO> poItemDAOList) {
        this.poItemDAOList = poItemDAOList;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (poId != null ? poId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoDAO)) {
            return false;
        }
        PoDAO other = (PoDAO) object;
        if ((this.poId == null && other.poId != null) || (this.poId != null && !this.poId.equals(other.poId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PoDAO[ poId=" + poId + " ]";
    }
    
}
