package es.joseljg.viajes.controladores;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.viajes.clases.Viaje;
import es.joseljg.viajes.tareas.TareaInsertarViaje;
import es.joseljg.viajes.tareas.TareaObtenerViajes;

public class ViajeController {


    public static boolean insertarViaje(Viaje v) {
        FutureTask t = new FutureTask(new TareaInsertarViaje(v));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }

    public static ArrayList<Viaje> obtenerviajes() {
        ArrayList<Viaje> viajes = null;
        FutureTask t = new FutureTask (new TareaObtenerViajes());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            viajes= (ArrayList<Viaje>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return viajes;
    }
}
