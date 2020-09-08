/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;

import sistemavigilanciaintruso.recurso.Sala;

/**
 *
 * @author Me
 */
public class Museo {
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
    
    public boolean irASala(int n){
        //metodo para ir a la sala numero "n"
        //retorna true si fue posible entrar a la sala
        
        boolean exito = false;
        if(n>0 && n<=this.cantidad){
            exito=true;
            salas[n].entrar();
        }
        return exito;
    }
    
    public boolean salirSala(int n){
        //metodo para salir de una sala
        
        boolean exito = false;
        
        if(n>0 && n<=this.cantidad){
            exito=true;
            salas[n].salir();
        }
        return exito;
    }
    //Método para indicar si hay una persona en una sala especifica.
    public boolean hayAlguienEnSala(int n){
        return this.salas[n].hayPersona();
    }
    
    public void abrir(){
        this.esAbierto=true;
    }
    
    public void cerrar(){
        this.esAbierto=false;
    }
}
