package com.mycompany.process_simulator;
import java.util.*;

public class Planificador {

    private Queue<Proceso> colaAlta = new LinkedList<>();
    private Queue<Proceso> colaMedia = new LinkedList<>();
    private Queue<Proceso> colaBaja = new LinkedList<>();

    private int quantum = 2;

    public void agregarProceso(Proceso p) {
        p.estado = Proceso.Estado.NUEVO;
        System.out.println(p.nombre + "  NUEVO");
        
        p.estado = Proceso.Estado.LISTO;
        System.out.println(p.nombre + "  LISTO");

        if (p.prioridadAlerta == 1) {
            colaAlta.add(p);
        } else if (p.prioridadAlerta == 2) {
            colaMedia.add(p);
        } else {
            colaBaja.add(p);
        }
    }

    public void ejecutar() {
        while (!colaAlta.isEmpty() || !colaMedia.isEmpty() || !colaBaja.isEmpty()) {

            Proceso actual = obtenerSiguienteProceso();

            if (actual != null) {
                actual.estado = Proceso.Estado.EN_EJECUCION;
                System.out.println(actual.nombre + " EN_EJECUCION");

                int tiempoEjecucion = Math.min(quantum, actual.tiempoRestante);
                actual.tiempoRestante -= tiempoEjecucion;

                System.out.println("Ejecutando: " + actual.nombre +
                        " | Tiempo restante: " + actual.tiempoRestante);

                if (actual.tiempoRestante > 0) {
                    actual.estado = Proceso.Estado.LISTO;
                    System.out.println(actual.nombre + "  LISTO");
                    reinsertar(actual);
                } else {
                    actual.estado = Proceso.Estado.TERMINADO;
                    System.out.println(actual.nombre + "  TERMINADO");
                }
            }
        }
    }

    private Proceso obtenerSiguienteProceso() {
        if (!colaAlta.isEmpty()) return colaAlta.poll();
        if (!colaMedia.isEmpty()) return colaMedia.poll();
        if (!colaBaja.isEmpty()) return colaBaja.poll();
        return null;
    }

    private void reinsertar(Proceso p) {
        if (p.prioridadAlerta == 1) colaAlta.add(p);
        else if (p.prioridadAlerta == 2) colaMedia.add(p);
        else colaBaja.add(p);
    }
}