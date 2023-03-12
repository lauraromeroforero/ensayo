package com.sprin.boo.Entidad;

public class dueno {
    private static String Nro_ID;
    private String Nombres;
    private String Apellido;
    private String Dirección;
    private String Telefono;

    public dueno(String num, String nom, String ape, String dir, String tel){
        Nro_ID= num;
        Nombres= nom;
        Apellido= ape;
        Dirección = dir;
        Telefono = tel;
    }

    public dueno(){

    }

    public dueno(String nom, String ape, String dir, String tel) {
        Nombres= nom;
        Apellido= ape;
        Dirección = dir;
        Telefono = tel;
    }

    public dueno(String tel) {
        Telefono = tel;
    }

    public static String getNro_ID() {
        return Nro_ID;
    }

    public void setNro_ID(String nro_ID) {
        Nro_ID = nro_ID;
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

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String dirección) {
        Dirección = dirección;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    @Override
    public String toString() {
        return "\n"+"DUEÑOS:" + "\n" +
                "Nro_ID= " + Nro_ID + '\n' +
                "Nombres= " + Nombres + '\n' +
                "Apellido= " + Apellido + '\n' +
                "Dirección= " + Dirección + '\n' +
                "Telefono= " + Telefono ;
    }
}
