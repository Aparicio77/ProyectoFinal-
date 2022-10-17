package com_Modell;

import java.util.ArrayList;

public class Red_VendedoresProductos {
    private String nombre;
    private String codigo;
    private ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();

    public Red_VendedoresProductos(String nombre, String codigo, ArrayList<Vendedor> listaVendedores) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaVendedores = listaVendedores;
    }

    //----------------------------------------------------------------CRUD VENDEDOR
    public String crearVendedor(Vendedor nuevoVendedor) {
        String mensaje = "";
        try {
            Vendedor vendedor = verificarVendedor(nuevoVendedor);
            listaVendedores.add(nuevoVendedor);
            mensaje = "vendedor creado";
        } catch (vendedorExeption e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    private Vendedor verificarVendedor(Vendedor nuevoVendedor) throws vendedorExeption {
        Vendedor vendedorHallado = null;
        for (Vendedor vendedorAux : listaVendedores) {
            if (vendedorAux.getCedula().equals(nuevoVendedor.getCedula())) {
                vendedorHallado = vendedorAux;
                throw new vendedorExeption("el vendedor ya existe");

            }
        }
        return vendedorHallado;
    }

    private Vendedor buscarVendedor(Vendedor nuevoVendedor) throws vendedorExeption {
        Vendedor vendedorHallado = null;
        for (Vendedor vendedorAux : listaVendedores) {
            if (vendedorAux.getCedula().equals(nuevoVendedor.getCedula())) {
                vendedorHallado = vendedorAux;
                break;
            }
        }
        if (vendedorHallado == null) {
            throw new vendedorExeption("el vendedor no existe");
        }
        return vendedorHallado;
    }
    //leer vendedor

    /**
     * METODO QUE LEE EL VENDEDOR EN TO STRING
     *
     * @param vendedor
     * @return
     */
    public String leerVendedor(Vendedor vendedor) {
        String mensaje = "";
        try {
            Vendedor vendedorHallado = buscarVendedor(vendedor);
            mensaje = vendedorHallado.toString();
        } catch (vendedorExeption e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    //ACTUALIZAR VENDEDOR

    /**
     * METODO QUE ACTUALIZA VENDEDOR
     * @param vendedor
     * @return
     */
    public String actualizarVendedor(Vendedor vendedor) {
        String mensaje = "";
        try {
            Vendedor vendedorHallado = buscarVendedor(vendedor);
            int posVendedor = listaVendedores.indexOf(vendedor);
            listaVendedores.set(posVendedor, vendedorHallado);
            mensaje = "vendedor actualizado";
        } catch (vendedorExeption e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }
    //eliminar vendedor
    public String eliminarVendedor(Vendedor vendedor) {
        String mensaje = "";
        Vendedor vendedorHallado = null;
        try {
            vendedorHallado = buscarVendedor(vendedor);
            listaVendedores.remove(vendedorHallado);
            mensaje= "vendedor eliminado";
        } catch (vendedorExeption e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }


}
