/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso;

/**
 *
 * @author Me
 */
public class Patrulla implements EstadoVigilante{
    int velocidad = 5000;
    String nombre = "Patrulla";
    
    @Override
    public void accion(){
        
    }
    
    @Override
    public int getVelocidad(){
        return velocidad;
    }
    
    @Override
    public String getNombreEstado(){
        return nombre;
    }
}
