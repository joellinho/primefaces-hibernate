package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductDAO.class)
public abstract class ProductDAO_ {

	public static volatile SingularAttribute<ProductDAO, Integer> productId;
	public static volatile SingularAttribute<ProductDAO, OsDAO> os;
	public static volatile SingularAttribute<ProductDAO, HardwareDAO> hardwareDAO;
	public static volatile SingularAttribute<ProductDAO, String> description;
	public static volatile SingularAttribute<ProductDAO, ScreenDAO> screenDAO;
	public static volatile SingularAttribute<ProductDAO, TechnologyDAO> technologyDAO;
	public static volatile SingularAttribute<ProductDAO, Double> price;
	public static volatile SingularAttribute<ProductDAO, String> imageUrl;
	public static volatile SingularAttribute<ProductDAO, ConnectivityDAO> connectivityDAO;
	public static volatile SingularAttribute<ProductDAO, String> model;
	public static volatile SingularAttribute<ProductDAO, MultimediaDAO> multimediaDAO;
	public static volatile SingularAttribute<ProductDAO, BatteryDAO> batteryDAO;
	public static volatile SingularAttribute<ProductDAO, BrandDAO> brand;

}

