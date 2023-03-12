package com.sprin.boo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String bd="mascotas";
    private String url="jdbc:mysql://localhost:3306/"+bd;
    private String user="root";
    private String pass="";
    Connection conec=null;

    public Connection conecta(){
        try{
            conec= DriverManager.getConnection(url, user, pass);
            System.out.println(" ");
        }catch (SQLException e){
            System.out.println("Error en la conexion:  "+e);
        }
        return conec;
    }
}
