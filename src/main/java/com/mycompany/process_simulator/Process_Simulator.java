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
        planificadorRR.agregarProceso(new Proceso("ReporteTrafico", 4, 3, 50));
        planificadorRR.agregarProceso(new Proceso("SincronizacionDatos", 2, 5, 70));
        
        planificadorRR.ejecutar();
        

        System.out.println("\n----- SJF -----");
        PlanificadorSJF planificadorSJF = new PlanificadorSJF();

        planificadorSJF.agregarProceso(new Proceso("Alerta Accidente", 1, 1, 100));
        planificadorSJF.agregarProceso(new Proceso("Reporte de Trafico", 2, 2, 50));
        planificadorSJF.agregarProceso(new Proceso("Sincronizacion de Datos", 10, 3, 70));

        planificadorSJF.ejecutar();
    }

    
}
