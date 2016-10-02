package com.pe.online.dao;

import Util.JPAUtil;
import com.pe.online.entity.ProductoTO;
import com.pe.online.entity.UsuarioTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Producto;

/**
 *
 * @author admin-joel
 */
public class ProductoDAO {

    Map<Integer, ProductoTO> fuente = new HashMap<>();
    CriteriaBuilder cb;
    CriteriaQuery<ProductoTO> cq;
    Root<Producto> productoRoot;
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");
    EntityManager ema = JPAUtil.getEntityManager();

    public ProductoDAO() {
        fuente = poblar();

    }

    public Map<Integer, ProductoTO> poblar() {
        Map<Integer, ProductoTO> fuente2 = new HashMap<>();
        ProductoTO bean1 = new ProductoTO();
        bean1.setCodigo(1);
        bean1.setCodigoCategoria(1);
        bean1.setCodigoSubcategoria(1);
        bean1.setNombreProducto("polo azul");
        bean1.setImagen("poloazul.jpg");
        bean1.setDescripcion("polo marca BICKINS azul marino algodon ,ideal para el verano entallada una marca prestigiosa y duradera ");
        bean1.setPrecio(20.00);
        bean1.setImagenChica("");
        bean1.setImagenGrande("");
        bean1.setBannerChico("no");
        bean1.setBannerGrande("no");

        ProductoTO bean2 = new ProductoTO();
        bean2.setCodigo(2);
        bean2.setCodigoCategoria(1);
        bean2.setCodigoSubcategoria(1);
        bean2.setNombreProducto("polo plomo");
        bean2.setImagen("poloplomo.jpg");
        bean2.setDescripcion("Camisa de manga corta Corte recto - regular fit Tira de botones doble Cuello plegable Aplicacion  logo Bolsillo en la parte izquierda del pecho Material: 100% Algodon");
        bean2.setPrecio(30.00);
        bean2.setPrecio(30.00);
        bean2.setImagenChica("");
        bean2.setImagenGrande("");
        bean2.setBannerChico("no");
        bean2.setBannerGrande("no");

        ProductoTO bean3 = new ProductoTO();
        bean3.setCodigo(3);
        bean3.setCodigoCategoria(1);
        bean3.setCodigoSubcategoria(1);
        bean3.setNombreProducto("polo plomo");
        bean3.setImagen("poloplomo.jpg");
        bean3.setDescripcion("Camisa de manga corta Corte recto - regular fit Tira de botones doble Cuello plegable Aplicacion  logo Bolsillo en la parte izquierda del pecho Material: 100% Algodon");
        bean3.setPrecio(30.00);
        bean3.setImagenChica("");
        bean3.setImagenGrande("");
        bean3.setBannerChico("no");
        bean3.setBannerGrande("no");

        ProductoTO bean4 = new ProductoTO();
        bean4.setCodigo(4);
        bean4.setCodigoCategoria(1);
        bean4.setCodigoSubcategoria(1);
        bean4.setNombreProducto("molsa bege de cuero");
        bean4.setImagen("bolsabeige.jpg");
        bean4.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean4.setPrecio(30.00);
        bean4.setImagenChica("");
        bean4.setImagenGrande("");
        bean4.setBannerChico("no");
        bean4.setBannerGrande("no");

        ProductoTO bean5 = new ProductoTO();
        bean5.setCodigo(5);
        bean5.setCodigoCategoria(1);
        bean5.setCodigoSubcategoria(1);
        bean5.setNombreProducto("billetera de cuero negra");
        bean5.setImagen("billeteranegra.jpg");
        bean5.setDescripcion("Nam lobortis ipsum dolor, ut accumsan est tincidunt nec. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Ut tempus hendrerit libero, non tincidunt felis auctor id. Ut id nibh a mauris ullamcorper suscipit sit amet ac nisl. Sed eget orci leo. Nullam vel tortor semper orci dapibus dapibus ");
        bean5.setPrecio(30.00);
        bean5.setImagenChica("");
        bean5.setImagenGrande("");
        bean5.setBannerChico("no");
        bean5.setBannerGrande("no");

        ProductoTO bean6 = new ProductoTO();
        bean6.setCodigo(6);
        bean6.setCodigoCategoria(1);
        bean6.setCodigoSubcategoria(1);
        bean6.setNombreProducto("polo plomo");
        bean6.setImagen("poloplomo.jpg");
        bean6.setDescripcion("Camisa de manga corta Corte recto - regular fit Tira de botones doble Cuello plegable Aplicacion  logo Bolsillo en la parte izquierda del pecho Material: 100% Algodon");
        bean6.setPrecio(30.00);
        bean6.setImagenChica("");
        bean6.setImagenGrande("");
        bean6.setBannerChico("no");
        bean6.setBannerGrande("no");

        ProductoTO bean7 = new ProductoTO();
        bean7.setCodigo(7);
        bean7.setCodigoCategoria(1);
        bean7.setCodigoSubcategoria(1);
        bean7.setNombreProducto("polera blanco manga negra");
        bean7.setImagen("");
        bean7.setDescripcion("Camiseta de manga larga en punto elástico con cuello redondo.Mangas con puños en canalé. Bajos rectos con aperturas laterales. Tratamiento scotchgard de 3m anti manchas.");
        bean7.setPrecio(30.00);
        bean7.setImagenChica("");
        bean7.setImagenGrande("polerablancanegragrande.png");
        bean7.setBannerChico("no");
        bean7.setBannerGrande("si");

        ProductoTO bean8 = new ProductoTO();
        bean8.setCodigo(8);
        bean8.setCodigoCategoria(1);
        bean8.setCodigoSubcategoria(1);
        bean8.setNombreProducto(" polera  blanca manga roja ");
        bean8.setImagen("");
        bean8.setDescripcion("Camiseta pecho blanco  manga roja larga en punto elástico con cuello redondo.Mangas con puños en canalé. Bajos rectos con aperturas laterales. Tratamiento scotchgard de 3m anti manchas. ");
        bean8.setPrecio(30.00);
        bean8.setImagenChica("");
        bean8.setImagenGrande("polerarojablancagrande.png");
        bean8.setBannerChico("no");
        bean8.setBannerGrande("si");

        ProductoTO bean9 = new ProductoTO();
        bean9.setCodigo(9);
        bean9.setCodigoCategoria(1);
        bean9.setCodigoSubcategoria(1);
        bean9.setNombreProducto("polo blanco levis");
        bean9.setImagen("");
        bean9.setDescripcion("Polo Blanco  Lewis. Con tratamiento anti manchas 3m. Cuello clásico y refuerzo de media luna bajo el cuello en espalda. Tapeta y botones igualados a color de prenda. Mangas con puños en canalé. Bajos rectos con aperturas laterales. Tratamiento scotchgard de 3m anti manchas. ");
        bean9.setPrecio(30.00);
        bean9.setImagenChica("");
        bean9.setImagenGrande("poloblancogrande.png");
        bean9.setBannerChico("no");
        bean9.setBannerGrande("si");

        ProductoTO bean10 = new ProductoTO();
        bean10.setCodigo(10);
        bean10.setCodigoCategoria(1);
        bean10.setCodigoSubcategoria(1);
        bean10.setNombreProducto("zapatilla negra convert");
        bean10.setImagen("");
        bean10.setDescripcion("Las Converse Chuck Taylor All Star Sting Ray Metallic Leather son las mismas sneakers que ya conoces, pero disponibles ahora en una piel premium con acabado de raya metalizado que aporta una nueva expresión a la silueta legendaria. (No te preocupes, la suela de caucho vulcanizado clásica y la autenticidad cultural permanecen intactas). Y como siempre, con el tiempo mejoran. ");
        bean10.setPrecio(30.00);
        bean10.setImagenChica("");
        bean10.setImagenGrande("zapatillanegragrande.png");
        bean10.setBannerChico("no");
        bean10.setBannerGrande("si");

        ProductoTO bean11 = new ProductoTO();
        bean11.setCodigo(11);
        bean11.setCodigoCategoria(1);
        bean11.setCodigoSubcategoria(1);
        bean11.setNombreProducto("zapato marron bata");
        bean11.setImagen("");
        bean11.setDescripcion("Los zapatos para hombre modelo Metropole son de color marrón y tienen un estilo casual, ideal para usarlos en cualquier compromiso o evento importante, haciéndote lucir espectacular. El modelo Metropole tiene un diseño con pasadores y costuras en contraste en la parte superior. Para su elaboración se empleó cuero de la más alta calidad; al adquirirlo te garantiza un calzado de gran resistencia y durabilidad. Su capellada áspera le da ese toque de elegancia que tanto buscas en todos tus zapatos ");
        bean11.setPrecio(30.00);
        bean11.setImagenChica("zapatomarronchico.jpg");
        bean11.setImagenGrande("");
        bean11.setBannerChico("si");
        bean11.setBannerGrande("no");

        ProductoTO bean12 = new ProductoTO();
        bean12.setCodigo(12);
        bean12.setCodigoCategoria(1);
        bean12.setCodigoSubcategoria(1);
        bean12.setNombreProducto("polo negro evans");
        bean12.setImagen("");
        bean12.setDescripcion("Polo Negro con bolsillo EVANS. Con tratamiento anti manchas 3m. Cuello clásico y refuerzo de media luna bajo el cuello en espalda. Tapeta y botones igualados a color de prenda. Mangas con puños en canalé. Bajos rectos con aperturas laterales. Tratamiento scotchgard de 3m anti manchas. ");
        bean12.setPrecio(30.00);
        bean12.setImagenChica("polonegrochico.jpg");
        bean12.setImagenGrande("");
        bean12.setBannerChico("si");
        bean12.setBannerGrande("no");

        ProductoTO bean13 = new ProductoTO();
        bean13.setCodigo(13);
        bean13.setCodigoCategoria(1);
        bean13.setCodigoSubcategoria(1);
        bean13.setNombreProducto("jean Azul marino piers");
        bean13.setImagen("");
        bean13.setDescripcion("Material de correa	Tela  Forma de la caja	Cuadrado Tipo de reloj	Casual Color	Azul Oscuro Condición del producto	Nuevo main_category	10642 Modelo	skinny hombre pitillo Tamaño (L x P x A cm)	25×3×20 Garantía del producto	De haber falla de fábrica, el cambio se efectuará los 7 primeros días hábiles. ");
        bean13.setPrecio(30.00);
        bean13.setImagenChica("jeanazulchico.jpg");
        bean13.setImagenGrande("no");
        bean13.setBannerChico("si");
        bean13.setBannerGrande("no");

        ProductoTO bean14 = new ProductoTO();
        bean14.setCodigo(14);
        bean14.setCodigoCategoria(1);
        bean14.setCodigoSubcategoria(1);
        bean14.setNombreProducto("zapato marron bata");
        bean14.setImagen("");
        bean14.setDescripcion("Los zapatos para hombre modelo Metropole son de color marrón y tienen un estilo casual, ideal para usarlos en cualquier compromiso o evento importante, haciéndote lucir espectacular. El modelo Metropole tiene un diseño con pasadores y costuras en contraste en la parte superior. Para su elaboración se empleó cuero de la más alta calidad; al adquirirlo te garantiza un calzado de gran resistencia y durabilidad. Su capellada áspera le da ese toque de elegancia que tanto buscas en todos tus zapatos ");
        bean14.setPrecio(30.00);
        bean14.setImagenChica("zapatomarronchico.jpg");
        bean14.setImagenGrande("no");
        bean14.setBannerChico("si");
        bean14.setBannerGrande("no");
        ProductoTO bean15 = new ProductoTO();
        bean15.setCodigo(15);
        bean15.setCodigoCategoria(1);
        bean15.setCodigoSubcategoria(1);
        bean15.setNombreProducto("polo negro evans");
        bean15.setImagen("");
        bean15.setDescripcion("Polo Negro con bolsillo EVANS. Con tratamiento anti manchas 3m. Cuello clásico y refuerzo de media luna bajo el cuello en espalda. Tapeta y botones igualados a color de prenda. Mangas con puños en canalé. Bajos rectos con aperturas laterales. Tratamiento scotchgard de 3m anti manchas. ");
        bean15.setPrecio(30.00);
        bean15.setImagenChica("polonegrochico.jpg");
        bean15.setImagenGrande("");
        bean15.setBannerChico("si");
        bean15.setBannerGrande("");

        fuente2.put(1, bean1);
        fuente2.put(2, bean2);
        fuente2.put(3, bean3);
        fuente2.put(4, bean4);
        fuente2.put(5, bean5);
        fuente2.put(6, bean6);
        fuente2.put(7, bean7);
        fuente2.put(8, bean8);
        fuente2.put(9, bean9);
        fuente2.put(10, bean10);
        fuente2.put(11, bean11);
        fuente2.put(12, bean12);
        fuente2.put(13, bean13);
        fuente2.put(14, bean14);
        fuente2.put(15, bean15);

        return fuente2;
    }

