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
public abstract interface EstadoIntruso {
    
    public void accion(Intruso persona);
    
    public int getTiempo();
    
    public String getNombreEstado();
}
