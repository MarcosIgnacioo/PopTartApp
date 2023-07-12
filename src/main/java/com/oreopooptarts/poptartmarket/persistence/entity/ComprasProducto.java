package com.oreopooptarts.poptartmarket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId
    /*
    * Como es una clave compuesta en vez de id se utiliza la anotación
    * @EmbededId, asi indicandole a java como debe de trabajar los id
    * que se hicieron con la nueva clase ComprasProductoPK
    *
    * */
    private ComprasProductoPK id;
    private Double total;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
   private Producto producto;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
