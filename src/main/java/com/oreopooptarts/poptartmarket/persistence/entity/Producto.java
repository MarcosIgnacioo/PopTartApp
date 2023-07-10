package com.oreopooptarts.poptartmarket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")/*
In this way java will know when we are using the "Producto" Class we are referring to the
"productos" table in postgresql
*/

public class Producto {
    @Id                                                                  // Para indicar que es una clave primaria sencilla

    @GeneratedValue(strategy = GenerationType.IDENTITY)                 // Porque esta es la clave primaria que genera identidada a nuestros productos, asi
                                                                        // cuando se cree un nuevo producto se le va a generar automaticamente un id propio

    @Column(name = "id_producto")                                       // Para escribir el nombre original de la columna en la tabla
    private Long idProducto;

    private String nombre;
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "cantidad_stock")
    private Long cantidadStock;
    private Boolean estado;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Long cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
