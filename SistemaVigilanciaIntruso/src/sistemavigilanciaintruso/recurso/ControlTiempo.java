/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Me
 */
public class ControlTiempo extends Thread {

    private Museo museo;
    private String aviso = "Control de tiempo finalizado";
    private int hora;

    public ControlTiempo(Museo museo)
    {
        this.museo = museo;
        this.hora = 16;
    }
      public int getHora(){
        return this.hora;
    }
    
    public void aumentarHora(){
        this.hora = (this.hora + 1) % 24;
    }
    
    public void run(){
        while (!this.museo.esIntrusoDetectado()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlTiempo.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.aumentarHora();
                if(this.getHora() < 8 || this.getHora() > 18){
                    this.museo.cerrar();
                    System.out.println("CONTROL DE TIEMPO : El museo está cerrado");
                }else{
                    this.museo.abrir();
                    System.out.println("CONTROL DE TIEMPO : El museo está abierto");
                }
                System.out.println("CONTROL DE TIEMPO : La hora actual es :"+ this.getHora());
            }
        }
    }
}
