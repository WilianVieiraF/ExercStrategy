package br.venson.net.designpatterns.strategy;

public class Pedido {
    private final TipoCliente tipoCliente;
    private final double valor;
    private final double peso;
    private final String regiao;

    public Pedido(TipoCliente tipoCliente, double valor, double peso, String regiao) {
        this.tipoCliente = tipoCliente;
        this.valor = valor;
        this.peso = peso;
        this.regiao = regiao;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    public String getRegiao() {
        return regiao;
    }
}
