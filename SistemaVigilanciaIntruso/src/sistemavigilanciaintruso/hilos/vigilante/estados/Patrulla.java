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
public class Patrulla implements EstadoVigilante {

    int tiempo = 500;                                                          //tiempo que se tarda en patrullar la sala.
    String nombre = "Patrulla";                                                 //nombre del estado

    @Override
    public void accion(Vigilante vigilante) {
        int nro = vigilante.getNroSalaActual();                                 //obtenemos el numero de sala a visitar

        if (vigilante.alguienSalaMuseo(nro)) {

            vigilante.actualizarInforme("HAY ALGUIEN EN LA SALA!! DE " + vigilante.obtenerNombreSalaMuseo(nro) + " ALTO AHÍ!!");
            vigilante.setEstado(new Peligro());                             //si hay alguien, pasa a un estado de peligro.
        } else if (vigilante.esRobadoSalaMuseo(nro)) {                      //si no hay nadie, verifica que no falte nada (valor igual a 0 significa que han robado)
            vigilante.actualizarInforme("han entrado a robar!!, estaré alerta!");
            vigilante.setEstado(new Alerta());                              //en caso de robo, pasamos a un estado de alerta.
        } else if (vigilante.getCantSalasRecorridas() != 2) {               //si la cantSalas es igual a 2, pasamos a un estado de descanso.
            try {
                vigilante.entrarEnSalaMuseo(nro);
                vigilante.actualizarInforme("Entré a la sala " + vigilante.obtenerNombreSalaMuseo(nro));
                vigilante.setCantidadSalasRecorridas(vigilante.getCantSalasRecorridas() + 1);
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Patrulla.class.getName()).log(Level.SEVERE, null, ex);
            } finally {                                                     //en caso de que falle el método sleep ejecuta los demás comportamientos.
                vigilante.actualizarInforme("Todo normal,pasaré a otra sala....");
                vigilante.incrementarNroSalaActual();                       //incrementa el valor de la sala
                vigilante.salirDeSalaMuseo(nro);                            //salir de la sala
            }

        } else {
            vigilante.actualizarInforme("....uff que agotador, descansaré un rato entre los cuadros...");
            vigilante.setEstado(new Descanso());
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
