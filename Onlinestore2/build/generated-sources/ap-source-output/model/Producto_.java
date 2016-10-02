package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Producto.class)
public abstract class Producto_ {

	public static volatile SingularAttribute<Producto, String> descripcion;
	public static volatile SingularAttribute<Producto, Integer> codigo;
	public static volatile SingularAttribute<Producto, Double> precio;
	public static volatile SingularAttribute<Producto, String> imagenGrande;
	public static volatile SingularAttribute<Producto, Integer> codigoCategoria;
	public static volatile SingularAttribute<Producto, String> imagen;
	public static volatile ListAttribute<Producto, DetallePedido> listaDetalles;
	public static volatile SingularAttribute<Producto, String> imagenChica;
	public static volatile SingularAttribute<Producto, Integer> codigoSubcategoria;
	public static volatile SingularAttribute<Producto, String> bannerChico;
	public static volatile SingularAttribute<Producto, String> bannerGrande;
	public static volatile SingularAttribute<Producto, String> nombreProducto;

}

