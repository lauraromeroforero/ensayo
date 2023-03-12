package com.sprin.boo;

import java.sql.*;
import java.util.ArrayList;

public class Gestionmascota {
    private ArrayList<mascota> datos = new ArrayList<>();
    Conexion con = new Conexion();
    Connection conec = null;
    Statement st = null;
    ResultSet res = null;
    PreparedStatement ps = null;

    public ArrayList<mascota> consultaM() {

        try {
            conec = con.conecta();
            String sql = "select * from mascota";
            st = conec.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                mascota masc = new mascota(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                datos.add(masc);
            }
            conec.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar: " + ex);
        }
        return datos;
    }

    public void imprimir() {
        for (mascota m : datos) {
            System.out.println(m.toString());
        }
    }

    public mascota buscarmascota(String Nro_mascota) {
        mascota masc = null;
        try {
            conec = con.conecta();
            String sql = "select * from mascota where Nro_mascota=?";
            ps = conec.prepareStatement(sql);
            ps.setString(1, Nro_mascota);
            res = ps.executeQuery();

            while (res.next()) {
                masc = new mascota(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            }
            conec.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar. " + ex);
        }
        return masc;
    }

    public boolean insertarmascota(mascota mascotas) {
        boolean respuesta = false;
        try {
            if (buscarmascota(mascotas.getNro_mascota()) == null) {
                conec = con.conecta();
                String sql = "insert into mascota values(?,?,?,?,?)";
                ps = conec.prepareStatement(sql);
                ps.setString(1, mascotas.getNro_mascota());
                ps.setString(2, mascotas.getNombre_mascota());
                ps.setString(3, mascotas.getRaza_mascota());
                ps.setString(4, mascotas.getClase_Animal());
                ps.setString(5, mascotas.getId_cliente());
                respuesta = ps.executeUpdate() > 0;
                conec.close();
                System.out.println("Mascota insertada exitosamente");
            } else {
                System.out.println("La mascota ya existe en la base de datos");
            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar la mascota: " + ex);
        }
        return respuesta;
    }

    public mascota buscarraza(String Raza_mascota) {
        mascota masc = null;
        try {
            conec = con.conecta();
            String sql = "select * from mascota where Raza_mascota=?";
            ps = conec.prepareStatement(sql);
            ps.setString(1, Raza_mascota);
            res = ps.executeQuery();

            while (res.next()) {
                masc = new mascota(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            }
            conec.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar. " + ex);
        }
        return masc;
    }

    public mascota buscartipo(String Clase_Animal) {
        mascota masc = null;
        try {
            conec = con.conecta();
            String sql = "select * from mascota where Clase_Animal=?";
            ps = conec.prepareStatement(sql);
            ps.setString(1, Clase_Animal);
            res = ps.executeQuery();

            while (res.next()) {
                masc = new mascota(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            }
            conec.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar. " + ex);
        }
        return masc;
    }

    public boolean eliminarMascota(String Nro_mascota) {
        boolean respuesta = false;
        try {
            conec = con.conecta();
            String sql = "DELETE from mascota where Nro_mascota=?";
            ps = conec.prepareStatement(sql);
            ps.setString(1, Nro_mascota);
            respuesta = ps.executeUpdate() > 0;
            System.out.println("mascota eliminada exitosamente");

            conec.close();

        } catch (SQLException ex) {
            System.out.println("Error al eliminar la mascota: " + ex);
        }
        return respuesta;
    }
}