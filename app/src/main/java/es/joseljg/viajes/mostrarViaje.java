package es.joseljg.viajes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import es.joseljg.viajes.clases.ListaViajesAdapter;
import es.joseljg.viajes.clases.Viaje;
import es.joseljg.viajes.controladores.ViajeController;

public class mostrarViaje extends AppCompatActivity {

    private RecyclerView rv_viajes = null;
    private ListaViajesAdapter mAdapter;
    private ArrayList<Viaje> viajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_viaje);
        rv_viajes = findViewById(R.id.rv_viajes);

        mAdapter = new ListaViajesAdapter(this);
        viajes = ViajeController.obtenerviajes();
        if(viajes != null) {
            mAdapter.setListaViajes(viajes);
        }
        //------------------------------------------------------------
        rv_viajes.setAdapter(mAdapter);
        rv_viajes.setLayoutManager(new LinearLayoutManager(this));
        //------------------------------------------------------------

    }
}