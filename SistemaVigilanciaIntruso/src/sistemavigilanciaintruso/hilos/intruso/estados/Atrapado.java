/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.intruso.estados;

import sistemavigilanciaintruso.hilos.intruso.Intruso;

/**
 *
 * @author Me
 */
public class Atrapado implements EstadoIntruso{

    
    private String nombre = "Atrapado";
    private int tiempo = 1000;
    
    @Override
    public void accion(Intruso persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTiempo() {
        return this.tiempo;
    }

    @Override
    public String getNombreEstado() {
        return this.nombre;
    }
    
}
