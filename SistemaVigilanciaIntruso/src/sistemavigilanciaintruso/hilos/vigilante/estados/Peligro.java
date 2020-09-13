/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.vigilante.estados;
import sistemavigilanciaintruso.hilos.vigilante.Vigilante;
import sistemavigilanciaintruso.hilos.vigilante.estados.EstadoVigilante;

/**
 *
 * @author Me
 */
public class Peligro implements EstadoVigilante{
    int tiempo = 1000;
    String nombre = "Peligro";
    
    @Override
    public boolean accion(Vigilante vigilante){
        boolean termina = false;
        vigilante.setNroSalaActual(0);
        vigilante.entrarEnSalaMuseo(0);                                         //se dirige inmediatamente a la sala de vigilantia (nro = 0)
        System.out.println("Vigilante : estoy en "+vigilante.obtenerNombreSalaMuseo(0));
        System.out.println("Vigilante : Voy a llamar a la policia!!");          //llama a la policia
        vigilante.actualizarInforme("Encontré a un intruso y llamé a la policía.");//coloca en el informe la situación
        termina = true;                                                         //termina la ejecucion del hilo
        
        //puede recorrer todas las salas dede la sala actual hasta la sala de vigilancia como para dar una sensacion de recorrido...
        return termina;
        
    }
    
    @Override
    public int getTiempo(){
        return tiempo;
    }
    
    @Override
    public String getNombreEstado(){
        return nombre;
    }
}
