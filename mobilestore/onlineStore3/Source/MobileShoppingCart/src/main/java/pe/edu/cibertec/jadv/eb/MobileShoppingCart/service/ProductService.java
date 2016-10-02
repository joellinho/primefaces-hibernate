/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.ProductDAO;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.SearchProductItemDAO;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Order.*;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SearchProductFilter;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SearchProductParam;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.parameter.SortParam;
import static pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.SystemService.createEntityManager;

/**
 *
 * @author u14138
 */
public class ProductService extends BaseService {

    public static HashMap<Integer, String> brands = new HashMap<>();
    public static HashMap<Integer, String> operatingSystems = new HashMap<>();
    public static HashMap<Integer, String> batteryTypes = new HashMap<>();
    public static HashMap<Integer, String> screenTypes = new HashMap<>();
    public static HashMap<Integer, Product> products = new HashMap<>();

//    public static void initOS() {
//        operatingSystems.put(1, "Android");
//        operatingSystems.put(2, "iOS");
//        operatingSystems.put(3, "Windows Phone");
//    }
//
//    public static void initBrands() {
//        brands.put(1, "LG");
//        brands.put(2, "Sony");
//        brands.put(3, "Apple");
//        brands.put(4, "Samsung");
//        brands.put(5, "Huawei");
//        brands.put(6, "HTC");
//        brands.put(7, "Nokia");
//    }
    public static void loadCatalogs() {
        EntityManager em = createEntityManager();
        SystemService.loadCatalog(em, brands, "BrandDAO.findAll");
        SystemService.loadCatalog(em, operatingSystems, "OsDAO.findAll");
        SystemService.loadCatalog(em, batteryTypes, "BatteryTypeDAO.findAll");
        SystemService.loadCatalog(em, screenTypes, "ScreenTypeDAO.findAll");
        em.close();
    }

    public static Battery createDummyBattery(int random) {
        Battery battery = new Battery();
        Integer mod = random % 2 + 2;
        battery.setChargeTimeHours(mod);
        battery.setDurationHours(mod * 6);
        battery.setStandByHours(mod * 30);
        //battery.setType(mod == 2 ? "Li-Ion" : "Cells");
        battery.setType(batteryTypes.get(mod - 1));
        battery.setMah(mod == 2 ? 2300 : 3000);
        return battery;
    }

    public static Technology createDummyTechnology(int random) {
        Technology tech = new Technology();
        tech.setEdge(random % 2 == 0);
        tech.setLte(random % 2 == 0);
        tech.setGprs(random % 2 == 1);
        tech.setGsm(random % 2 == 1);
        tech.setHsdpa(random % 2 == 0);
        tech.setHspaPlus(random % 2 == 1);
        return tech;
    }

    private static Connectivity createDummyConnectivity(int i) {
        Connectivity conn = new Connectivity();
        conn.setBluetooth("Version 4." + ((Integer) (i % 2 + 1)).toString());
        conn.setGps(true);
        conn.setInfrared(i % 3 > 0);
        conn.setMicroUSB(true);
        conn.setNfc(i % 3 > 0);
        conn.setSimCount(1);
        conn.setTethering(i % 4 > 0);
        conn.setUsb(true);
        conn.setWifi(true);
        return conn;
    }

    private static Hardware createDummyHardware(int i) {
        Hardware hw = new Hardware();
        hw.setHeightMM(Double.valueOf(150 + ((i % 2) + 1) * 2));
        hw.setWidthMM(Double.valueOf(80 + ((i % 2) + 1) * 2));
        hw.setThicknessMM(Double.valueOf(5 + ((i % 2) + 2)));
        hw.setMicroSD(true);
        hw.setMicroSDMaxGB(i % 2 == 0 ? 128 : 256);
        hw.setRamGB((i % 3) + 1);
        hw.setProcessor(i % 2 == 0 ? "2.3 Hz, 4 cores" : "1.8 Hz, 8 cores");
        hw.setStorageGB(((i % 2) + 1) * 2);
        hw.setWeightGR(120 + ((i % 2) + 1) * 10);
        return hw;
    }

    private static Multimedia createDummyMultimedia(int i) {
        Multimedia multimedia = new Multimedia();
        multimedia.setAnalogTV(i % 2 == 0);
        multimedia.setCamDigitalZoom(8 + (i % 2 + 1) * 2);
        multimedia.setDigitalTV(i % 2 == 1);
        multimedia.setFaceDetection(i % 2 == 1);
        multimedia.setFrontalCam(2 + (i % 2 + 1) * 3);
        multimedia.setHasFlash(true);
        multimedia.setMainCam(4 * (i % 2 + 2));
        multimedia.setRadioAM(i % 2 == 0);
        multimedia.setRadioFM(i % 3 > 0);
        multimedia.setVideoDigitalZoom(2 + (i % 2) * 2);
        multimedia.setVideoResolution(i % 3 > 0 ? 1080 : 720);
        return multimedia;
    }

