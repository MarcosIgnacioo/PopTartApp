package com.oreopooptarts.poptartmarket.persistence.mapper;

import com.oreopooptarts.poptartmarket.domain.Product;
import com.oreopooptarts.poptartmarket.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
/*
* OJO cuando se quieren traducir atributos que son objetos de una
* clase se tiene que agregar el mapeador de la misma, pues
* por ejemplo aqui estamos convirtiendo categoria a category
* por lo que debemos de incluir el mapeador de la categoria
* para poder hacer toda la chamba sin que haya ningun pedo real
* */
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
