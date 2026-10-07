package br.venson.net.designpatterns.strategy.desconto;

import br.venson.net.designpatterns.strategy.Pedido;

public interface DescontoStrategy {
    double calcular(Pedido pedido);
}