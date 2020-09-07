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
public class Vigilante extends Persona implements EstadoVigilante{
    EstadoVigilante estado;                                                     //variable de los estados del vigilante
    int velocidad = 0;                                                          //valocidad de recorrido 
    Museo museo;
    
    public Vigilante(Museo m){
        this.estado = new Patrulla();
        this.museo = m;
    }

    @Override
    public String call() throws InterruptedException {
        String informe = "Informe del vigilante";
        boolean termina = false;
        
        while(!termina){
            Thread.sleep(5000);
            System.out.println("soy vigilante");
            termina = true;
        }
        return informe;
    }
    
    @Override
    public void accion(){
        estado.accion();
    }
    
    @Override
    public String getNombreEstado(){
        return estado.getNombreEstado();
    }
    
    @Override
    public int getVelocidad(){
        return estado.getVelocidad();
    }
    
}
