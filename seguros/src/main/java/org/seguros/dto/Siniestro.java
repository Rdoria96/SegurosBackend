package org.seguros.dto;

import java.util.Date;

public class Siniestro {
    private int nmid;
    private String tipo_siniestro;
    private Date f_siniestro;
    private String lugar;
    private Tomador tomador;

    public Tomador getTomador() {
        return tomador;
    }

    public void setTomador(Tomador tomador) {
        this.tomador = tomador;
    }

    public int getNmid() {
        return nmid;
    }

    public void setNmid(int nmid) {
        this.nmid = nmid;
    }

    public String getTipo_siniestro() {
        return tipo_siniestro;
    }

    public void setTipo_siniestro(String tipo_siniestro) {
        this.tipo_siniestro = tipo_siniestro;
    }

    public Date getF_siniestro() {
        return f_siniestro;
    }

    public void setF_siniestro(Date f_siniestro) {
        this.f_siniestro = f_siniestro;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }


}
