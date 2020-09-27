/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;


import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Me
 */
public class ControlTiempo extends Thread{

    private int hora;
    private Museo museo;
    private boolean estado;
    public ControlTiempo(Museo museo)
    {
        this.hora = 16;
        this.museo = museo;
        estado = true;
    }
    public int getHora(){
        return this.hora;
    }
    
    public void aumentarHora(){
        this.hora = (this.hora + 1) % 24;
    }
    
    public void run(){
        //Espera a que se hagan las 19 para setear el estado. Mientras tanto, suma horas.
        while(this.estado)
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlTiempo.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.aumentarHora();
                if(this.hora >= 19 || this.hora < 9)
                {
                    this.estado = false;
                }
            }
        }
        // Ciclo mientras el reloj cierra el Museo y habilita la incursión dentro del Museo
        while (!this.estado) {
            this.museo.cerrar();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlTiempo.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                this.aumentarHora();
                if(this.hora < 19 && this.hora >= 9)
                {
                    this.museo.abrir();
                }
            }
        }
    }
}
