package com_Modell;

import java.util.Objects;

public class Producto {
    private String nombre;
    private String codigo;
    private String imagen;  //LA DIRECCION DE LA IMAGEN de escritorio
    private String categoria;
    private double precio;

    /**
     * Metodo constructor
     * @param nombre
     * @param codigo
     * @param imagen
     * @param categoria
     * @param precio
     */
    public Producto(String nombre, String codigo, String imagen, String categoria, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
    }

    /**
     * Getters and setters
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                '}';
    }

    /**
     * metodo equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Double.compare(producto.getPrecio(), getPrecio()) == 0 && Objects.equals(getNombre(), producto.getNombre()) && Objects.equals(getCodigo(), producto.getCodigo()) && Objects.equals(getImagen(), producto.getImagen()) && Objects.equals(getCategoria(), producto.getCategoria());
    }

    /**
     * metodo has code
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getCodigo(), getImagen(), getCategoria(), getPrecio());
    }




}
