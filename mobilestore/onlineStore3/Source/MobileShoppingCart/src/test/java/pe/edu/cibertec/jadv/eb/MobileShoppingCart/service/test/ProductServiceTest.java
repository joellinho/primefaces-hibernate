/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.test;

import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.SearchProductItem;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Security.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.PagingParam;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SearchProductFilter;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SearchProductParam;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SortParam;

/**
 *
 * @author Kike
 */
public class ProductServiceTest {

    ProductService productService;
    SortParam sort;
    PagingParam paging;
    SearchProductFilter filter;
    SearchProductParam params;

    @Before
    public void init() {
        productService = new ProductService();
        sort = new SortParam();
        filter = new SearchProductFilter();
        paging = new PagingParam();
        params = new SearchProductParam();
        params.setFilter(filter);
        params.setSort(sort);
        params.setPaging(paging);
    }

    @After
    public void close() {
        productService = null;
        sort = null;
        filter = null;
        paging = null;
        params = null;
    }

    @Test @Ignore
    public void searchByBrandAndSortedByPriceAsc() {
        sort.setField("price");
        sort.setAscending(true);
        filter.getBrands().add(1);
        filter.getBrands().add(3);
        filter.getBrands().add(5);
        filter.getBrands().add(6);
        List<SearchProductItem> list = productService.searchProducts(params);

        Assert.assertEquals(24, list.size());
        double price = 0;

        for (SearchProductItem item : list) {
            boolean markedBrand = false;
            Iterator<Integer> brands = filter.getBrands().iterator();
            
            while (brands.hasNext()) {
                Integer brandID = brands.next();
                if (ProductService.getBrands().get(brandID).equals(item.getBrand())) {
                    markedBrand = true;
                    break;
                }
            }

            Assert.assertTrue(markedBrand);
            Assert.assertTrue(item.getPrice() >= price);
            price = item.getPrice();
        }
    }

    @Test @Ignore
    public void searchByOSAndSortedByPriceDesc() {
        sort.setField("price");
        sort.setAscending(false);
        filter.getOperatingSystems().add(2);
        filter.getOperatingSystems().add(3);
        List<SearchProductItem> list = productService.searchProducts(params);

        Assert.assertEquals(10, list.size());
        double price = 100000;

        for (SearchProductItem item : list) {
            boolean markedOS = false;
            Iterator<Integer> os = filter.getOperatingSystems().iterator();
            
            while (os.hasNext()) {
                Integer osID = os.next();
                if (ProductService.getOperatingSystems().get(osID).equals(item.getOs())) {
                    markedOS = true;
                    break;
                }
            }

            Assert.assertTrue(markedOS);
            Assert.assertTrue(item.getPrice() <= price);
            price = item.getPrice();
        }
    }

    @Test @Ignore
    public void searchByBrandAndOSAndSortedByPriceDesc() {
        sort.setField("price");
        sort.setAscending(false);
        filter.getBrands().add(2);
        filter.getBrands().add(4);
        filter.getOperatingSystems().add(1);
        List<SearchProductItem> list = productService.searchProducts(params);

        Assert.assertEquals(11, list.size());
        double price = 100000;

        for (SearchProductItem item : list) {
            boolean markedBrand = false;
            Iterator<Integer> brands = filter.getBrands().iterator();
            
            while (brands.hasNext()) {
                Integer brandID = brands.next();
                if (ProductService.getBrands().get(brandID).equals(item.getBrand())) {
                    markedBrand = true;
                    break;
                }
            }

            Assert.assertTrue(markedBrand);

            boolean markedOS = false;
            Iterator<Integer> os = filter.getOperatingSystems().iterator();
            
            while (os.hasNext()) {
                Integer osID = os.next();
                if (ProductService.getOperatingSystems().get(osID).equals(item.getOs())) {
                    markedOS = true;
                    break;
                }
            }

            Assert.assertTrue(markedOS);

            Assert.assertTrue(item.getPrice() <= price);
            price = item.getPrice();
        }
    }

    @Test @Ignore
    public void searchByPriceAndSortedByBrandDesc() {
        double price = 300;
        String brand = "";
        sort.setField("brand");
        sort.setAscending(false);
        filter.setMinPrice(price);
        List<SearchProductItem> list = productService.searchProducts(params);

        for (SearchProductItem item : list) {
            if (!"".equals(brand))
                Assert.assertTrue(brand.compareTo(item.getBrand()) >= 0);
                        
            brand = item.getBrand();
            Assert.assertTrue(item.getPrice() >= price);
        }
    }
}
