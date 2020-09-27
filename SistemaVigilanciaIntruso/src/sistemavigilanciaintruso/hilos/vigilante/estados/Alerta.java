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
public class Alerta implements EstadoVigilante {

    int tiempo = 200;
    String nombre = "Alerta";

    @Override
    public void accion(Vigilante vigilante) {
        int nro = vigilante.getNroSalaActual();
        vigilante.actualizarInforme(nombre);
        vigilante.entrarEnSalaMuseo(nro);
        vigilante.actualizarInforme("Entré a la sala " + vigilante.obtenerNombreSalaMuseo(nro));
        vigilante.setCantidadSalasRecorridas(vigilante.getCantSalasRecorridas() + 1);
        if (vigilante.alguienSalaMuseo(nro)) {
            vigilante.actualizarInforme("HAY ALGUIEN EN LA SALA!! ALTO AHÍ!!");
            vigilante.setEstado(new Peligro());                             //si hay alguien, pasa a un estado de peligro.
        } else if (vigilante.getCantSalasRecorridas() == 5) {               //si la cantSalas es igual a 5, pasamos a un estado de patrulla.
            vigilante.actualizarInforme("No vi nada sospechoso...");
            vigilante.setEstado(new Patrulla());
            vigilante.setCantidadSalasRecorridas(0);                        //resetea la cantidad de salas recorridas antes de pasar a patrulla.
        } else {
            try {
                Thread.sleep(tiempo);                                       //recorre las salas en un tiempo más corto que la patrulla
            } catch (InterruptedException ex) {
                Logger.getLogger(Patrulla.class.getName()).log(Level.SEVERE, null, ex);
            } finally {                                                       //en caso de que falle el método sleep ejecuta los demás comportamientos.

                vigilante.actualizarInforme("No hay nadie!,pasaré a otra sala....");
                vigilante.incrementarNroSalaActual();                       //incrementa el valor de la sala
                vigilante.salirDeSalaMuseo(nro);                            //salir de la sala
            }
        }
        
        
        //hace las verificaciones de hay persona de una manera mas rapida
        //va a un estado de peligro en caso de encontrar a alguien.
        //no hace verificacion de faltante de algo de valor.
        //actualiza el informe
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
