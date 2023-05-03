package org.seguros.dto;

import java.util.Date;

public class Seguro {
    private  int nmid;
    private String tipo_seguro;
    private double valor;
    private String descripcion;
    private Date f_inicial;
    private Date f_final;

    private Tomador  tomador;

    public Tomador getTomador() {
        return tomador;
    }

    public void settomador(Tomador tomador) {
        this.tomador = tomador;
    }

    public Reaseguradora getReaseguradora() {
        return reaseguradora;
    }

    public void setreaseguradora(Reaseguradora reaseguradora) {
        this.reaseguradora = reaseguradora;
    }

    private Reaseguradora reaseguradora;

    public int getNmid() {
        return nmid;
    }

    public void setNmid(int nmid) {
        this.nmid = nmid;
    }

    public String getTipo_seguro() {
        return tipo_seguro;
    }

    public void setTipo_seguro(String tipo_seguro) {
        this.tipo_seguro = tipo_seguro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getF_inicial() {
        return f_inicial;
    }

    public void setF_inicial(Date f_inicial) {
        this.f_inicial = f_inicial;
    }

    public Date getF_final() {
        return f_final;
    }

    public void setF_final(Date f_final) {
        this.f_final = f_final;
    }


}
