package es.joseljg.viajes.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.joseljg.viajes.clases.Viaje;

public class ViajeDB {

    public static boolean insertarViaje(Viaje v) {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "INSERT INTO viajes (`origen`, `destino`, `precio`) VALUES (?,?,?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, v.getOrigen());
            sentencia.setString(2, v.getDestino());
            sentencia.setDouble(3,v.getPrecio());
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
}
