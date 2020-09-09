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
    int cantSalas = 0;                                                          //variable para contar las salas visitadas y descansar
    int nroSalaActual = 0;                                                      //variable para recorrer las salas
    String nombre = "Patrulla";                                                 //nombre del estado

    @Override
    public boolean accion(Vigilante vigilante) {
        boolean termina = false;
        int nro = 0;
        if (vigilante.getMuseo().EsAbierto()) {                                 //si está abierto el museo, hace la patrulla.
            System.out.println("Vigilante : El museo está abierto....");
            nro = nroSalaActual % vigilante.getMuseo().getCantidad();           //permite ciclar entre la sala 0 y el tamaño del museo.
            vigilante.getMuseo().entrarASala(nro);                              //visita una sala y verifica si hay alguien.
            System.out.println("Vigilante : Entré a la sala " + vigilante.getMuseo().obtenerNombreSala(nro));
            cantSalas++;
            if (vigilante.getMuseo().hayAlguienEnSala(nro)) {
                System.out.println("Vigilante : HAY ALGUIEN EN LA SALA!! ALTO AHÍ!!");
                vigilante.setEstado(new Peligro());                             //si hay alguien, pasa a un estado de peligro.
            } else if (vigilante.getMuseo().obtenerValorSala(nro) == 0) {       //si no hay nadie, verifica que no falte nada (valor igual a 0 significa que han robado)
                System.out.println("Vigilante : han entrado a robar!!, estaré alerta!");
                vigilante.setEstado(new Alerta());                              //en caso de robo, pasamos a un estado de alerta.
            } else if (cantSalas == 2) {                                        //si la cantSalas es igual a 2, pasamos a un estado de descanso.
                System.out.println("Vigilante : uff que agotador, descansaré un rato entre los cuadros...");
                vigilante.setEstado(new Descanso());

            } else {
                try {
                    Thread.sleep(tiempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Patrulla.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Vigilante : Todo normal,pasaré a otra sala....");
                nroSalaActual++;
            }
        } else {
            System.out.println("Vigilante : Ya se termina mi jornada...nada fuera de lugar por hoy...");
            termina = true;
        }
        return termina;

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
