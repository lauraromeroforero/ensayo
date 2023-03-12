package com.sprin.boo;

public class paseador {
    private String Nro_Paseador;
    private String Nombres;
    private String Apellido;
    private String Telefono;

    public paseador(String num, String nom, String ape, String tel){
        Nro_Paseador= num;
        Nombres= nom;
        Apellido= ape;
        Telefono = tel;
    }

    public paseador(){

    }

    public String getNro_Paseador() {
        return Nro_Paseador;
    }

    public void setNro_Paseador(String nro_Paseador) {
        Nro_Paseador = nro_Paseador;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    @Override
    public String toString() {
        return "PASEADOR:" + '\n' +
                "Nro_Paseador= " + Nro_Paseador + '\n' +
                "Nombres= " + Nombres + '\n' +
                "Apellido= " + Apellido + '\n' +
                "Telefono= " + Telefono + '\n';
    }
}
