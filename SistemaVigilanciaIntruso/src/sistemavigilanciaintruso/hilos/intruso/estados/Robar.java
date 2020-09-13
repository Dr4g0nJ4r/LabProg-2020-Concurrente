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
        } catch (InterruptedException ex) {
            Logger.getLogger(Robar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getTiempo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombreEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}