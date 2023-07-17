package com.oreopooptarts.poptartmarket.persistence.mapper;

import com.oreopooptarts.poptartmarket.domain.Category;
import com.oreopooptarts.poptartmarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") // Indicando al proyecto de que es un mapeador y se le indica que estamos usando spring
public interface CategoryMapper {
    @Mappings({
                @Mapping(source = "idCategoria" , target = "categoryId"),
                @Mapping(source = "descripcion" , target = "category"),
                @Mapping(source = "estado" , target = "active")
            }
    )
    Category toCategory(Categoria categoria);
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

    // Con @InheritInverseConfiguration le indicamos
    // a mapStruct que  tenemos que haccer el mapeo
    // inverso al que tenemos arriba
    // como no estamos extrayendo al atributo "productos"
    // le tenemos que indicar a la mapeada inversa que
    // ignore ese atributo de la manera en la que se pone arriba
    // se tendria que hacer varias veces si son mas cosas para ingorar

}
