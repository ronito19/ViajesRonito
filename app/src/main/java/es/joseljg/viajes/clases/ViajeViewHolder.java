package es.joseljg.viajes.clases;

import static es.joseljg.viajes.utilidades.ImagenesBlobBitmap.bitmap_to_bytes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.joseljg.viajes.MostrarDetallesViajeActivity;
import es.joseljg.viajes.R;

public class ViajeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public static final String EXTRA_OBJETO_VIAJE =  "es.joseljg.viajeViewHolder.objeto_viaje";
    public static final String EXTRA_OBJETO_IMG_VIAJE =  "es.joseljg.viajeViewHolder.img_viaje";
    public TextView txt_rv_viaje_idviaje = null;
    public TextView txt_rv_viaje_origen = null;
    public TextView txt_rv_viaje_destino = null;
    public ImageView img_rv_viaje_foto = null;
    ListaViajesAdapter lcAdapter;

    public ViajeViewHolder(@NonNull View itemView, ListaViajesAdapter lcAdapter) {
        super(itemView);
        txt_rv_viaje_idviaje = (TextView)  itemView.findViewById(R.id.txt_rv_viaje_idviaje);
        txt_rv_viaje_origen = (TextView)  itemView.findViewById(R.id.txt_rv_viaje_origen);
        txt_rv_viaje_destino = (TextView)  itemView.findViewById(R.id.txt_rv_viaje_destino);
        img_rv_viaje_foto = (ImageView) itemView.findViewById(R.id.img_rv_viaje_viaje);

        this.lcAdapter = lcAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mPosition = getAdapterPosition();
        // int mPosition = getLayoutPosition();
        ArrayList<Viaje> cursos = this.lcAdapter.getListaViajes();
        Viaje viaje = cursos.get(mPosition);
        Intent intent = new Intent(lcAdapter.getC(), MostrarDetallesViajeActivity.class);
        Bitmap fotov = viaje.getFoto();
        Viaje viaje1 = new Viaje(viaje.getIdviaje(), viaje.getOrigen(), viaje.getDestino(), viaje.getPrecio(), null);
        if(fotov != null) {
            byte[] fotob = bitmap_to_bytes(fotov);
            intent.putExtra(EXTRA_OBJETO_IMG_VIAJE, fotob);
        }
        // lcAdapter.notifyDataSetChanged();
        intent.putExtra(EXTRA_OBJETO_VIAJE, viaje1);
        lcAdapter.getC().startActivity(intent);
    }
}
