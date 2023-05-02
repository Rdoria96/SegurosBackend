package org.seguros.dto;

import java.util.Date;

public class Pagos  {
    private int nmid;
    private Date f_pago;
    private int cuotas;
    private double valor_cmes;
    private Seguro seguro;

    public int getNmid() {
        return nmid;
    }

    public void setNmid(int nmid) {
        this.nmid = nmid;
    }

    public Date getF_pago() {
        return f_pago;
    }

    public void setF_pago(Date f_pago) {
        this.f_pago = f_pago;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public double getValor_cmes() {
        return valor_cmes;
    }

    public void setValor_cmes(double valor_cmes) {
        this.valor_cmes = valor_cmes;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
