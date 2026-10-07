package br.venson.net.designpatterns.strategy.etiqueta;

public class EtiquetaCorporativa implements EtiquetaStrategy {
    @Override public String etiqueta() { return "Cliente corporativo (20% de desconto)"; }
}
