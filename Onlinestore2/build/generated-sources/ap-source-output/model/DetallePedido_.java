package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DetallePedido.class)
public abstract class DetallePedido_ {

	public static volatile SingularAttribute<DetallePedido, Double> precioUnitario;
	public static volatile SingularAttribute<DetallePedido, DetallePedidoPK> idDetalle;
	public static volatile SingularAttribute<DetallePedido, Pedido> pedido;
	public static volatile SingularAttribute<DetallePedido, Integer> cantidad;
	public static volatile SingularAttribute<DetallePedido, Producto> producto;

}

