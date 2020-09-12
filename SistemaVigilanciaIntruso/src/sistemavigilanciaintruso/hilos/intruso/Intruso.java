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
    private int nroSalaActual;
    private StringBuilder informe;
    private int[] salasRecorridas;
    
    
    public Intruso(Museo m){
        this.estado = new Recorrer();
        this.museo = m;
        int nroSalaActual = (int) (Math.random() * museo.getCantidad() - 1) + 1;  //Rango del 1 a la cantidad de salas menos uno (index 0 es la sala de vigilancia)
    }
    
    @Override
    public StringBuilder call(){                                                  //variable que sirve para armar un informe sobre las actividades del intruso.
        boolean termina = false;   
        informe.append("Informe del Intruso");                                     //variable que me pemite controlar si el intruso termina sus actividades.
        while(!termina)
        {
            System.out.println("Intruso: Estoy en ");
        }
        return informe;
    }

    @Override
    public boolean accion(Intruso persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTiempo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombreEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
    public boolean entrarEnSalaMuseo(int nro){
        return this.museo.entrarASala(nro);
    }
    
    public boolean salirDeSalaMuseo(int nro){
        return this.museo.salirSala(nro);
    }
    
    public void actualizarInforme(String dato){
        this.informe.append(dato+"\n");
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
    
    public int obtenerValorSalaMuseo(int nro){
        return this.museo.obtenerValorSala(nro);
    }
    
     public int getCantSalasRecorridas(){
        return 1;
    }
    
    public void setCantidadSalasRecorridas(int cant){
        
    }
    public void setNroSalaActual(int n){
        this.nroSalaActual=n;
    }
    public int getNroSalaActual(){
        return nroSalaActual;
    }
    public boolean esCerradoMuseo(){
        return this.museo.EsCerrado();
    }
}
