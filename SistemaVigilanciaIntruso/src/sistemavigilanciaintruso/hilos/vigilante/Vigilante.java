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
    private EstadoVigilante estado;                                                     //variable de los estados del vigilante
    private Museo museo;
    private String informe;
    private int nroSalaActual = 1;                                                      //variable para recorrer las salas
    private int cantSalas = 0;                                                          //variable para contar las salas visitadas y descansar
    
    public Vigilante(Museo m){
        this.estado = new Patrulla();
        this.museo = m;
    }
    
    public int getCantSalasRecorridas(){
        return this.cantSalas;
    }
    
    public void setCantidadSalasRecorridas(int cant){
        this.cantSalas = cant;
    }
    public void setNroSalaActual(int n){
        this.nroSalaActual=n;
    }
    public int getNroSalaActual(){
        return nroSalaActual;
    }
    
    public void incrementarNroSalaActual(){
        this.nroSalaActual = (this.nroSalaActual + 1) % this.museo.getCantidad();//permite ciclar entre la sala 0 y el tamaño del museo.
    }

    @Override
    public String call() throws InterruptedException {
        this.informe = "Informe del vigilante";
        boolean termina = false;
        
        while(!termina){
            System.out.println("El vigilante esta en un estado de : "+this.getNombreEstado());
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
    
    public void setEstado(EstadoVigilante e){
        this.estado=e;
    }
}
