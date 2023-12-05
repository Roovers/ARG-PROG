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

            
            Menu menu = new Menu(equipoDAO);

           
            menu.mostrarMenu();

        } catch (RuntimeException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
    }
}








