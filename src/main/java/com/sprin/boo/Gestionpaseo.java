package com.sprin.boo;

import java.sql.*;
import java.util.ArrayList;

public class Gestionpaseo {
    private ArrayList<paseo> datos=new ArrayList<>();
    Conexion con = new Conexion();
    Connection conec = null;
    Statement st = null;
    ResultSet res = null;
    PreparedStatement ps = null;

    public ArrayList<paseo> consultaP(){

        try{
            conec=con.conecta();
            String sql= "select * from paseo";
            st=conec.createStatement();
            res=st.executeQuery(sql);

            while (res.next()){
                paseo pas =new paseo(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
                datos.add(pas);
            }
            conec.close();
        }catch (SQLException ex){
            System.out.println("Error al consultar: "+ex);
        }
        return datos;
    }
    public void imprimir() {
        for (paseo p : datos) {
            System.out.println(p.toString());
        }
    }
    public paseo buscarpaseo(int Id_Paseo){
        paseo pas=null;
        try{
            conec=con.conecta();
            String sql="select * from paseo where Id_Paseo=?";
            ps=conec.prepareStatement(sql);
            ps.setInt(1,Id_Paseo);
            res=ps.executeQuery();

            while(res.next()){
                pas =new paseo(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
            }
            conec.close();
        }catch (SQLException ex){
            System.out.println("Error al consultar. "+ex);
        }
        return pas;
    }

    public boolean eliminarPaseo(int Id_Paseo){
        boolean respuesta = false;
        try{
            conec=con.conecta();
            String sql="DELETE from paseo where Id_Paseo=?";
            ps=conec.prepareStatement(sql);
            ps.setInt(1, Id_Paseo);
            respuesta=ps.executeUpdate()>0;
            System.out.println("Paseo eliminado exitosamente");

            conec.close();

        }catch (SQLException ex){
            System.out.println("Error al eliminar el Paseo: "+ex);
        }
        return respuesta;
    }

    public paseo buscarpaseomasc(String mascota) {
        paseo pas = null;
        try {
            conec = con.conecta();
            String sql = "select * from paseo where mascota=?;";
            ps = conec.prepareStatement(sql);
            ps.setString(1, mascota);
            res = ps.executeQuery();

            while (res.next()) {
                pas = new paseo(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
            }
            conec.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar. " + ex);
        }
        return pas;
    }
}
