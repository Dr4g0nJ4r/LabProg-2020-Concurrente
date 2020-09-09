/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.vigilante.estados;
import sistemavigilanciaintruso.hilos.vigilante.Vigilante;
import sistemavigilanciaintruso.hilos.vigilante.estados.EstadoVigilante;

/**
 *
 * @author Me
 */
public class Patrulla implements EstadoVigilante{
    int tiempo = 5000;
    String nombre = "Patrulla";
    
    @Override
    public boolean accion(Vigilante vigilante){
        boolean termina = false;
        if(vigilante.getMuseo().EsAbierto()){                                   //si está abierto el museo, entra a hacer la patrulla.
            
        }else{
            termina =true;
        }
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
