package es.joseljg.viajes.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.joseljg.viajes.R;

public class ListaViajesAdapter extends RecyclerView.Adapter<ViajeViewHolder>{
    private Context c;
    private ArrayList<Viaje> listaViajes;
    private LayoutInflater mInflater;

    public void setC(Context c) {
        this.c = c;
        this.listaViajes = new ArrayList<Viaje>();
    }
    public ListaViajesAdapter(Context c, ArrayList<Viaje> listaViajes) {
        this.c = c;
        this.listaViajes = listaViajes;
        mInflater = LayoutInflater.from(c);
    }

    public Context getC() {
        return c;
    }



    public ArrayList<Viaje> getListaViajes() {
        return listaViajes;
    }

    public void setListaViajes(ArrayList<Viaje> listaViajes) {
        this.listaViajes = listaViajes;
        notifyDataSetChanged();
    }

    public ListaViajesAdapter(Context c) {
        this.c = c;
        mInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public ViajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_viaje, parent, false);
        return new ViajeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViajeViewHolder holder, int position) {
        if(listaViajes!=null) {
            Viaje viaje_actual = listaViajes.get(position);
            holder.txt_rv_viaje_idviaje.setText("IdViaje: " + viaje_actual.getIdviaje());
            holder.txt_rv_viaje_origen.setText(String.valueOf("origen: " + viaje_actual.getOrigen()));
            holder.txt_rv_viaje_destino.setText(String.valueOf("destino: " + viaje_actual.getDestino()));
            if (viaje_actual.getFoto() != null) {
                holder.img_rv_viaje_foto.setImageBitmap(viaje_actual.getFoto());
            }
            else{
               // holder.img_rv_viaje_foto.setImageResource(R.drawable.foto_viaje);
               // holder.img_rv_viaje_foto.setBackgroundResource(R.drawable.foto_viaje);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (listaViajes != null)
            return listaViajes.size();
        else return 0;
    }
}