    public List<ProductoTO> getProductosIndex() {

        List<ProductoTO> listaproductos = new ArrayList<>();
        String query = "select new com.pe.online.entity.ProductoTO(p.codigo,p.codigoCategoria,p.codigoSubcategoria,p.nombreProducto,p.imagen,p.descripcion,p.precio,p.imagenChica,p.imagenGrande,p.bannerChico,p.bannerGrande) from Producto  p where p.bannerChico='no' and p.bannerGrande='no' ";

        TypedQuery<ProductoTO> typedquery = ema.createQuery(query, ProductoTO.class);
        typedquery.setMaxResults(3);
        listaproductos = typedquery.getResultList();

        return listaproductos;
    }

    public List<ProductoTO> getProductosIndex_1() {

        List<ProductoTO> listaproductos = new ArrayList<>();
        int sizemap = poblar().size();
        for (int i = 1; i <= sizemap; i++) {
            if (poblar().get(i).getBannerChico().equals("no") && poblar().get(i).getBannerGrande().equals("no")) {
                listaproductos.add(poblar().get(i));
            }

        }

        return listaproductos;
    }

    public List<ProductoTO> getBanner() {

        List<ProductoTO> listaBanner = new ArrayList<>();
//        String query = "select new com.pe.online.entity.ProductoTO(p.codigo,p.codigoCategoria,p.codigoSubcategoria,p.nombreProducto,p.imagen,p.descripcion,p.precio,p.imagenChica,p.imagenGrande,p.bannerChico,p.bannerGrande) from Producto p where p.bannerGrande='si'";
//
//        TypedQuery<ProductoTO> typedQuery = ema.createQuery(query, ProductoTO.class);
CriteriaQuery<ProductoTO> prodcriteria = this.getcriteriaProducto();
        prodcriteria.where(cb.equal(productoRoot.get("bannerGrande"), "si"));
        TypedQuery<ProductoTO> typedQuery = ema.createQuery(prodcriteria);        
listaBanner = typedQuery.getResultList();

        return listaBanner;

    }