    private static Screen createDummyScreen(int i) {
        Screen screen = new Screen();
        screen.setResolution(i % 3 > 0 ? "1920 x 1080" : "1280 x 720");
        screen.setSize(i % 3 > 0 ? 5.5 : 6);
        //screen.setType("Touchpad");
        screen.setType(screenTypes.get(i % screenTypes.size() + 1));
        return screen;
    }

    public static void createDummyProducts(Integer brandID, Integer osID, Integer quantity, double basePrice) {
        String brand = brands.get(brandID);
        String os = operatingSystems.get(osID);
        String model = brand + " Model";

        for (int i = 0; i < quantity; i++) {
            Product product = new Product();
            Integer productID = SystemService.generateID("product");
            product.setProductID(productID);
            product.setBrandID(brandID);
            product.setOsID(osID);
            product.setModel(model + productID);
            product.setDescription(model + i + "-" + os + "-Description");
            product.setImageUrl("product-" + productID + ".png");
            product.setPrice(basePrice + (i + 1) * 50);
            product.setBattery(createDummyBattery(i));
            product.setTechnology(createDummyTechnology(i));
            product.setConnectivity(createDummyConnectivity(i));
            product.setHardware(createDummyHardware(i));
            product.setMultimedia(createDummyMultimedia(i));
            product.setScreen(createDummyScreen(i));
            products.put(productID, product);
        }
    }

    public static void initProducts() {
        createDummyProducts(1, 1, 5, 50);   // LG-Android           1
        createDummyProducts(1, 3, 2, 40);   // LG-Windows           6
        createDummyProducts(2, 1, 3, 80);   // Sony-Android         8
        createDummyProducts(3, 2, 3, 90);   // Apple-iOS            11
        createDummyProducts(4, 1, 8, 60);   // Samsung-Android      14
        createDummyProducts(5, 1, 10, 40);  // Huawei-Android       22
        createDummyProducts(6, 1, 2, 60);   // HTC-Android          32
        createDummyProducts(6, 3, 2, 50);   // HTC-Windows          34
        createDummyProducts(7, 3, 3, 40);   // Nokia-Windows        36
        // Total: 38 products
    }

