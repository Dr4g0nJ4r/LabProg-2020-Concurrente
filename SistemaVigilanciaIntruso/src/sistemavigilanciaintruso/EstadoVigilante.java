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
public abstract interface EstadoVigilante {
    
    public void accion();
    
    public int getVelocidad();
    
    public String getNombreEstado();
    
}
