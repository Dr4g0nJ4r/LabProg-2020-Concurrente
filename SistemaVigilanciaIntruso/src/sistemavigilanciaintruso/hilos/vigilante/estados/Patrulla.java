/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.vigilante.estados;

import java.util.logging.Level;
import java.util.logging.Logger;
import sistemavigilanciaintruso.hilos.vigilante.Vigilante;
import sistemavigilanciaintruso.hilos.vigilante.estados.EstadoVigilante;

/**
 *
 * @author Me
 */
public class Patrulla implements EstadoVigilante {

    int tiempo = 5000;                                                          //tiempo que se tarda en patrullar la sala.
    String nombre = "Patrulla";                                                 //nombre del estado

    @Override
    public void accion(Vigilante vigilante) {
        int nro = vigilante.getNroSalaActual();                                 //obtenemos el numero de sala a visitar
        if (vigilante.esCerradoMuseo()) {                                       //si está cerrado, hace la patrulla.
            System.out.println("Vigilante : El museo está abierto....");
            vigilante.entrarEnSalaMuseo(nro);                                   //visita una sala y verifica si hay alguien.
            System.out.println("Vigilante : Entré a la sala " + vigilante.obtenerNombreSalaMuseo(nro));
            vigilante.setCantidadSalasRecorridas(vigilante.getCantSalasRecorridas() + 1);
            if (vigilante.alguienSalaMuseo(nro)) {
                System.out.println("Vigilante : HAY ALGUIEN EN LA SALA!! ALTO AHÍ!!");
                vigilante.setEstado(new Peligro());                             //si hay alguien, pasa a un estado de peligro.
            } else if (vigilante.obtenerValorSalaMuseo(nro) == 0) {             //si no hay nadie, verifica que no falte nada (valor igual a 0 significa que han robado)
                System.out.println("Vigilante : han entrado a robar!!, estaré alerta!");
                vigilante.setEstado(new Alerta());                              //en caso de robo, pasamos a un estado de alerta.
            } else if (vigilante.getCantSalasRecorridas() == 2) {               //si la cantSalas es igual a 2, pasamos a un estado de descanso.
                System.out.println("Vigilante : uff que agotador, descansaré un rato entre los cuadros...");
                vigilante.setEstado(new Descanso());
            } else {
                try {
                    Thread.sleep(tiempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Patrulla.class.getName()).log(Level.SEVERE, null, ex);
                } finally {                                                       //en caso de que falle el método sleep ejecuta los demás comportamientos.

                    System.out.println("Vigilante : Todo normal,pasaré a otra sala....");
                    vigilante.incrementarNroSalaActual();                       //incrementa el valor de la sala
                    vigilante.salirDeSalaMuseo(nro);                            //salir de la sala
                }
            }
        } else {
            System.out.println("Vigilante : Ya se termina mi jornada...nada fuera de lugar por hoy...");
            vigilante.salirDeSalaMuseo(nro);                                    //salir de la sala
            vigilante.setTermina(true);
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
