package com.sprin.boo;

public class mascota {
    private String Nro_mascota;
    private String Nombre_mascota;
    private String Raza_mascota;
    private String Clase_Animal;
    private String Id_cliente;

    public mascota(String num, String nom, String raza, String clase, String id){
        Nro_mascota= num;
        Nombre_mascota= nom;
        Raza_mascota= raza;
        Clase_Animal = clase;
        Id_cliente = id;
    }

    public mascota(){

    }

    public String getNro_mascota() {
        return Nro_mascota;
    }

    public void setNro_mascota(String nro_mascota) {
        Nro_mascota = nro_mascota;
    }

    public String getNombre_mascota() {
        return Nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        Nombre_mascota = nombre_mascota;
    }

    public String getRaza_mascota() {
        return Raza_mascota;
    }

    public void setRaza_mascota(String raza_mascota) {
        Raza_mascota = raza_mascota;
    }

    public String getClase_Animal() {
        return Clase_Animal;
    }

    public void setClase_Animal(String clase_Animal) {
        Clase_Animal = clase_Animal;
    }

    public String getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        Id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "MASCOTA:" +'\n' +
                "Nro_mascota= " + Nro_mascota + '\n' +
                "Nombre_mascota= " + Nombre_mascota + '\n' +
                "Raza_mascota= " + Raza_mascota + '\n' +
                "Clase_Animal= " + Clase_Animal + '\n' +
                "Id_cliente= " + Id_cliente;
    }
}
