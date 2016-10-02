/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order;

import java.io.Serializable;
import java.util.Comparator;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SortParam;

/**
 *
 * @author u14138
 */
public class OrderComparator implements Comparator, Serializable {

    private SortParam sortParam;
    
    public OrderComparator(SortParam sortParam) {
        this.sortParam = sortParam;
    }
    
    private int compareByTotal(Order o1, Order o2) {
        if (o1.getTotal() <= o2.getTotal())
            return -1;
        
        return 1;
    }
    
    private int compareByDeliveryDate(Order o1, Order o2) {
        if (o1.getDeliveryDate().compareTo(o2.getDeliveryDate()) <= 0)
            return -1;
        
        return 1;
    }
    
    private int compareByStatus(Order o1, Order o2) {
        if (o1.getStatus() <= o2.getStatus())
            return -1;
        
        return 1;
    }
    
    @Override
    public int compare(Object obj1, Object obj2) {
        Order o1 = (Order)obj1;
        Order o2 = (Order)obj2;
     
        switch (sortParam.getField()) {
            case "total":
                return compareByTotal(o1, o2);
            case "delivery":
                return compareByDeliveryDate(o1, o2);
            case "status":
                return compareByStatus(o1, o2);
        }
        
        return -1;
    }
    
    public SortParam getSortParam() {
        return sortParam;
    }

    public void setSortParam(SortParam sortParam) {
        this.sortParam = sortParam;
    }    
}
