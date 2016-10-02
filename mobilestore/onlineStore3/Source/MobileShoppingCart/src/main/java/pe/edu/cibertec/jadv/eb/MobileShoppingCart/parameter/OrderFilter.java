/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter;

import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author u14138
 */
public class OrderFilter {

    private HashSet<Integer> status;
    private int customerID;
    private String filterByDate;
    private Date before;
    private Date after;

    public OrderFilter() {
        status = new HashSet<>();
    }

    public HashSet<Integer> getStatus() {
        return status;
    }

    public void setStatus(HashSet<Integer> status) {
        this.status = status;
    }

    public String getFilterByDate() {
        return filterByDate;
    }

    public void setFilterByDate(String filterByDate) {
        this.filterByDate = filterByDate;
    }

    public Date getBefore() {
        return before;
    }

    public void setBefore(Date before) {
        this.before = before;
    }

    public Date getAfter() {
        return after;
    }

    public void setAfter(Date after) {
        this.after = after;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
