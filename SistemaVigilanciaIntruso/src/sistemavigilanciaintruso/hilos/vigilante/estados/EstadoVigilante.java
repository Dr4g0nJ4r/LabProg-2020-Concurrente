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
public abstract interface EstadoVigilante {
    
    public void accion(Vigilante persona);
    
    public int getTiempo();
    
    public String getNombreEstado();
    
}
