package org.seguros.dto;

public class Reaseguradora {
    private int nmid;
    private String  nit;
    private String razon_social;
    private double monto_seguro;
    private double porcentaje_cober;

    public int getNmid() {
        return nmid;
    }

    public void setNmid(int nmid) {
        this.nmid = nmid;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public double getMonto_seguro() {
        return monto_seguro;
    }

    public void setMonto_seguro(double monto_seguro) {
        this.monto_seguro = monto_seguro;
    }

    public double getPorcentaje_cober() {
        return porcentaje_cober;
    }

    public void setPorcentaje_cober(double porcentaje_cober) {
        this.porcentaje_cober = porcentaje_cober;
    }
}
