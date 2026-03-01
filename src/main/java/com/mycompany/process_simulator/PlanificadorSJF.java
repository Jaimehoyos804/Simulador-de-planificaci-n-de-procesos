package com.mycompany.process_simulator;
import java.util.*;
/**
 *
 * @author Jaime
 */
public class PlanificadorSJF {
     private List<Proceso> listaProcesos = new ArrayList<>();
     
      public void agregarProceso(Proceso p) {
        p.estado = Proceso.Estado.LISTO;
        listaProcesos.add(p);
    }
      
       public void ejecutar() {

        // Ordenar por menor tiempo de ejecución
        listaProcesos.sort(Comparator.comparingInt(p -> p.tiempoRestante));

        for (Proceso p : listaProcesos) {

            p.estado = Proceso.Estado.EN_EJECUCION;
            System.out.println("Ejecutando: " + p.nombre +
                    " | Tiempo: " + p.tiempoRestante);

            p.tiempoRestante = 0;
            p.estado = Proceso.Estado.TERMINADO;

            System.out.println("Proceso terminado: " + p.nombre);
        }
    }

}
