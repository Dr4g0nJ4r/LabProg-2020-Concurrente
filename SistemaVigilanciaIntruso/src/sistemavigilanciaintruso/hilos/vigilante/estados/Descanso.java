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

    int tiempo = 10000;
    String nombre = "Descanso";

    @Override
    public void accion(Vigilante vigilante) {
        if (vigilante.esCerradoMuseo()) {                                       //verificar que el museo está abierto
            System.out.println("Vigilante : El museo está abierto....");
            if (vigilante.alguienSalaMuseo(vigilante.getNroSalaActual())) {     //en el caso de que halla alguien en la sala en el momento del descanso cambia de estado a peligro.
                vigilante.setEstado(new Peligro());
            } else {
                System.out.println("Vigilante : Estoy en la sala de " + vigilante.obtenerNombreSalaMuseo(vigilante.getNroSalaActual()));
                System.out.println("Vigilante: Que belleza!...");               //hace un comentario sobre la sala
                try {
                    Thread.sleep(tiempo);                                       //descansa una determinada cantidad de tiempo en la sala en la que quedó.
                } catch (InterruptedException ex) {
                    Logger.getLogger(Descanso.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    vigilante.setCantidadSalasRecorridas(0);                    //resetea el valor de la cantidad de salas visitadas
                    vigilante.setEstado(new Patrulla());                        //reanuda la patrulla
                    vigilante.actualizarInforme("tomé un descanso");
                }
            }
        } else {
            System.out.println("Vigilante : Ya se termina mi jornada...por suerte ya estaba en el descanso...");
            vigilante.setTermina(true);
        }//actualiza el informe
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
