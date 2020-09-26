/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso;

import sistemavigilanciaintruso.recurso.*;
import sistemavigilanciaintruso.hilos.intruso.Intruso;
import sistemavigilanciaintruso.hilos.vigilante.Vigilante;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Me
 */
public class SistemaVigilanciaIntruso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] nombresSalas = {"Vigilancia","Arte moderno","Arte clasico","Arte abstracto","Arte de vanguardia","Arte prehispanico","Arte plastico","Arte callejero","Arte contemporaneo","Arte bizantino","Arte surrealista","Artes visuales"};
        
        Museo museo = new Museo(nombresSalas);
        try {
            ExecutorService servicio = Executors.newFixedThreadPool(3);         //creo un pool con dos hilos.
            Future informeVigilante = servicio.submit(new Vigilante(museo));    //creo una variable future que va a almacenar el informe del vigilante
            Future informeIntruso = servicio.submit(new Intruso(museo));        //creo una variable future que va a almacenar el informe del Intruso
            servicio.submit(new ControlTiempo(museo));
            
            System.out.println("Informes:");
            System.out.println(informeIntruso.get());
            System.out.println(informeVigilante.get());
            servicio.shutdownNow();                                                //cuando los hilos se detengan cierro el servicio.
           
        } catch (Exception e) {
            //TODO: handle exception
            
        }finally{
            

        }
    }
    
}
