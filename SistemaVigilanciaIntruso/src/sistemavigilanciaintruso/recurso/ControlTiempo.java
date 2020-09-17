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
public class ControlTiempo implements Callable {

    private Museo museo;
    private String aviso = "Control de tiempo finalizado";

    @Override
    public String call() {
        while (!this.museo.esIntrusoDetectado()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlTiempo.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.museo.aumentarHora();
                if(this.museo.getHora()<8 && this.museo.getHora()>18 && !this.museo.EsCerrado()){
                    this.museo.cerrar();
                    System.out.println("CONTROL DE TIEMPO : El museo está cerrado");
                }else{
                    this.museo.abrir();
                    System.out.println("CONTROL DE TIEMPO : El museo está abierto");
                }
                System.out.println("CONTROL DE TIEMPO : La hora acutal es :"+ this.museo.getHora());
            }
        }

        return this.aviso;
    }

    public ControlTiempo(Museo museo) {
        this.museo = museo;
    }
}
