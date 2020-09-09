/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.vigilante;

import sistemavigilanciaintruso.hilos.vigilante.estados.EstadoVigilante;
import sistemavigilanciaintruso.hilos.vigilante.estados.Patrulla;
import sistemavigilanciaintruso.recurso.Museo;
import sistemavigilanciaintruso.hilos.Persona;

/**
 *
 * @author Me
 */
public class Vigilante extends Persona implements EstadoVigilante{
    EstadoVigilante estado;                                                     //variable de los estados del vigilante
    int tiempo = 0;                                                          //valocidad de recorrido 
    Museo museo;
    String informe;
    
    public Vigilante(Museo m){
        this.estado = new Patrulla();
        this.museo = m;
    }

    @Override
    public String call() throws InterruptedException {
        this.informe = "Informe del vigilante";
        boolean termina = false;
        
        while(!termina){
            termina = this.estado.accion(this);
        }
        return informe;
    }
    
    @Override
    public boolean accion(Vigilante persona){
        return estado.accion(persona);
    }
    
    @Override
    public String getNombreEstado(){
        return estado.getNombreEstado();
    }
    
    @Override
    public int getTiempo(){
        return estado.getTiempo();
    }
    
    public void actualizarInforme(String dato){
        this.informe += dato;
    }
    
    public Museo getMuseo(){
        
        return this.museo;
    }
    
}
