package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserDAO.class)
public abstract class UserDAO_ {

	public static volatile SingularAttribute<UserDAO, String> userLogin;
	public static volatile SingularAttribute<UserDAO, String> firstName;
	public static volatile SingularAttribute<UserDAO, String> lastName;
	public static volatile SingularAttribute<UserDAO, String> password;
	public static volatile SingularAttribute<UserDAO, RoleDAO> role;
	public static volatile SingularAttribute<UserDAO, Integer> customerId;
	public static volatile SingularAttribute<UserDAO, Integer> userId;

}

