package es.joseljg.viajes;

import static es.joseljg.viajes.clases.ViajeViewHolder.EXTRA_OBJETO_IMG_VIAJE;
import static es.joseljg.viajes.clases.ViajeViewHolder.EXTRA_OBJETO_VIAJE;
import static es.joseljg.viajes.utilidades.ImagenesBlobBitmap.bytes_to_bitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.joseljg.viajes.clases.Viaje;

public class MostrarDetallesViajeActivity extends AppCompatActivity {

    TextView txt_detalles_idviaje;
    TextView txt_detalles_origen;
    TextView txt_detalles_destino;
    TextView txt_detalles_precio;
    ImageView img_detalles_foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_viaje);
        txt_detalles_idviaje = (TextView) findViewById(R.id.txt_detalles_idviaje);
        txt_detalles_origen = (TextView) findViewById(R.id.txt_detalles_origen);
        txt_detalles_destino = (TextView) findViewById(R.id.txt_detalles_destino);
        txt_detalles_precio = (TextView) findViewById(R.id.txt_detalles_precio);
        img_detalles_foto = (ImageView) findViewById(R.id.img_detalles_foto);
        Intent intent = getIntent();
        if(intent !=null)
        {
            Viaje v = (Viaje)intent.getSerializableExtra(EXTRA_OBJETO_VIAJE);
            txt_detalles_idviaje.setText(String.valueOf(v.getIdviaje()));
            txt_detalles_origen.setText(v.getOrigen());
            txt_detalles_destino.setText(v.getDestino());
            txt_detalles_precio.setText(String.valueOf(v.getPrecio()));
            byte[] fotob = intent.getByteArrayExtra(EXTRA_OBJETO_IMG_VIAJE);
            if(fotob != null)
            {
                Bitmap fotov = bytes_to_bitmap(fotob);
                img_detalles_foto.setImageBitmap(fotov);
            }
            else{
                // img_detalles_foto.setImageDrawable(getResources().getDrawable(R.drawable.foto_viaje2));
               // img_detalles_foto.setImageResource(R.drawable.foto_viaje);
               // img_detalles_foto.setBackgroundResource(R.drawable.foto_viaje);
            }
        }
    }
}