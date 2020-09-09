/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import sistemavigilanciaintruso.recurso.Sala;

/**
 *
 * @author Me
 */
public class Museo {
    private Lock lock = new ReentrantLock();
    int cantidad =1;
    private Sala[] salas;
    boolean esAbierto = true;
    
    public Museo(int cant){
        this.cantidad=cant;
        this.salas = new Sala[cantidad];
    }
    public Sala[] getSalas() {
        return salas;
    }

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public boolean EsAbierto() {
        return esAbierto;
    }
    
    public boolean entrarASala(int n){
        //metodo para ir a la sala numero "n"
        //retorna true si fue posible entrar a la sala
        
        boolean exito = false;
        lock.lock();
        try {
            if(n>0 && n<=this.cantidad){
                exito=true;
                salas[n].entrar();
            }
        } finally {
            lock.unlock();
        }
        return exito;
    }
    
    public boolean salirSala(int n){
        //metodo para salir de una sala
        
        boolean exito = false;
        lock.lock();
        try {
            if(n>0 && n<=this.cantidad){
                exito=true;
                salas[n].salir();
            }
        } finally {
            lock.unlock();
        }
        return exito;
    }
    //Método para indicar si hay una persona en una sala especifica.
    
    public boolean hayAlguienEnSala(int n){
        boolean exito = false;
        lock.lock();
        try {
            if(this.salas[n].getCantidadPersonas()!=0){
                exito = true;
            }
        } finally {
            lock.unlock();
        }
        return exito;
    }
    
    public int obtenerValorSala(int n){
        return this.salas[n].getValor();
    }
    
    public void abrir(){
        this.esAbierto=true;
    }
    
    public void cerrar(){
        this.esAbierto=false;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
}
