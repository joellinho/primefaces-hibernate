package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PoDAO.class)
public abstract class PoDAO_ {

	public static volatile SingularAttribute<PoDAO, Double> tax;
	public static volatile SingularAttribute<PoDAO, Double> subTotal;
	public static volatile SingularAttribute<PoDAO, Date> updatedOn;
	public static volatile SingularAttribute<PoDAO, Date> createdOn;
	public static volatile SingularAttribute<PoDAO, Integer> poId;
	public static volatile SingularAttribute<PoDAO, Double> total;
	public static volatile SingularAttribute<PoDAO, Date> cancelledOn;
	public static volatile SingularAttribute<PoDAO, Date> processedOn;
	public static volatile SingularAttribute<PoDAO, Integer> customerId;
	public static volatile ListAttribute<PoDAO, PoItemDAO> poItemDAOList;
	public static volatile SingularAttribute<PoDAO, Date> deliveredOn;
	public static volatile SingularAttribute<PoDAO, Date> deliveryDate;
	public static volatile SingularAttribute<PoDAO, Integer> status;
	public static volatile SingularAttribute<PoDAO, CustomerDAO> customer;

}

