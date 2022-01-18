package es.joseljg.viajes;

import static es.joseljg.viajes.modelos.ConfiguracionDB.NUMERO_DE_COLUMNAS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
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
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            rv_viajes.setLayoutManager(new LinearLayoutManager(this));
        } else
            {
                rv_viajes.setLayoutManager(new GridLayoutManager(this, NUMERO_DE_COLUMNAS));
            }
        //rv_viajes.setLayoutManager(new LinearLayoutManager(this));
        //------------------------------------------------------------

    }
}