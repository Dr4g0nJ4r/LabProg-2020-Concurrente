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
public class Vigilante extends Persona{
    private EstadoVigilante estado;                                                     //variable de los estados del vigilante
    private Museo museo;
    private StringBuilder informe;
    private int nroSalaActual = 1;                                                      //variable para recorrer las salas
    private int cantSalas = 0;                                                          //variable para contar las salas visitadas y descansar
    private boolean termina = false;
    
    public Vigilante(Museo m){
        this.estado = new Patrulla();
        this.museo = m;
        this.informe = new StringBuilder(); 
        this.informe.append("Informe del vigilante");
    }
    
    public void setTermina(boolean term){
        this.termina=term;
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
    public boolean esCerradoMuseo(){
        return this.museo.EsCerrado();
    }
    public void incrementarNroSalaActual(){
        this.nroSalaActual = (this.nroSalaActual + 1) % this.museo.getCantidad();//permite ciclar entre la sala 0 y el tamaño del museo.
    }

    @Override
    public String call() throws InterruptedException {
        
        while(!this.museo.EsCerrado()){
            Thread.sleep(3000);
        }
        this.actualizarInforme("El museo está cerrado....");
        while(!this.termina){
            this.estado.accion(this);
        }
        this.setTermina(true);
        return informe.toString();
    }
    
    public void activarAlarma(){
        this.museo.intrusoDetectado();
    }
    
    public boolean entrarEnSalaMuseo(int nro){
        return this.museo.entrarASala(nro);
    }
    
    public boolean salirDeSalaMuseo(int nro){
        return this.museo.salirSala(nro);
    }
    
    
    
    
    
    public void actualizarInforme(String dato){
        this.informe.append("Vigilante (Estado "+this.estado.getNombreEstado()+") Hora: " +Integer.toString(this.museo.getHora())+" ---> "+dato+"\n");
    }
    
    public Museo getMuseo(){
        
        return this.museo;
    }
    
    public void setEstado(EstadoVigilante e){
        this.estado=e;
    }
    
    public String obtenerNombreSalaMuseo(int nro){
        return this.museo.obtenerNombreSala(nro);
    }
    
    public boolean alguienSalaMuseo(int nro){
        return this.museo.hayAlguienEnSala(nro);
    }
    
    public boolean esRobadoSalaMuseo(int nro){
        return this.museo.esRobadoSala(nro);
    }

    private String getNombreEstado() {
        return this.estado.getNombreEstado();
    }
}
