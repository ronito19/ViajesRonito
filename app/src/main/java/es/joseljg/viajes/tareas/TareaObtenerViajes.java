package es.joseljg.viajes.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.viajes.clases.Viaje;
import es.joseljg.viajes.modelos.ViajeDB;

public class TareaObtenerViajes implements Callable<ArrayList<Viaje>> {
    @Override
    public ArrayList<Viaje> call() throws Exception {
        ArrayList<Viaje> viajes= ViajeDB.obtenerViajes();
        return viajes;
    }

}
