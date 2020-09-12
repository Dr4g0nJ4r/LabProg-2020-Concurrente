/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import sistemavigilanciaintruso.recurso.Sala;

/**
 *
 * @author Me
 */
public class Museo {
    int cantidad =1;
    private Sala[] salas;
    private boolean esCerrado = true;
    private String[] nombreSala;
    
    public Museo(int cant){
        this.nombreSala = new String[]{"Vigilancia","Arte moderno","Arte clasico","Arte abstracto","Arte de vanguardia","Arte prehispanico","Arte plastico","Arte callejero","Arte contemporaneo","Arte bizantino","Arte surrealista","Artes visuales"};
        this.cantidad=cant;
        this.salas = new Sala[cantidad];
        int i;
        for(i=0;i<salas.length;i++){
            salas[i].setNombre(nombreSala[i]);
        }
    }
    public Sala[] getSalas() {
        return salas;
    }
    
    

    public void setSalas(Sala[] salas) {
        this.salas = salas;
    }

    public boolean EsCerrado() {
        return esCerrado;
    }
    
    public boolean entrarASala(int n){
        //metodo para ir a la sala numero "n"
        //retorna true si fue posible entrar a la sala
        
        boolean exito = false;
        
            if(n>0 && n<=this.cantidad){
                exito=true;
                salas[n].entrar();
            }
        return exito;
    }
    
    public boolean salirSala(int n){
        //metodo para salir de una sala
        
        boolean exito = false;
            if(n>0 && n<=this.cantidad){
                exito=true;
                salas[n].salir();
            }
        
        return exito;
    }
    //Método para indicar si hay una persona en una sala especifica.
    
    public boolean hayAlguienEnSala(int n){
        boolean exito = false;
            if(this.salas[n].getCantidadPersonas()!=0){
                exito = true;
            }
        
        return exito;
    }
    
    public String obtenerNombreSala(int n){
        return this.salas[n].getNombre();
    }
    
    public int obtenerValorSala(int n){
        return this.salas[n].getValor();
    }
    
    public void abrir(){
        this.esCerrado=false;
    }
    
    public void cerrar(){
        this.esCerrado=true;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
}
