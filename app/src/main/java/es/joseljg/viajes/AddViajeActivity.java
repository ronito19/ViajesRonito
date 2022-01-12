package es.joseljg.viajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.joseljg.viajes.clases.Viaje;
import es.joseljg.viajes.controladores.ViajeController;

public class AddViajeActivity extends AppCompatActivity {

    EditText edt_add_origen;
    EditText edt_add_destino;
    EditText edt_add_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_viaje);
        edt_add_origen = (EditText) findViewById(R.id.edt_add_origen);
        edt_add_destino = (EditText) findViewById(R.id.edt_add_destino);
        edt_add_precio = (EditText) findViewById(R.id.edt_add_precio);
    }

    public void insertar_viaje(View view) {
        String origen = String.valueOf(edt_add_origen.getText());
        String destino = String.valueOf(edt_add_destino.getText());
        double precio = Double.valueOf(String.valueOf(edt_add_precio.getText()));
        Viaje v = new Viaje(origen, destino, precio);
        boolean insertadoOK = ViajeController.insertarViaje(v);
        if(insertadoOK)
        {
            Toast.makeText(this,"viaje insertado correctamente", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"viaje no insertado correctamente", Toast.LENGTH_LONG).show();
        }
    }
}