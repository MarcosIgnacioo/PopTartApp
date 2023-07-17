package com.oreopooptarts.poptartmarket.persistence;

import com.oreopooptarts.poptartmarket.domain.Product;
import com.oreopooptarts.poptartmarket.domain.repository.ProductRepository;
import com.oreopooptarts.poptartmarket.persistence.crud.ProductoCRUDRepository;
import com.oreopooptarts.poptartmarket.persistence.entity.Producto;
import com.oreopooptarts.poptartmarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCRUDRepository productoCRUDRepository;
    @Autowired
    private ProductMapper mapper;
    public List<Product> getAll(){
        List<Producto> productosList = (List<Producto>) productoCRUDRepository.findAll();
        return mapper.toProducts(productosList);
    }

    @Override
    public Optional<List<Product>> getByCategory(long categoryId) {
        List<Producto> productosCategorizados = productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productosCategorizados));
    }

    @Override
    public Optional<List<Product>> getByPrices(double price) {
        Optional<List<Producto>> productosCapitalizados = productoCRUDRepository.findByPrecioVentaLessThan(price);
        return productosCapitalizados.map(productos -> mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(long quantity) {
        Optional<List<Producto>> productosEscasos = productoCRUDRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productosEscasos.map(scarseProducts -> mapper.toProducts(scarseProducts));
        // convertimos la lista entera a productos con las lambdas god
    }

    @Override
    public Optional<Product> getProduct(long productId) {
        return (productoCRUDRepository.findById(productId).map(producto -> mapper.toProduct(producto)));
    }

    @Override
    public Product saveProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCRUDRepository.save(producto));
        /*
        * Aqui como estamos guardando estariamos usando una "copia" del producto, la del dominio,
        * asi que como empieza siendo la copia tenemos que pasarla a la version real de la base de datos
        * para poder guardar porque pues no podemos guardar algo en la base de datos que no es de la base de datos
        * por lo que lo convertimos a un "Produucto", usamos el crud para guardar y retornamos de nuevo el objeto pero
        * convertido a "Product"
        * */
    }

    @Override
    public void deleteProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        productoCRUDRepository.delete(producto);
    }

    @Override
    public void deleteProductById(long productId) {
        productoCRUDRepository.deleteById(productId);
    }

    public Optional<List<Producto>> getPorPrecios(double precioVenta){
        return productoCRUDRepository.findByPrecioVentaLessThan(precioVenta);
    }
    public void deleteProducto(Producto producto){
        productoCRUDRepository.delete(producto);
    }
}
