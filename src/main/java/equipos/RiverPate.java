package equipos;

public class RiverPate extends Equipo{

    public RiverPate() {
    }
    public RiverPate(String nombre, int titulares, int suplentes, String directorTecnico, int puntos, int partidosJugados) {
        super(nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados);
    }

    @Override
    void charlaTactica() {
        System.out.println("Juego defensivo por el centro del campo");
    }

    @Override
    void realizarJuego() {
        System.out.println("Se consigue jugar a nivel aceptable");
    }


}
