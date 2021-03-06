/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.hilos.intruso;

import java.util.ArrayList;
import java.util.List;
import sistemavigilanciaintruso.hilos.intruso.estados.*;
import sistemavigilanciaintruso.recurso.Museo;
import sistemavigilanciaintruso.hilos.Persona;

/**
 *
 * @author Me
 */
public class Intruso extends Persona{
    private EstadoIntruso estado;
    private Museo museo;
    private int nroSalaActual;
    private StringBuilder informe;
    private List<Integer> salasRecorridas;
    private boolean atrapado;
    
    
    public Intruso(Museo m){
        this.estado = new Recorrer();
        this.museo = m;
        this.salasRecorridas = new ArrayList<Integer>();
        this.nroSalaActual = (int) (Math.random() * museo.getCantidad() - 1) + 1;  //Valor aleatorio. Rango del 1 a la cantidad de salas menos uno (index 0 es la sala de vigilancia)
        informe = new StringBuilder();
        this.actualizarInforme("Informe del Intruso \n");
        atrapado = false;
    }
    
    @Override
    public String call() throws InterruptedException{ 
        while(!this.museo.EsCerrado()){
            Thread.sleep(3000);
        }
        this.actualizarInforme("Ingresé al Museo. La ventana del pasillo estaba abierta...");
        while(!atrapado && this.esCerradoMuseo())
        {
            this.actualizarInforme("Estoy en " + museo.obtenerNombreSala(nroSalaActual));
            this.estado.accion(this);
            if(museo.esIntrusoDetectado())
            {
                this.estado = new Atrapado();
            }
        }
        return informe.toString();
    }
 
    public void atrapado()
    {
        this.atrapado = true;
    }
    
    public boolean entrarEnSalaMuseo(int nro){
        return this.museo.entrarASala(nro);
    }
    
    public boolean salirDeSalaMuseo(int nro){
        return this.museo.salirSala(nro);
    }
    
    public void actualizarInforme(String dato){
        this.informe.append("Intruso ("+this.estado.getNombreEstado()+ ") Hora : " + Integer.toString(this.museo.getHora()) + " ---> "+dato+"\n");
    }
    
    public Museo getMuseo(){
        
        return this.museo;
    }
    
    public void setEstado(EstadoIntruso e){
        this.estado=e;
    }
    
    public String obtenerNombreSalaMuseo(int nro){
        return this.museo.obtenerNombreSala(nro);
    }
    
    public boolean alguienSalaMuseo(int nro){
        return this.museo.hayAlguienEnSala(nro);
    }
    
    public boolean esRobadoSalaMuseo(int nro){
        return this.museo.esRobadoSala(nro);
    }
    
     public int getCantSalasRecorridas(){
        return this.salasRecorridas.size();
    }
    
    
    public boolean museoSaqueado(){
        boolean res;
        if(this.getCantSalasRecorridas() == museo.getCantidad())
        {
            res = true;
        }
        else
        {
            res = false;
        }
        return res;
    }
    
    public int elegirSala(){
        int numSala;
        if(salasRecorridas != null)
        {
            do{
                numSala = (int) (Math.random() * museo.getCantidad() - 1) + 1;
            } while(salasRecorridas.contains(numSala));
        }
        else
        {
            numSala = (int) (Math.random() * museo.getCantidad() - 1) + 1;
        }
        
        return numSala;
    }
    
    public void setNroSalaActual(int n){
        this.nroSalaActual=n;
        this.salasRecorridas.add(n);
    }
    public int getNroSalaActual(){
        return nroSalaActual;
    }
    public boolean esCerradoMuseo(){
        return this.museo.EsCerrado();
    }
    
    public void robarMuseo(int nro){
        this.museo.robar(nro);
    }
}
