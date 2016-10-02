/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter;

/**
 *
 * @author u14138
 */
public class SearchProductParam {
    private SearchProductFilter filter;
    private SortParam sort;
    private PagingParam paging;    

    public SearchProductFilter getFilter() {
        return filter;
    }

    public void setFilter(SearchProductFilter filter) {
        this.filter = filter;
    }

    public SortParam getSort() {
        return sort;
    }

    public void setSort(SortParam sort) {
        this.sort = sort;
    }

    public PagingParam getPaging() {
        return paging;
    }

    public void setPaging(PagingParam paging) {
        this.paging = paging;
    }
}
