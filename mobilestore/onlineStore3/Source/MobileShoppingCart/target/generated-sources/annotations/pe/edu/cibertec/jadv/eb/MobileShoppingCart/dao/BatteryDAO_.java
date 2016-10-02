package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BatteryDAO.class)
public abstract class BatteryDAO_ {

	public static volatile SingularAttribute<BatteryDAO, Integer> duration;
	public static volatile SingularAttribute<BatteryDAO, Integer> standBy;
	public static volatile SingularAttribute<BatteryDAO, Integer> mah;
	public static volatile SingularAttribute<BatteryDAO, Integer> chargeTime;
	public static volatile SingularAttribute<BatteryDAO, BatteryTypeDAO> batteryType;

}

