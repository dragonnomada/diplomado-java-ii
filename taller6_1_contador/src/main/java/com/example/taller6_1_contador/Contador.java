package com.example.taller6_1_contador;

import java.util.Date;

// POJO: Plain Old Java Object
// DTO: Data Transfer Object
// * Su naturaleza es transportar Contador{valor, fechaModificado}
public class Contador {

    private int valor; // 0
    private Date fechaModificado; // null

    public Contador(int valor, Date fechaModificado) {
        this.valor = valor;
        this.fechaModificado = fechaModificado;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Date getFechaModificado() {
        return fechaModificado;
    }

    public void setFechaModificado(Date fechaModificado) {
        this.fechaModificado = fechaModificado;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "valor=" + valor +
                ", fechaModificado=" + fechaModificado +
                '}';
    }
}
