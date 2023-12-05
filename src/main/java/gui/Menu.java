package gui;

import equipos.EquipoDAOImpl;

import java.util.Scanner;

public class Menu {
    private EquipoDAOImpl equipoDAO;
    private Scanner scanner;

    public Menu(EquipoDAOImpl equipoDAO) {
        this.equipoDAO = equipoDAO;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Crear Equipo");
            System.out.println("2. Obtener Equipo");
            System.out.println("3. Actualizar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Obtener Todos los Equipos");
            System.out.println("0. Salir");

            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    equipoDAO.crearEquipo();
                    break;
                case 2:
                    equipoDAO.obtenerEquipo();
                    break;
                case 3:
                    equipoDAO.actualizarEquipo();
                    break;
                case 4:
                    equipoDAO.eliminarEquipo();
                    break;
                case 5:
                    equipoDAO.obtenerTodosLosEquipos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
