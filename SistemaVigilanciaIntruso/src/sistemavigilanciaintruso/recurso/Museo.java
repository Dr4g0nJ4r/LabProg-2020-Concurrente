/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;

/**
 *
 * @author Me
 */
public class Museo {
    int cantidad;
    private Sala[] salas;
    private boolean esCerrado;                                           //cuando el museo está cerrado, pueden entrar el vigilante y el intruso
    private String[] nombresSalas;
    private boolean detectado = false;
    
    public Museo(String[] nombres){
        this.cantidad=nombres.length;
        this.nombresSalas=nombres;
        this.salas = new Sala[cantidad];
        this.esCerrado = false;
        int i;
        for(i=0;i<salas.length;i++){
            salas[i]= new Sala();
        }
    }
    
  
    public Sala[] getSalas() {
        return salas;
    }
    
    public void intrusoDetectado(){
        System.out.println("SE DISPARÓ LA ALARMA SILECIOSA...");
        this.detectado=true;
    }
    
    public boolean esIntrusoDetectado(){
        return this.detectado;
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
            if(n>=0 && n<=this.cantidad){
                exito=true;
                salas[n].entrar();
            }
        return exito;
    }
    
    public boolean salirSala(int n){
        //metodo para salir de una sala
        
        boolean exito = false;
            if(n>=0 && n<=this.cantidad){
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
        return this.nombresSalas[n];
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
    
    public void robar(int nro){
        this.salas[nro].setValor(0);
    }
}
