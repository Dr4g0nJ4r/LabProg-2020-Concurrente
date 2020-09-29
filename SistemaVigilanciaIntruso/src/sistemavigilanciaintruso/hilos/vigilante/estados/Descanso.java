/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.vigilante.estados;

import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavigilanciaintruso.hilos.vigilante.Vigilante;

/**
 *
 * @author Me
 */
public class Descanso implements EstadoVigilante {

    int tiempo = 1000;
    String nombre = "Descanso";

    @Override
    public void accion(Vigilante vigilante) {
        //verificar que el museo está abierto
        vigilante.entrarEnSalaMuseo(vigilante.getNroSalaActual());
        vigilante.actualizarInforme("Estoy en la sala de " + vigilante.obtenerNombreSalaMuseo(vigilante.getNroSalaActual()));
        vigilante.actualizarInforme("Que belleza!...");               //hace un comentario sobre la sala
        try {
            Thread.sleep(tiempo);                                       //descansa una determinada cantidad de tiempo en la sala en la que quedó.
        } catch (InterruptedException ex) {
            Logger.getLogger(Descanso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            vigilante.setCantidadSalasRecorridas(0);                    //resetea el valor de la cantidad de salas visitadas
            vigilante.salirDeSalaMuseo(vigilante.getNroSalaActual());
            vigilante.setEstado(new Patrulla());                        //reanuda la patrulla
        }

    
    }

    @Override
    public int getTiempo() {
        return tiempo;
    }

    @Override
    public String getNombreEstado() {
        return nombre;
    }
}