    public static void loadProducts() {
        EntityManager em = SystemService.createEntityManager();
        Query q = em.createNamedQuery("ProductDAO.countAll");
        Long size = (Long) q.getSingleResult();

        if (size == 0) {
            try {
                initProducts();

                em.getTransaction().begin();
                for (Integer id : products.keySet()) {
                    Product product = products.get(id);
                    ProductDAO productDAO = new ProductDAO(product);
                    em.persist(productDAO);
//                    em.flush();
//                    productDAO.updateRelationsFromDTO(product);
//                    em.merge(productDAO);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }

        em.close();
    }

    static {
        //initBrands();
        //initOS();
        loadCatalogs();
        //initProducts();
        loadProducts();
    }

//    private boolean filterProduct(Product product, SearchProductFilter filter) {
//        HashSet<Integer> filterBrands = filter.getBrands();
//
//        if (filterBrands.size() > 0 && !filterBrands.contains(product.getBrandID())) {
//            return false;
//        }
//
//        HashSet<Integer> filterOS = filter.getOperatingSystems();
//
//        if (filterOS.size() > 0 && !filterOS.contains(product.getOsID())) {
//            return false;
//        }
//
//        if (product.getPrice() < filter.getMinPrice()) {
//            return false;
//        }
//
//        return true;
//    }

    private SearchProductItem createSearchProductItem(Product product) {
        SearchProductItem item = new SearchProductItem();
        item.setProductID(product.getProductID());
        item.setBrand(brands.get(product.getBrandID()));
        item.setModel(product.getModel());
        item.setOs(operatingSystems.get(product.getOsID()));
        item.setPrice(product.getPrice());
        item.setImageUrl(product.getImageUrl());
        item.setAddedToOrder(false);
        return item;
    }

//    public List<SearchProductItem> searchProducts(SearchProductParam params) {
//        SearchProductComparator comparator = new SearchProductComparator(params.getSort());
//        TreeSet<SearchProductItem> search = new TreeSet<>(comparator);
//
//        for (Integer productID : products.keySet()) {
//            Product product = products.get(productID);
//
//            if (filterProduct(product, params.getFilter())) {                
//                search.add(createSearchProductItem(product));
//            }
//        }
//
//        List<SearchProductItem> result = new ArrayList<>(search.size());
//        Iterator<SearchProductItem> iterator;
//
//        if (params.getSort().isAscending()) {
//            iterator = search.iterator();
//        } else {
//            iterator = search.descendingIterator();
//        }
//
//        while (iterator.hasNext()) {
//            result.add(iterator.next());
//        }
//
//        return result;
//    }
    
    private void addSearchProductItemSelectToBuilder(StringBuilder builder) {
        builder.append("SELECT new pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao.SearchProductItemDAO");
        builder.append("(p.productId, p.brand, p.model, p.os, p.price, p.imageUrl) ");
        builder.append("FROM ProductDAO p");
    }
            
    private Query createSearchQuery(SearchProductParam params) {
        StringBuilder builder = new StringBuilder();
        addSearchProductItemSelectToBuilder(builder);

        SearchProductFilter filter = params.getFilter();
        HashSet<Integer> filterBrands = filter.getBrands();
        HashSet<Integer> filterOS = filter.getOperatingSystems();
        HashMap<String, Object> queryParams = new HashMap<>();

        if (!filterBrands.isEmpty() || !filterOS.isEmpty() || filter.getMinPrice() > 0) {
            Integer paramCount = 0;
            builder.append(" WHERE ");

            if (!filterBrands.isEmpty()) {
                builder.append("p.brand.brandId IN (");

                for (Integer id : filterBrands) {
                    paramCount++;
                    String p = addParamToBuilder(builder, paramCount, paramCount == filterBrands.size());
                    queryParams.put(p, id);                    
                }
            }

            if (!filterOS.isEmpty()) {
                if (!filterBrands.isEmpty())
                    builder.append(" AND ");
                
                builder.append("p.os.osId IN (");

                for (Integer id : filterOS) {
                    paramCount++;
                    String p = addParamToBuilder(builder, paramCount, paramCount == filterBrands.size() + filterOS.size());
                    queryParams.put(p, id);
                }
            }
            
            if (filter.getMinPrice() > 0) {
                if (!filterBrands.isEmpty() || !filterOS.isEmpty())
                    builder.append(" AND ");
                
                builder.append("p.price >= :price");
                queryParams.put("price", filter.getMinPrice());
            }
        }
        
        SortParam sort = params.getSort();
        builder.append(" ORDER BY ");
        builder.append(sort.getField());
        
        if (!sort.isAscending())
            builder.append(" DESC");
        
        Query result = getEntityManager().createQuery(builder.toString(), SearchProductItemDAO.class);
        
        for (Entry<String, Object> entry : queryParams.entrySet()) {
            result.setParameter(entry.getKey(), entry.getValue());
        }      

        return result;
    }

    public List<SearchProductItem> searchProducts(SearchProductParam params) {
        initConnection();
        Query q = createSearchQuery(params);
        List<SearchProductItemDAO> list = q.getResultList();
        closeConnection();
        
        List<SearchProductItem> result = new ArrayList<>(list.size());
        
        for (SearchProductItemDAO item : list) {
            result.add(item.getDTO());
        }
        
        return result;
    }

    public Product getProduct(int productID) {
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("productId", productID);
//        ProductDAO productDAO = (ProductDAO)getSingleResult("ProductDAO.findByProductId", params);
        ProductDAO productDAO = (ProductDAO)findById(ProductDAO.class, productID);
        return productDAO.getDTO();
    }

    public SearchProductItem getSearchProductItem(int productID) {
        SearchProductItemDAO itemDAO = (SearchProductItemDAO)findById(SearchProductItemDAO.class, productID);
        return itemDAO.getDTO();
    }

//    public Map<Integer, SearchProductItem> getProductsOfOrder(Order order) {
//        Map<Integer, SearchProductItem> result = new HashMap<>();
//
//        for (Integer productID : order.getItems().keySet()) {
//            Product product = products.get(productID);
//            result.put(productID, createSearchProductItem(product));
//        }
//
//        return result;
//    }

    public Map<Integer, SearchProductItem> getProductsOfOrder(Order order) {
        Map<Integer, SearchProductItem> result = new HashMap<>();

        for (Integer productID : order.getItems().keySet()) {
            SearchProductItemDAO item = (SearchProductItemDAO)findById(SearchProductItemDAO.class, productID);
            result.put(productID, item.getDTO());
        }

        return result;
    }

    public static HashMap<Integer, String> getBrands() {
        return brands;
    }

    public static void setBrands(HashMap<Integer, String> brands) {
        ProductService.brands = brands;
    }

    public static HashMap<Integer, String> getOperatingSystems() {
        return operatingSystems;
    }

    public static void setOperatingSystems(HashMap<Integer, String> operatingSystems) {
        ProductService.operatingSystems = operatingSystems;
    }

    public static HashMap<Integer, Product> getProducts() {
        return products;
    }

    public static void setProducts(HashMap<Integer, Product> products) {
        ProductService.products = products;
    }
}
