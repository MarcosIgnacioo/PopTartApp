package com.oreopooptarts.poptartmarket.persistence.crud;

import com.oreopooptarts.poptartmarket.persistence.entity.Cliente;
import com.oreopooptarts.poptartmarket.persistence.entity.ComprasProducto;
import com.oreopooptarts.poptartmarket.persistence.entity.ComprasProductoPK;
import com.oreopooptarts.poptartmarket.persistence.entity.Producto;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCRUDRepository extends CrudRepository<Producto, Long> {
    // Recuperar toda la lista de productos que pertenezcan a x categoria
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    /*
    * Los queryMethods estan ya predefinidos por defecto, es decir,
    * que sin la anotacion "Query" podria funcionar perfectamente,
    * sin embargo, tambien podemos hacer nuestros propios query
    * methods si usamos la anotacion, y ya con eso, ponerle el nombre
    * que queramos al metodo
    + Vale la pena resaltar que, los queryMethods por defecto
    * deben de tener el nombre que tienen por defecto, puesto
    * que es asi como pueden ser identificados por la interfaz
    *
    * Lo que hace esta funcion es obtener una lista de todos los productos
    * de una categoria dada en el parametro
    * */

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    // Devuelve una lista con los productos que tengan una cantidad de stock menor a la que se pase por el parametro
    Optional<Cliente> findByIdCliente(int idCliente);
    // Se devuelve un cliente por su id
    Optional<Producto> findByCodigoBarras(String codigoBarras);
    // Se devuelve un producto por el codigo de barras
    Optional<List<Producto>> findByPrecioVentaLessThan(double precioVenta);
    // Se devuelve una lista de productos con el precio menor al que se le pasa por el parámetro

}
