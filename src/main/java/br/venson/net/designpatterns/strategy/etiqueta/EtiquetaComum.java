package br.venson.net.designpatterns.strategy.etiqueta;

public class EtiquetaComum implements EtiquetaStrategy {
    @Override public String etiqueta() { return "Cliente comum"; }
}