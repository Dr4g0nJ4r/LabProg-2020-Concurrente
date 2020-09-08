/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.intruso;

import sistemavigilanciaintruso.hilos.intruso.estados.Recorrer;
import sistemavigilanciaintruso.recurso.Museo;
import sistemavigilanciaintruso.hilos.Persona;
import sistemavigilanciaintruso.hilos.intruso.estados.EstadoIntruso;

/**
 *
 * @author Me
 */
public class Intruso extends Persona implements EstadoIntruso{
    EstadoIntruso estado;
    Museo museo;
    public Intruso(Museo m){
        this.estado = new Recorrer();
        this.museo = m;
    }
    
    @Override
    public String call(){
        String informe = "";                                                    //variable que sirve para armar un informe sobre las actividades del intruso.
        boolean termina = false;   
        System.out.println("soy intruso");                                      //variable que me pemite controlar si el intruso termina sus actividades.
        
        informe = "Informe del Intruso";
        return informe;
    }
}
