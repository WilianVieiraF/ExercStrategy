package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.contexto.PoliticaComercial;

public class RelatorioPedido {

    private final PoliticaComercial politica;

    public RelatorioPedido(PoliticaComercial politica) {
        this.politica = politica;
    }

    public String formatar(Pedido pedido) {
        double valorDesconto = politica.calcularDesconto(pedido);
        double valorFrete = politica.calcularFrete(pedido);
        double total = pedido.getValor() - valorDesconto + valorFrete;

        return String.format(
                "%s | valor: %.2f | desconto: %.2f | frete: %.2f | total: %.2f",
                politica.etiqueta(), pedido.getValor(), valorDesconto, valorFrete, total);
    }
}