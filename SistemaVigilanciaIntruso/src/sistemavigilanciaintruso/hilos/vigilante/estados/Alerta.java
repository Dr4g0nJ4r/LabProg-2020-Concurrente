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
public class Alerta implements EstadoVigilante{
    int tiempo = 2000;
    String nombre = "Alerta";
    
    @Override
    public boolean accion(Vigilante vigilante){
        boolean termina = false;
        if(vigilante.esCerradoMuseo()){
            System.out.println("Vigilante : El museo está abierto....");
        }else{
            termina = true;
        }
        //verifica que el museo este cerrado
        //recorre las salas en un tiempo más corto que la patrulla
        //hace las verificaciones de hay persona de una manera mas rapida
        //hace un comentario del estado de alerta
        //la cantidad de salar recorridas tiene que ser mayor al estado de patrulla antes de pasar a patrulla
        //reanuda la patrulla si no encuentra a nadie..
        //va a un estado de peligro en caso de encontrar a alguien.
        //no hace verificacion de faltante de algo de valor.
        //actualiza el informe
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
