package br.venson.net.designpatterns.strategy.etiqueta;

public class EtiquetaVip implements EtiquetaStrategy {
    @Override public String etiqueta() { return "Cliente VIP (10% de desconto)"; }
}