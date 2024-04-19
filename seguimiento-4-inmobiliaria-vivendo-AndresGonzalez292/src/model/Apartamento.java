package model;

import model.TipoApartamento;


public class Apartamento {
    private String aptoIdent;
    private TipoApartamento tipo;
    private double valorMensual;

    public Apartamento(String aptoIdent) {
        this.aptoIdent = aptoIdent;
    }

    public String getAptoIdent() {
        return aptoIdent;
    }

    public void setAptoIdent(String aptoIdent) {
        this.aptoIdent = aptoIdent;
    }

    public TipoApartamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoApartamento tipo) {
        this.tipo = tipo;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public void setValorMensual(double valorMensual) {
        this.valorMensual = valorMensual;
    }
}
