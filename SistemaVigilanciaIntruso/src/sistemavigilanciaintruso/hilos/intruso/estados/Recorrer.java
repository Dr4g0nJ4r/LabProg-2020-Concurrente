/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.intruso.estados;

import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavigilanciaintruso.hilos.intruso.Intruso;

/**
 *
 * @author Me
 */
public class Recorrer implements EstadoIntruso{

    private String nombre = "Recorrer";
    private int tiempo = 7000;
            
    @Override
    public void accion(Intruso persona) {
        boolean recorriendo = true;
        int numSala;
        do
        {
            numSala = persona.elegirSala();
            try {
                Thread.sleep(tiempo);
                if(persona.alguienSalaMuseo(numSala))
                {
                    persona.entrarEnSalaMuseo(numSala);
                    persona.setNroSalaActual(numSala);
                    persona.setEstado(new Robar());
                    persona.actualizarInforme("Ingresé a robar a la sala de " + persona.obtenerNombreSalaMuseo(persona.getNroSalaActual()));
                    recorriendo = !recorriendo;
                }
                else
                {
                    persona.actualizarInforme("El guardia estaba en la sala de " + persona.obtenerNombreSalaMuseo(persona.getNroSalaActual())+"... mejor voy a otra");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Recorrer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(recorriendo);
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
