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
public class Intruso extends Persona implements EstadoIntruso{
    EstadoIntruso estado;
    public Intruso(){
        this.estado = new Recorrer();
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
