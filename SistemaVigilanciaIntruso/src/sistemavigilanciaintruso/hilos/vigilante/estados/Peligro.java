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
    public void accion(Vigilante vigilante){
        vigilante.setNroSalaActual(0);
        vigilante.entrarEnSalaMuseo(0);                                         //se dirige inmediatamente a la sala de vigilantia (nro = 0)
        System.out.println("Vigilante : estoy en "+vigilante.obtenerNombreSalaMuseo(0));
        System.out.println("Vigilante : Voy a activar la alarma!!");          //llama a la policia
        vigilante.activarAlarma();
        vigilante.actualizarInforme("Encontré a un intruso, activé la alarma y llamé a la policía.");//coloca en el informe la situación
        vigilante.setTermina(true);                                             //termina la ejecución del hilo
        
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
