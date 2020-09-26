/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavigilanciaintruso.recurso;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Me
 */
public class Sala {

    private int cantPersonas = 0;
    private String nombre;
    private boolean esRobado=false;
    private Lock lock = new ReentrantLock();

    public void entrar() {
        lock.lock();
        try {
            this.cantPersonas++;
        } finally {
            lock.unlock();
        }
    }

    public void salir() {
        lock.lock();
        try {
            this.cantPersonas--;
        } finally {
            lock.unlock();
        }
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

    public void robar() {
        this.esRobado = true;
    }

    public boolean esRobado() {
        return this.esRobado;
    }

}
