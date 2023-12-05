package equipos;

import java.util.List;

public interface EquipoDAO {
    
    void crearEquipoBocaJuniors();

    void crearEquipoRiverPlate();

    void crearEquipo();
    
    Equipo obtenerEquipo();

    void actualizarEquipo();

    void eliminarEquipo();

    List<Equipo> obtenerTodosLosEquipos();

}

