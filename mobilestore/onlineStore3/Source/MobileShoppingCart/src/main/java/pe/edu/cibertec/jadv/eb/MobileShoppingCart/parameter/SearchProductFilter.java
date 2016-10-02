/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter;

import java.util.HashSet;

/**
 *
 * @author u14138
 */
public class SearchProductFilter {

    private HashSet<Integer> brands;
    private HashSet<Integer> operatingSystems;
    private double minPrice;

    public SearchProductFilter() {
        brands = new HashSet<>();
        operatingSystems = new HashSet<>();
    }

    public HashSet<Integer> getBrands() {
        return brands;
    }

    public void setBrands(HashSet<Integer> brands) {
        this.brands = brands;
    }

    public HashSet<Integer> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(HashSet<Integer> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
