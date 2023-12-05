package equipos;

public class BocaJuniors extends Equipo {

    public BocaJuniors() {
    }
    public BocaJuniors(String nombre, int titulares, int suplentes, String directorTecnico, int puntos, int partidosJugados) {
        super(nombre, titulares, suplentes, directorTecnico, puntos, partidosJugados);

    }

    @Override
    void charlaTactica() {
        System.out.println("Dominio del balon con disposicion al ataque");
    }

    @Override
    void realizarJuego() {
        System.out.println("El equipo no consigue ejecutar el plan");
    }

}

