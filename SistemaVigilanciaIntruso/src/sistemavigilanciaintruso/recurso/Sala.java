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
public class Sala {

    private int cantPersonas = 0;
    private String nombre;
    private int valor;

    public void entrar() {
        this.cantPersonas++;
    }

    public void salir() {
        this.cantPersonas--;
    }

    public int getCantidadPersonas() {
        return this.cantPersonas;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setValor(int v) {
        this.valor = v;
    }

    public int getValor() {
        return this.valor;
    }

}
