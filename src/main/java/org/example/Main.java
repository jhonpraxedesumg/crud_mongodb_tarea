package org.example;

import org.example.crud.ClsTelefonos;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ClsTelefonos tel = new ClsTelefonos();
       tel.conexion();
//        tel.agregarTelefono();
        tel.MostrarTelefonos();
    }
}