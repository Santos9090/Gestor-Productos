package com.UD4.persistence.entitys;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "productos", schema = "ud4", catalog = "")
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Basic
    @Column(name = "Nombre", length = 30)
    private String nombre;
    @Basic
    @Column(name = "Precio")
    private int precio;
    @Basic
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic
    @Column(name = "Categoria")
    private String categoria;

    public ProductosEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public String getCategoria() {

        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductosEntity that = (ProductosEntity) o;

        if (id != that.id) return false;
        if (precio != that.precio) return false;
        if (cantidad != that.cantidad) return false;
        if (!Objects.equals(categoria, that.categoria)) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + precio;
        result = 31 * result + cantidad;
        result = 31 * result + Objects.hashCode(categoria);
        return result;
    }


    public ProductosEntity(String nombre, int precio, int cantidad, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", categoria=" + getCategoria() +
                '}';
    }
}
