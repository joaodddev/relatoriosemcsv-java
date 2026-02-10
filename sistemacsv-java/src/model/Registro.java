package model;

import java.time.LocalDate;

public class Registro {

    private LocalDate data;
    private String descricao;
    private double valor;

    public Registro(LocalDate data, String descricao, double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
