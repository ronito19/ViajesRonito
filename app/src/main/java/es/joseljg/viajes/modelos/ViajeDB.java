package es.joseljg.viajes.modelos;

import android.graphics.Bitmap;
import android.util.Log;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.joseljg.viajes.clases.Viaje;
import es.joseljg.viajes.utilidades.ImagenesBlobBitmap;

public class ViajeDB {

    public static boolean insertarViaje(Viaje v) {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "INSERT INTO viajes (`origen`, `destino`, `precio`, `foto`) VALUES (?,?,?,?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, v.getOrigen());
            sentencia.setString(2, v.getDestino());
            sentencia.setDouble(3,v.getPrecio());
            if(v.getFoto() != null)
            {
                byte[] bl1 = ImagenesBlobBitmap.bitmap_to_bytes(v.getFoto());
                sentencia.setBytes(4,bl1);
            }
            else{
               sentencia.setBytes(4, null);
            }

            int filasafectadas = sentencia.executeUpdate();
            if(filasafectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static ArrayList<Viaje> obtenerViajes() {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Viaje> viajes = new ArrayList<Viaje>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * FROM viajes ORDER BY idviaje";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                int idviaje = resultado.getInt("idviaje");
                String origen = resultado.getString("origen");
                String destino = resultado.getString("destino");
                double precio = resultado.getDouble("precio");
                Blob foto = resultado.getBlob("foto");
                Bitmap bm_foto;
                Viaje v ;
                if(foto != null){
                    bm_foto = ImagenesBlobBitmap.blob_to_bitmap(foto, ConfiguracionDB.ANCHO_IMAGENES_BITMAP, ConfiguracionDB.ALTO_IMAGENES_BITMAP);
                    v = new Viaje(idviaje, origen, destino, precio, bm_foto);
                }
                else{
                    v = new Viaje(idviaje, origen, destino, precio, null);
                }
                viajes.add(v);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return viajes;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return viajes;
        }
    }
}
