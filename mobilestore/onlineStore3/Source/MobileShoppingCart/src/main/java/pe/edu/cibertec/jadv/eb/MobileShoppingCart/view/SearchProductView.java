/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.OrderController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.controller.ProductController;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.SearchProductItem;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.PagingParam;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SearchProductFilter;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SearchProductParam;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SortParam;

/**
 *
 * @author Kike
 */
@ManagedBean(name = "searchProductView")
@ViewScoped
public class SearchProductView {

    private String contextPath;
    private String[] selectedBrands;
    private String[] selectedOS;
    private SearchProductParam searchProductParam;
    private List<SearchProductItem> searchProductItems;

    @ManagedProperty(value = "#{productController}")
    private ProductController productController;
    
    @ManagedProperty(value = "#{orderController}")
    private OrderController orderController;

    @PostConstruct
    public void init() {
        contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();

        SearchProductFilter filter = new SearchProductFilter();
        SortParam sorting = new SortParam();
        sorting.setAscending(true);
        sorting.setField("price");
        PagingParam paging = new PagingParam();
        paging.setPageNo(1);
        paging.setPageSize(10);
        searchProductParam = new SearchProductParam();

        searchProductParam.setFilter(filter);
        searchProductParam.setSort(sorting);
        searchProductParam.setPaging(paging);
        searchProducts();
    }

    public List<SelectItem> getBrandItems() {
        List<SelectItem> list = new ArrayList<>();
        HashMap<Integer, String> map = productController.getBrands();

        for (Integer id : map.keySet()) {
            list.add(new SelectItem(id, map.get(id)));
        }

        return list;
    }

    public List<SelectItem> getOSItems() {
        List<SelectItem> list = new ArrayList<>();
        HashMap<Integer, String> map = productController.getOperatingSystems();

        for (Integer id : map.keySet()) {
            list.add(new SelectItem(id, map.get(id)));
        }

        return list;
    }

    public String searchProducts() {
        searchProductItems = productController.searchProducts(searchProductParam);
        return "searchProduct";
    }

    public void addProductToOrder(SearchProductItem product) {
        productController.addProductToOrder(product);
    }

    public void removeProductFromOrder(SearchProductItem product) {
        productController.removeProductFromOrder(product);
    }

    public void increaseProductQty(SearchProductItem product) {
        productController.increaseProductQty(product);
    }

    public void decreaseProductQty(SearchProductItem product) {
        productController.decreaseProductQty(product);
    }
    
    public String viewProduct(int productID) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("productID", productID);
        return "viewProduct";
    }

    public String[] getSelectedBrands() {
        return selectedBrands;
    }

    public void setSelectedBrands(String[] selectedBrands) {
        this.selectedBrands = selectedBrands;
        this.searchProductParam.getFilter().getBrands().clear();

        for (String brand : selectedBrands) {
            this.searchProductParam.getFilter().getBrands().add(Integer.parseInt(brand));
        }
    }

    public String[] getSelectedOS() {
        return selectedOS;
    }

    public void setSelectedOS(String[] selectedOS) {
        this.selectedOS = selectedOS;
        this.searchProductParam.getFilter().getOperatingSystems().clear();

        for (String os : selectedOS) {
            this.searchProductParam.getFilter().getOperatingSystems().add(Integer.parseInt(os));
        }
    }

    public SearchProductParam getSearchProductParam() {
        return searchProductParam;
    }

    public void setSearchProductParam(SearchProductParam searchProductParam) {
        this.searchProductParam = searchProductParam;
    }

    public List<SearchProductItem> getSearchProductItems() {
        return searchProductItems;
    }

    public void setSearchProductItems(List<SearchProductItem> searchProductItems) {
        this.searchProductItems = searchProductItems;
    }

    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

}
