/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.vigilante.estados;
import sistemavigilanciaintruso.hilos.vigilante.Vigilante;

/**
 *
 * @author Me
 */
public class Descanso implements EstadoVigilante{
    int tiempo = 10000;
    String nombre = "Descanso";
    
    @Override
    public boolean accion(Vigilante vigilante){
        boolean termina = false;
        
        return termina;
        
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
