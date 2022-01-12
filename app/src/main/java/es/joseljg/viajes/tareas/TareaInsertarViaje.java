package es.joseljg.viajes.tareas;

import java.util.concurrent.Callable;

import es.joseljg.viajes.clases.Viaje;
import es.joseljg.viajes.modelos.ViajeDB;


public class TareaInsertarViaje implements Callable<Boolean> {
    private Viaje v;

    public TareaInsertarViaje(Viaje v) {
        this.v = v;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insercionOK = ViajeDB.insertarViaje(this.v);
        return insercionOK;
    }
}
