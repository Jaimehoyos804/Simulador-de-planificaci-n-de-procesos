package com.mycompany.process_simulator;

/**
 *
 * @author Jaime
 */
public class Process_Simulator {

    public static void main(String[] args) {
        System.out.println("----- ROUND ROBIN -----");
        Planificador planificadorRR = new Planificador();

        planificadorRR.agregarProceso(new Proceso("Alerta Accidente", 6, 1, 100));
        planificadorRR.agregarProceso(new Proceso("ReporteTrafico", 3, 2, 50));
        planificadorRR.agregarProceso(new Proceso("SincronizacionDatos", 4, 3, 70));

        planificadorRR.ejecutar();

        System.out.println("\n----- SJF -----");
        PlanificadorSJF planificadorSJF = new PlanificadorSJF();

        planificadorSJF.agregarProceso(new Proceso("Alerta Accidente", 5, 1, 100));
        planificadorSJF.agregarProceso(new Proceso("ReporteTrafico", 3, 2, 50));
        planificadorSJF.agregarProceso(new Proceso("SincronizacionDatos", 4, 3, 70));

        planificadorSJF.ejecutar();
    }

}