    public List<ProductoTO> getThreeOfertas() {
        List<ProductoTO> lista = new ArrayList<>();
//        String query = "select new com.pe.online.entity.ProductoTO(p.codigo,p.codigoCategoria,p.codigoSubcategoria,p.nombreProducto,p.imagen,p.descripcion,p.precio,p.imagenChica,p.imagenGrande,p.bannerChico,p.bannerGrande) from Producto p  where p.bannerChico='si'";
        CriteriaQuery<ProductoTO> prodcriteria = this.getcriteriaProducto();
        prodcriteria.where(cb.equal(productoRoot.get("bannerChico"), "si"));
        TypedQuery<ProductoTO> typedQuery = ema.createQuery(prodcriteria);
        lista = typedQuery.getResultList();
        return lista;
    }

    public List<ProductoTO> buscarPorNombre(ProductoTO producto) {
        List<ProductoTO> listafiltrada = new ArrayList<>();
        for (int i = 1; i <= fuente.size(); i++) {
            if (fuente.get(i).getNombreProducto().contains(producto.getNombreProducto())) {
                listafiltrada.add(fuente.get(i));
            }
        }

        return listafiltrada;

    }

    public ProductoTO mostrarDetalles(int codigo) {

        ProductoTO producto = new ProductoTO();
        String query = "select new com.pe.online.entity.ProductoTO(p.codigo,p.codigoCategoria,p.codigoSubcategoria,p.nombreProducto,p.imagen,p.descripcion,p.precio,p.imagenChica,p.imagenGrande,p.bannerChico,p.bannerGrande) from Producto p where id=:codigo";
        TypedQuery<ProductoTO> typedQuery = ema.createQuery(query, ProductoTO.class);
        typedQuery.setParameter("codigo", codigo);
        producto = typedQuery.getSingleResult();
        return producto;

    }

    public List<ProductoTO> mostrarTodos() {
        List<ProductoTO> lista = new ArrayList<>();
        CriteriaQuery<ProductoTO> criteriaprod = getcriteriaProducto();
        TypedQuery<ProductoTO> typedQuery = ema.createQuery(criteriaprod);
        lista = typedQuery.getResultList();
        return lista;
    }

    public void eliminar(ProductoTO producto) {
        fuente.remove(producto.getCodigo());

    }

    public CriteriaQuery<ProductoTO> getcriteriaProducto() {
        cb = ema.getCriteriaBuilder();
        cq = cb.createQuery(ProductoTO.class);
        productoRoot = cq.from(Producto.class);
        cq.select(cb.construct(ProductoTO.class, 
                productoRoot.get("codigo"),
                productoRoot.get("codigoCategoria"), 
                productoRoot.get("codigoSubcategoria"),
                productoRoot.get("nombreProducto"),
                productoRoot.get("imagen"),
                productoRoot.get("descripcion"),
                productoRoot.get("precio"),
                productoRoot.get("imagenChica"),
                productoRoot.get("imagenGrande"),
                productoRoot.get("bannerChico"), 
                productoRoot.get("bannerGrande")));

        return cq;

    }

}
