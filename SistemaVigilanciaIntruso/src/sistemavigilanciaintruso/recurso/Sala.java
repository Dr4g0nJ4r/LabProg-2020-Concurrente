/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;

/**
 *
 * @author Me
 */
public class Sala {
    private boolean hayPersona =false;
    private String nombre;
    private int valor;
    
    public void entrar(){
        this.hayPersona=true;
    }
    
    public void salir(){
        this.hayPersona=false;
    }
    
    public boolean hayPersona(){
        return this.hayPersona;
    }
    
    public void setNombre(String nom){
        this.nombre=nom;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setValor(int v){
        this.valor=v;
    }
    
    public int getValor(){
        return this.valor;
    }
    
}
