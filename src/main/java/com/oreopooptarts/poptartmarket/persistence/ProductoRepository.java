package com.oreopooptarts.poptartmarket.persistence;

import com.oreopooptarts.poptartmarket.persistence.crud.ProductoCRUDRepository;
import com.oreopooptarts.poptartmarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCRUDRepository productoCRUDRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCRUDRepository.findAll();
    }
    public List<Producto> getByCategoriaOrdenadaAsc(int idCategoria){
        return productoCRUDRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCRUDRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
    public Optional<List<Producto>> getPorPrecios(double precioVenta){
        return productoCRUDRepository.findByPrecioVentaLessThan(precioVenta);
    }
}
