package sistemavigilanciaintruso.hilos.intruso.estados;

import sistemavigilanciaintruso.hilos.intruso.Intruso;

public class Robar implements EstadoIntruso{

    
    private String nombre = "Recorrer";
    private int tiempo = 10000;
    
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
    
}