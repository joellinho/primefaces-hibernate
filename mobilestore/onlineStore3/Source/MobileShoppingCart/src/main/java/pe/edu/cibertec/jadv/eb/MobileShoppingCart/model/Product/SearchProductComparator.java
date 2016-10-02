/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product;

import java.io.Serializable;
import java.util.Comparator;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SortParam;

/**
 *
 * @author u14138
 */
public class SearchProductComparator implements Comparator, Serializable {

    private SortParam sortParam;
    
    public SearchProductComparator(SortParam sortParam) {
        this.sortParam = sortParam;
    }
    
    private int compareByPrice(SearchProductItem p1, SearchProductItem p2) {
        if (p1.getPrice() <= p2.getPrice())
            return -1;
        
        return 1;
    }
    
    private int compareByBrand(SearchProductItem p1, SearchProductItem p2) {
        if (p1.getBrand().compareTo(p2.getBrand()) <= 0)
            return -1;
        
        return 1;
    }

    @Override
    public int compare(Object o1, Object o2) {
        SearchProductItem p1 = (SearchProductItem)o1;
        SearchProductItem p2 = (SearchProductItem)o2;
     
        switch (sortParam.getField()) {
            case "price":
                return compareByPrice(p1, p2);
            case "brand":
                return compareByBrand(p1, p2);
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
