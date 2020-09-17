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
        persona.actualizarInforme("Me han atrapado... Diablos");
        System.out.println("Intruso : Me han atrapado..diablos");
        persona.atrapado();
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
