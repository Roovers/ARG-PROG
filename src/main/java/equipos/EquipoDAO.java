package equipos;

import java.util.List;

public interface EquipoDAO {
    // Crea un equipo en la base de datos
    void crearEquipoBocaJuniors();

    void crearEquipoRiverPlate();

    void crearEquipo();

    // Obtiene un equipo por su nombre
    Equipo obtenerEquipo();

    // Actualiza la información de un equipo en la base de datos
    void actualizarEquipo();

    // Elimina un equipo por su nombre
    void eliminarEquipo();

    // Obtiene una lista de todos los equipos en la base de datos
    List<Equipo> obtenerTodosLosEquipos();

}

