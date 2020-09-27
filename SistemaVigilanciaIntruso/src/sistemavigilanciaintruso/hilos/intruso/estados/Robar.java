package sistemavigilanciaintruso.hilos.intruso.estados;

import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavigilanciaintruso.hilos.intruso.Intruso;

public class Robar implements EstadoIntruso{

    
    private String nombre = "Robar";
    private int tiempo = 1000;
    
    @Override
    public void accion(Intruso persona) {
        try {
            Thread.sleep(tiempo);
            int sala = persona.getNroSalaActual();
            persona.robarMuseo(sala);
            persona.salirDeSalaMuseo(sala);
            persona.actualizarInforme("Robé la sala de " + persona.obtenerNombreSalaMuseo(sala));
           
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