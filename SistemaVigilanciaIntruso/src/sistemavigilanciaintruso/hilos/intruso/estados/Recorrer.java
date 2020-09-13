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
public class Recorrer implements EstadoIntruso{

    private String nombre = "Recorrer";
    private int tiempo = 7000;
            
    @Override
    public void accion(Intruso persona) {

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
