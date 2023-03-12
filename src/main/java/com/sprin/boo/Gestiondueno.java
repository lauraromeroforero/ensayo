package com.sprin.boo;

import java.util.ArrayList;
import java.sql.*;
public class Gestiondueno {
    private ArrayList<dueno> datos=new ArrayList<>();
    Conexion con = new Conexion();
    Connection conec = null;
    Statement st = null;
    ResultSet res = null;

    PreparedStatement ps = null;

    public ArrayList<dueno> consultaD(){

        try{
            conec=con.conecta();
            String sql= "select * from dueno";
            st=conec.createStatement();
            res=st.executeQuery(sql);

            while (res.next()){
                dueno due=new dueno(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
                datos.add(due);
            }

        }catch (SQLException ex){
            System.out.println("Error al consultar: "+ex);
        }
        return datos;
    }
    public void imprimir() {
        for (dueno d : datos) {
            System.out.println(d.toString());
        }
    }

    public dueno buscarD(String Nro_ID){
        dueno due=null;
        try{
            conec=con.conecta();
            String sql="select * from dueno where Nro_ID=?";
            ps=conec.prepareStatement(sql);
            ps.setString(1,Nro_ID);
            res=ps.executeQuery();

            while(res.next()){
                due=new dueno(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
            }
        }catch (SQLException ex){
            System.out.println("Error al consultar. "+ ex);
        }
        return due;
    }

    public boolean insertarDueno(dueno duenos){
        boolean respuesta = false;
        try{
            if(buscarD(duenos.getNro_ID())==null){
                conec=con.conecta();
                String sql="insert into dueno values (?,?,?,?,?)";
                ps=conec.prepareStatement(sql);
                ps.setString(1, duenos.getNro_ID());
                ps.setString(2, duenos.getNombres());
                ps.setString(3, duenos.getApellido());
                ps.setString(4, duenos.getDirección());
                ps.setString(5, duenos.getTelefono());
                respuesta=ps.executeUpdate()>0;
                conec.close();
                System.out.println("Dueño insertado exitosamente");
                System.out.println("");
            }

            else{
                System.out.println("El Dueño ya existe en la base de datos");
            }

        }catch (SQLException ex){
            System.out.println("Error al insertar el Dueño: "+ex);
        }
        return respuesta;
    }

    public boolean eliminarDueno(String Nro_ID){
        boolean respuesta = false;
        try{
            conec=con.conecta();
            String sql="DELETE from dueno where Nro_ID=?";
            ps=conec.prepareStatement(sql);
            ps.setString(1, Nro_ID);
            respuesta=ps.executeUpdate()>0;
            System.out.println("Dueño eliminado exitosamente");

            conec.close();

        }catch (SQLException ex){
            System.out.println("Error al eliminar el Dueño: "+ex);
        }
        return respuesta;
    }

    public boolean modificarduenodemasc(dueno duenos){
        boolean respuesta = false;
        try{
            if(buscarD(duenos.getNro_ID())==null){
                System.out.println("El dueño no se puede actualizar en la base de datos");
            }
            else{
                conec=con.conecta();
                String sql="Update dueno Set Nombres=?, Apellido=?, Direccion=?, Telefono=? where Nro_ID=?";
                ps=conec.prepareStatement(sql);
                ps.setString(1,duenos.getNombres());
                ps.setString(2,duenos.getApellido());
                ps.setString(3,duenos.getDirección());
                ps.setString(4,duenos.getTelefono());
                ps.setString(5,duenos.getNro_ID());
                respuesta=ps.executeUpdate()>0;
                conec.close();
                System.out.println("Dueño actualizado exitosamente");
            }

        }catch (SQLException ex){
            System.out.println("Error al actualizar el dueño: "+ex);
        }
        return respuesta;
    }

    public boolean modificarduenotel(dueno duenos){
        boolean respuesta = false;
        try{
            if(buscarD(duenos.getNro_ID())==null){
                System.out.println("El Telefono del dueño no se puede actualizar en la base de datos");
            }
            else{
                conec=con.conecta();
                String sql="Update dueno Set Telefono=? where Nro_ID=?";
                ps=conec.prepareStatement(sql);
                ps.setString(1,duenos.getTelefono());
                ps.setString(2,duenos.getNro_ID());
                respuesta=ps.executeUpdate()>0;
                conec.close();
                System.out.println("Telefono del Dueño actualizado exitosamente");
            }

        }catch (SQLException ex){
            System.out.println("Error al actualizar el Telefono del dueño: "+ex);
        }
        return respuesta;
    }
}
