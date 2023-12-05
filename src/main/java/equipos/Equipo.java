package equipos;

import java.io.Serializable;

public abstract class Equipo implements Serializable{

    private String nombre;
    private int titulares;
    private int suplentes;
    private String directorTecnico;
    private int puntos;
    private int partidosJugados;

    public Equipo() {
      
    }

    public Equipo(String nombre, int titulares, int suplentes, String directorTecnico, int puntos, int partidosJugados) {
        this.nombre = nombre;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.directorTecnico = directorTecnico;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTitulares() {
        return titulares;
    }

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public int getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    

    public final void jugarPartido() {
        precalentamiento();
        charlaTactica();
        jugarPartido();
        retirarse();
    }

    
    void precalentamiento() {
        System.out.println("Calentando para el partido");
    }

    void retirarse() {
        System.out.println("El equipo se retira del estadio.");
    }

    
    abstract void charlaTactica();

    
    abstract void realizarJuego();

    @Override
    public String toString() {
        return
                "   nombre=" + nombre +
                "\n titulares=" + titulares +
                "\n suplentes=" + suplentes +
                "\n directorTecnico='" + directorTecnico + '\'' +
                "\n puntos=" + puntos +
                "\n partidosJugados=" + partidosJugados
                ;
    }
}
