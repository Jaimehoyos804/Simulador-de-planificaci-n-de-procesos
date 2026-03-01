package com.mycompany.process_simulator;

/**
 *
 * @author Jaime
 */
public class Proceso {

    String nombre;
    int tiempoIrrupcion;
    int prioridadAlerta;
    int tamanoDatos;
    int tiempoRestante;
    Estado estado;

    public enum Estado {
        NUEVO,
        LISTO,
        EN_EJECUCION,
        BLOQUEADO,
        TERMINADO
    }

    public Proceso(String nombre, int tiempoIrrupcion, int prioridadAlerta, int tamanoDatos) {
        this.nombre = nombre;
        this.tiempoIrrupcion = tiempoIrrupcion;
        this.prioridadAlerta = prioridadAlerta;
        this.tamanoDatos = tamanoDatos;
        this.tiempoRestante = tiempoIrrupcion;
        this.estado = Estado.NUEVO;
    }
}
