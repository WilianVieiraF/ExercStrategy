package br.venson.net.designpatterns.strategy.desconto;

import br.venson.net.designpatterns.strategy.Pedido;

public class DescontoPromocional implements DescontoStrategy {
    private final double percentual;

    public DescontoPromocional(double percentual) { this.percentual = percentual; }

    @Override
    public double calcular(Pedido pedido) { return pedido.getValor() * percentual; }
}