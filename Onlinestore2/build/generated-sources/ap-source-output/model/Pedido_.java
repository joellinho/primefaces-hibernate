package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	public static volatile SingularAttribute<Pedido, Integer> codigoPedido;
	public static volatile SingularAttribute<Pedido, Double> total;
	public static volatile SingularAttribute<Pedido, String> estado;
	public static volatile SingularAttribute<Pedido, Date> fechaEntrega;
	public static volatile ListAttribute<Pedido, DetallePedido> listaDetalles;
	public static volatile SingularAttribute<Pedido, Date> fechaPedido;

}

