/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso;

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
        try {
            ExecutorService servicio = Executors.newFixedThreadPool(2);         //creo un pool con dos hilos.
            Future informeVigilante = servicio.submit(new Vigilante());         //creo una variable future que va a almacenar el informe del vigilante
            Future informeIntruso = servicio.submit(new Intruso());             //creo una variable future que va a almacenar el informe del Intruso
            
            System.out.println("Informes:");
            System.out.println(informeVigilante.get());


            System.out.println("El informe del intruso esta listo");
            System.out.println(informeIntruso.get());
            
           servicio.shutdown();//cuando los hilos se detengan cierro el servicio.
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}