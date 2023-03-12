package com.sprin.boo.Entidad;

public class paseo {
    private int Id_Paseo;
    private String mascota;
    private String paseador;
    private String Fecha_Paseo;

    public paseo(int num, String masc, String paser, String fecha){
        Id_Paseo= num;
        mascota= masc;
        paseador= paser;
        Fecha_Paseo = fecha;
    }

    public paseo(){

    }

    public int getId_Paseo() {
        return Id_Paseo;
    }

    public void setId_Paseo(int id_Paseo) {
        Id_Paseo = id_Paseo;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getPaseador() {
        return paseador;
    }

    public void setPaseador(String paseador) {
        this.paseador = paseador;
    }

    public String getFecha_Paseo() {
        return Fecha_Paseo;
    }

    public void setFecha_Paseo(String fecha_Paseo) {
        Fecha_Paseo = fecha_Paseo;
    }

    @Override
    public String toString() {
        return "PASEO:" + '\n' +
                "Id_Paseo= " + Id_Paseo + '\n' +
                "mascota= " + mascota + '\n' +
                "paseador= " + paseador + '\n' +
                "Fecha_Paseo= " + Fecha_Paseo + '\n';
    }
}
