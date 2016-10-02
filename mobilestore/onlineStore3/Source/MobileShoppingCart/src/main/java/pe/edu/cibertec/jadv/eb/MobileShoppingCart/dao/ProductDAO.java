/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.model.Product.Product;
import pe.edu.cibertec.jadv.eb.MobileShoppingCart.service.ProductService;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDAO.findAll", query = "SELECT p FROM ProductDAO p"),
    @NamedQuery(name = "ProductDAO.countAll", query = "SELECT count(p) FROM ProductDAO p"),
    @NamedQuery(name = "ProductDAO.findByProductId", query = "SELECT p FROM ProductDAO p WHERE p.productId = :productId")//,
//@NamedQuery(name = "ProductDAO.findByModel", query = "SELECT p FROM ProductDAO p WHERE p.model = :model"),
//@NamedQuery(name = "ProductDAO.findByPrice", query = "SELECT p FROM ProductDAO p WHERE p.price = :price"),
//@NamedQuery(name = "ProductDAO.findByImageUrl", query = "SELECT p FROM ProductDAO p WHERE p.imageUrl = :imageUrl"),
//@NamedQuery(name = "ProductDAO.findByDescription", query = "SELECT p FROM ProductDAO p WHERE p.description = :description")
})
public class ProductDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "model")
    private String model;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private Double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "image_url")
    private String imageUrl;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "productDAO", fetch = FetchType.EAGER)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
    @Embedded
    private ScreenDAO screenDAO;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "productDAO", fetch = FetchType.EAGER)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
    @Embedded
    private TechnologyDAO technologyDAO;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "productDAO", fetch = FetchType.EAGER)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
    @Embedded
    private HardwareDAO hardwareDAO;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "productDAO", fetch = FetchType.EAGER)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
    @Embedded
    private ConnectivityDAO connectivityDAO;
    @JoinColumn(name = "os_id", referencedColumnName = "os_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OsDAO os;
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BrandDAO brand;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "productDAO", fetch = FetchType.EAGER)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
    @Embedded
    private MultimediaDAO multimediaDAO;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "productDAO", fetch = FetchType.EAGER)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @PrimaryKeyJoinColumn
    @Embedded
    private BatteryDAO batteryDAO;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productProductId", fetch = FetchType.LAZY)
//    private List<PoItemDAO> poItemDAOList;

    public ProductDAO() {
    }

    public ProductDAO(Integer productId) {
        this.productId = productId;
    }

    public ProductDAO(Integer productId, String model, Double price, String imageUrl) {
        this.productId = productId;
        this.model = model;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public ProductDAO(Product product) {
        //initRelations();
        updateFromDTO(product);
        updateRelationsFromDTO(product);
    }

    public void updateFromDTO(Product product) {
        this.model = product.getModel();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
        this.description = product.getDescription();
        this.brand = new BrandDAO(product.getBrandID(), ProductService.brands.get(product.getBrandID()));
        this.os = new OsDAO(product.getOsID(), ProductService.operatingSystems.get(product.getOsID()));
    }

    private void initRelations() {
//        this.hardwareDAO = new HardwareDAO(productId);
//        this.batteryDAO = new BatteryDAO(productId);
//        this.connectivityDAO = new ConnectivityDAO(productId);
//        this.multimediaDAO = new MultimediaDAO(productId);
//        this.screenDAO = new ScreenDAO(productId);
//        this.technologyDAO = new TechnologyDAO(productId);
        this.hardwareDAO = new HardwareDAO();
        this.batteryDAO = new BatteryDAO();
        this.connectivityDAO = new ConnectivityDAO();
        this.multimediaDAO = new MultimediaDAO();
        this.screenDAO = new ScreenDAO();
        this.technologyDAO = new TechnologyDAO();
    }

    public void updateRelationsFromDTO(Product product) {
        initRelations();
        this.batteryDAO.updateFromDTO(product.getBattery());
        this.connectivityDAO.updateFromDTO(product.getConnectivity());
        this.hardwareDAO.updateFromDTO(product.getHardware());
        this.multimediaDAO.updateFromDTO(product.getMultimedia());
        this.screenDAO.updateFromDTO(product.getScreen());
        this.technologyDAO.updateFromDTO(product.getTechnology());
    }

    public Product getDTO() {
        Product product = new Product();
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setModel(model);
        product.setPrice(price);
        product.setOsID(os.getOsId());
        product.setBrandID(brand.getBrandId());

        product.setBattery(batteryDAO.getDTO());
        product.setConnectivity(connectivityDAO.getDTO());
        product.setHardware(hardwareDAO.getDTO());
        product.setMultimedia(multimediaDAO.getDTO());
        product.setScreen(screenDAO.getDTO());
        product.setTechnology(technologyDAO.getDTO());

        return product;
    }

//    @PostPersist
//    public void postPersistRelations() {
//        this.batteryDAO.setProductId(productId);
//        this.connectivityDAO.setProductId(productId);
//        this.hardwareDAO.setProductId(productId);
//        this.multimediaDAO.setProductId(productId);
//        this.screenDAO.setProductId(productId);
//        this.technologyDAO.setProductId(productId);
//    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ScreenDAO getScreenDAO() {
        return screenDAO;
    }

    public void setScreenDAO(ScreenDAO screenDAO) {
        this.screenDAO = screenDAO;
    }

    public TechnologyDAO getTechnologyDAO() {
        return technologyDAO;
    }

    public void setTechnologyDAO(TechnologyDAO technologyDAO) {
        this.technologyDAO = technologyDAO;
    }

    public HardwareDAO getHardwareDAO() {
        return hardwareDAO;
    }

    public void setHardwareDAO(HardwareDAO hardwareDAO) {
        this.hardwareDAO = hardwareDAO;
    }

    public ConnectivityDAO getConnectivityDAO() {
        return connectivityDAO;
    }

    public void setConnectivityDAO(ConnectivityDAO connectivityDAO) {
        this.connectivityDAO = connectivityDAO;
    }

    public OsDAO getOs() {
        return os;
    }

    public void setOs(OsDAO os) {
        this.os = os;
    }

    public BrandDAO getBrand() {
        return brand;
    }

    public void setBrand(BrandDAO brand) {
        this.brand = brand;
    }

    public MultimediaDAO getMultimediaDAO() {
        return multimediaDAO;
    }

    public void setMultimediaDAO(MultimediaDAO multimediaDAO) {
        this.multimediaDAO = multimediaDAO;
    }

    public BatteryDAO getBatteryDAO() {
        return batteryDAO;
    }

    public void setBatteryDAO(BatteryDAO batteryDAO) {
        this.batteryDAO = batteryDAO;
    }

//    @XmlTransient
//    public List<PoItemDAO> getPoItemDAOList() {
//        return poItemDAOList;
//    }
//
//    public void setPoItemDAOList(List<PoItemDAO> poItemDAOList) {
//        this.poItemDAOList = poItemDAOList;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDAO)) {
            return false;
        }
        ProductDAO other = (ProductDAO) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductDAO[ productId=" + productId + " ]";
    }

}
