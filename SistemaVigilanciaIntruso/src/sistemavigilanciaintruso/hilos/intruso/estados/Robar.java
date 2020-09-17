package sistemavigilanciaintruso.hilos.intruso.estados;

import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavigilanciaintruso.hilos.intruso.Intruso;

public class Robar implements EstadoIntruso{

    
    private String nombre = "Robar";
    private int tiempo = 10000;
    
    @Override
    public void accion(Intruso persona) {
        try {
            Thread.sleep(tiempo);
            persona.actualizarInforme("Robé la sala de " + persona.obtenerNombreSalaMuseo(persona.getNroSalaActual()));
            persona.setEstado(new Recorrer());
        } catch (InterruptedException ex) {
            Logger.getLogger(Robar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getTiempo() {
         return this.tiempo;
    }

    @Override
    public String getNombreEstado() {
        return this.nombre;
    }
    
}