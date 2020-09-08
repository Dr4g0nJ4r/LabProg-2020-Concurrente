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
    
    public void entrar(){
        this.hayPersona=true;
    }
    
    public void salir(){
        this.hayPersona=false;
    }
    
    public boolean hayPersona(){
        return this.hayPersona;
    }
}
