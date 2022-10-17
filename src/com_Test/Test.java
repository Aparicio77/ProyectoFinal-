package com_Test;

import com_Modell.Vendedor;

import static org.junit.Assert.assertTrue;

public class Test {
    //entra un nombre de un objeto creado

    public void main (String[] args) {
        Vendedor nuvoVendedor= new Vendedor("sebastian","alzate","123456","pb_tapao");
        String nombre=nuvoVendedor.getNombre();
        verificarNombre(nuvoVendedor,nombre);
    }
    @org.junit.Test
    public void verificarNombre(Vendedor vendedor,String nombre) {
        boolean flag=false;
        if (vendedor.getNombre().equals(nombre)) {
            flag=true;
            assertTrue (flag==true);
        }
    }

}
