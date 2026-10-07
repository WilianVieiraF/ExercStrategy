package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

public interface FreteStrategy {
    double calcular(Pedido pedido);
}