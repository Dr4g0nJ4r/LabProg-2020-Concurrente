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
public class Descanso implements EstadoVigilante{
    int velocidad = 10000;
    String nombre = "Descanso";
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
