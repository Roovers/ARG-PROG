package org.example;

import database.ConexionDB;
import equipos.EquipoDAOImpl;
import gui.Menu;

public class Main {
    public static void main(String[] args) {

        EquipoDAOImpl equipoDAO = new EquipoDAOImpl();

        try {
            ConexionDB.obtenerConexion();
            System.out.println("Conexión exitosa a la base de datos");

            // Crear una instancia de Menu y pasar el equipoDAO como parámetro
            Menu menu = new Menu(equipoDAO);

            // Llamar al método mostrarMenu para iniciar la interacción con el usuario
            menu.mostrarMenu();

        } catch (RuntimeException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
}








