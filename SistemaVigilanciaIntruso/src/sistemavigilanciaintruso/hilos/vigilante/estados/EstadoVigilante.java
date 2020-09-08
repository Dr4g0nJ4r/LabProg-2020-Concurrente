/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.vigilante.estados;

import sistemavigilanciaintruso.hilos.Persona;

/**
 *
 * @author Me
 */
public abstract interface EstadoVigilante {
    
    public boolean accion(Persona persona);
    
    public int getTiempo();
    
    public String getNombreEstado();
    
}
