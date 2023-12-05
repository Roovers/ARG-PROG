package equipos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import database.ConexionDB;
public class EquipoDAOImpl implements EquipoDAO{

    private Scanner scanner;

    public EquipoDAOImpl() {
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void crearEquipoBocaJuniors() {
        try {
            // 1. Ingresar datos por teclado
            System.out.print("Ingrese el nombre del equipo: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la cantidad de titulares: ");
            int titulares = scanner.nextInt();

            System.out.print("Ingrese la cantidad de suplentes: ");
            int suplentes = scanner.nextInt();

            scanner.nextLine(); 

            System.out.print("Ingrese el nombre del director técnico: ");
            String directorTecnico = scanner.nextLine();

            System.out.print("Ingrese la cantidad de puntos: ");
            int puntos = scanner.nextInt();

            System.out.print("Ingrese la cantidad de partidos jugados: ");
            int partidosJugados = scanner.nextInt();

            
            Equipo nuevoEquipo = new BocaJuniors(nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados);

           
            persistirEquipo(nuevoEquipo);

            System.out.println("Equipo creado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearEquipoRiverPlate() {
        try {
            
            System.out.print("Ingrese el nombre del equipo: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la cantidad de titulares: ");
            int titulares = scanner.nextInt();

            System.out.print("Ingrese la cantidad de suplentes: ");
            int suplentes = scanner.nextInt();

            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Ingrese el nombre del director técnico: ");
            String directorTecnico = scanner.nextLine();

            System.out.print("Ingrese la cantidad de puntos: ");
            int puntos = scanner.nextInt();

            System.out.print("Ingrese la cantidad de partidos jugados: ");
            int partidosJugados = scanner.nextInt();

            
            Equipo nuevoEquipo = new RiverPate(nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados);

          
            persistirEquipo(nuevoEquipo);

            System.out.println("Equipo creado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearEquipo() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("¿Qué tipo de equipo desea crear?");
            System.out.println("1. Boca Juniors");
            System.out.println("2. River Plate");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                   
                    crearEquipoBocaJuniors();
                    break;
                case 2:
                    
                    crearEquipoRiverPlate();
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void persistirEquipo(Equipo equipo) {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            String sql = "INSERT INTO equipo (nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, equipo.getNombre());
                pstmt.setInt(2, equipo.getTitulares());
                pstmt.setInt(3, equipo.getSuplentes());
                pstmt.setString(4, equipo.getDirectorTecnico());
                pstmt.setInt(5, equipo.getPuntos());
                pstmt.setInt(6, equipo.getPartidosJugados());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipo obtenerEquipo() {
        Equipo equipo = null;

        try (Connection connection = ConexionDB.obtenerConexion()) {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre del equipo: ");
           String nombre = scanner.nextLine();

            String sql = "SELECT * FROM equipo WHERE nombre = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, nombre);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        
                        String nombreEquipo = rs.getString("nombre");
                        int titulares = rs.getInt("titulares");
                        int suplentes = rs.getInt("suplentes");
                        String directorTecnico = rs.getString("directorTecnico");
                        int puntos = rs.getInt("puntos");
                        int partidosJugados = rs.getInt("partidosJugados");

                        
                        equipo = new BocaJuniors(nombreEquipo, titulares, suplentes, directorTecnico, puntos, partidosJugados);
                        System.out.println(equipo);
                    } else {
                        System.out.println("No se encontró un equipo con ese nombre.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipo;
    }

    @Override
    public void actualizarEquipo() {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            Scanner scanner = new Scanner(System.in);

            
            System.out.print("Ingrese el nombre del equipo que desea actualizar: ");
            String nombre = scanner.nextLine();

            
            Equipo equipoExistente = obtenerEquipo();

            if (equipoExistente != null) {
                
                System.out.print("Ingrese la nueva cantidad de titulares: ");
                int nuevosTitulares = scanner.nextInt();

                System.out.print("Ingrese la nueva cantidad de suplentes: ");
                int nuevosSuplentes = scanner.nextInt();

                scanner.nextLine();  // Consumir la nueva línea

                System.out.print("Ingrese el nuevo nombre del director técnico: ");
                String nuevoDirectorTecnico = scanner.nextLine();

                System.out.print("Ingrese la nueva cantidad de puntos: ");
                int nuevosPuntos = scanner.nextInt();

                System.out.print("Ingrese la nueva cantidad de partidos jugados: ");
                int nuevosPartidosJugados = scanner.nextInt();

               
                String sql = "UPDATE equipo SET titulares = ?, suplentes = ?, directorTecnico = ?, puntos = ?, partidosJugados = ? WHERE nombre = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                    pstmt.setInt(1, nuevosTitulares);
                    pstmt.setInt(2, nuevosSuplentes);
                    pstmt.setString(3, nuevoDirectorTecnico);
                    pstmt.setInt(4, nuevosPuntos);
                    pstmt.setInt(5, nuevosPartidosJugados);
                    pstmt.setString(6, nombre);

                    int filasAfectadas = pstmt.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Equipo actualizado exitosamente.");
                    } else {
                        System.out.println("No se pudo actualizar el equipo.");
                    }
                }
            } else {
                System.out.println("No se encontró un equipo con ese nombre.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEquipo() {
        try (Connection connection = ConexionDB.obtenerConexion()) {
            Scanner scanner = new Scanner(System.in);

            
            System.out.print("Ingrese el nombre del equipo que desea eliminar: ");
            String nombreEquipo = scanner.nextLine();

            String sql = "DELETE FROM equipo WHERE nombre = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, nombreEquipo);

                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Equipo eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró un equipo con ese nombre.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Equipo> obtenerTodosLosEquipos() {
        List<Equipo> equipos = new ArrayList<>();

        try (Connection connection = ConexionDB.obtenerConexion()) {
            String sql = "SELECT * FROM equipo";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        
                        String nombre = rs.getString("nombre");
                        int titulares = rs.getInt("titulares");
                        int suplentes = rs.getInt("suplentes");
                        String directorTecnico = rs.getString("directorTecnico");
                        int puntos = rs.getInt("puntos");
                        int partidosJugados = rs.getInt("partidosJugados");

                        
                        Equipo equipo = new BocaJuniors(nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados);
                        System.out.println(equipo);

                        
                        equipos.add(equipo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipos;
    }

}



