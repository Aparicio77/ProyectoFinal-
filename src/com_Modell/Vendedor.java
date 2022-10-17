package com_Modell;

import java.util.ArrayList;
import java.util.Objects;

public class Vendedor {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private ArrayList<Producto>listaProductos;
    private ArrayList<Vendedor>listaVendedoresAliados;

    /**
     * METODO CONSTRUCTR DE VENDEDOR
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     */
    public Vendedor(String nombre, String apellido, String cedula, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    /**
     * METODOS GETTERS AND SETTERS
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * METODO TO STRING
     * @return
     */
    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    /**
     * METODO EQUALS
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendedor)) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(getNombre(), vendedor.getNombre()) && Objects.equals(getApellido(), vendedor.getApellido()) && Objects.equals(getCedula(), vendedor.getCedula()) && Objects.equals(getDireccion(), vendedor.getDireccion());
    }

    /**
     * METODO HASCODE
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellido(), getCedula(), getDireccion());
    }
    //-----------------------------VENDEDORES ALIADOS-------------------------------

    /**
     * METODO QUE CREA UN VENDEDOR ALIADO
     * @param vendedor
     * @return
     */
    public String añadirVendedorAliado(Vendedor vendedor) {
        String mensaje="";
        try {
            Vendedor vendedorVerificado=verificarVendedorAliado(vendedor);
            listaVendedoresAliados.add(vendedorVerificado);
        } catch (vendedorExeption e) {
            mensaje= e.getMessage();
        }
        return mensaje;
    }

    private Vendedor verificarVendedorAliado(Vendedor vendedor) throws vendedorExeption{
        Vendedor vendedorHallado = null;
        for (Vendedor vendedorAux : listaVendedoresAliados) {
            if (vendedorAux.getCedula().equals(vendedor.getCedula())) {
                vendedorHallado = vendedorAux;
                throw new vendedorExeption("el vendedor ya existe");

            }
        }
        return vendedorHallado;
    }
    private Vendedor buscarAliado(Vendedor aliado) throws vendedorExeption {
        Vendedor aliadoHallado = null;
        for (Vendedor aliadoAux : listaVendedoresAliados) {
            if (aliadoAux.getCedula().equals(aliado.getCedula())) {
                aliadoHallado = aliadoAux;
                break;
            }
        }
        if (aliadoHallado == null) {
            throw new vendedorExeption("el vendedor no existe");
        }
        return aliadoHallado;
    }

    /**
     * METODO QUE LEE UN ALIADO EN TO STRING
     * @param vendedor
     * @return
     */
    public String leerAliado(Vendedor vendedor){
        String mensaje="";
        try {
            Vendedor aliadoHallado=buscarAliado(vendedor);
            mensaje=aliadoHallado.toString();
        } catch (vendedorExeption e) {
            mensaje=e.getMessage();
        }
        return  mensaje;
    }

    /**
     * METODO QUE ACTUALIZA EL ALIADO
     * @param aliado
     * @return
     */
    public String actualizarAliado(Vendedor aliado){
        String mensaje="";
        try {
            Vendedor aliadoHallado=verificarVendedorAliado(aliado);
            int posAliado=listaVendedoresAliados.indexOf(aliadoHallado);
            listaVendedoresAliados.set(posAliado,aliadoHallado);
            mensaje="aliado actualizado";
        } catch (vendedorExeption e) {
            mensaje=e.getMessage();
        }
        return mensaje;
    }
    public String eliminarAliado(Vendedor aliado){
        String mensaje="";
        try {
            Vendedor aliadoHallado=buscarAliado(aliado);
            listaVendedoresAliados.remove(aliadoHallado);
            mensaje="aliado eliminado";
        } catch (vendedorExeption e) {
            mensaje=e.getMessage();
        }
        return mensaje;
    }

    //------------------------------CRUD PRODUCTO--------------------------------

    /**
     * METODO QUE CREA EL PRODUCTO
     * @param nuevoProducto
     * @return
     */
    public String crearProducto(Producto nuevoProducto) {
        String mensaje="";
        try {
            Producto productoHallado=verificarProducto(nuevoProducto);
            listaProductos.add(productoHallado);
            mensaje="producto creado";
        } catch (productoExeption e) {
            mensaje=e.getMessage();
        }

        return mensaje;
    }

    private Producto verificarProducto(Producto nuevoProducto) throws productoExeption {
        Producto productoHallado = null;
        for (Producto productoAux : listaProductos) {
            if (productoAux.getCodigo().equals(nuevoProducto.getCodigo())) {
                productoHallado = productoAux;
                throw new productoExeption("el producto ya existe");
            }
        }
        return productoHallado;
    }
    //metodo que lee el producto

    /**
     * METODO QUE LEE PRODUCTOS EN TO STRING
     * @param producto
     * @return
     */
    public String leerProducto(Producto producto){
        String mensaje="";
        try {
            Producto productoHallado=buscarProducto(producto);
            mensaje= productoHallado.toString();
        } catch (productoExeption e) {
            mensaje=e.getMessage();
        }
        return mensaje;
    }

    private Producto buscarProducto(Producto producto)throws productoExeption {
        Producto productoHallado = null;
        for (Producto productoAux : listaProductos) {
            if (productoAux.getCodigo().equals(producto.getCodigo())) {
                productoHallado = productoAux;
                break;
            }
        }
        if (productoHallado == null) {
            throw new productoExeption("el producto no existe");
        }
        return productoHallado;
    }

    /**
     * METODO QUE ACTUALIZA UN PRODUCTO
     * @param producto
     * @return
     */
    public String actualizarProducto(Producto producto) {
        String mensaje="";
        try {
            Producto productoHallado=buscarProducto(producto);
            int posProducto=listaProductos.indexOf(producto);
            listaProductos.set(posProducto,productoHallado);
            mensaje="producto actualizado";
        } catch (productoExeption e) {
            mensaje=e.getMessage();
        }
        return mensaje;
    }

    /**
     * METODO QUE ELIMINA UN PRODUCTO
     * @param producto
     * @return
     */
    public String eliminarProducto(Producto producto) {
        String mensaje="";
        try {
            Producto productoHallado=buscarProducto(producto);
            listaProductos.remove(productoHallado);
            mensaje="producto eliminado";
        } catch (productoExeption e) {
            mensaje=e.getMessage();
        }
        return  mensaje;
    }
    }
