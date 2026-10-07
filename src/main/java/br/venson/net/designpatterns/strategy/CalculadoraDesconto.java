package br.venson.net.designpatterns.strategy;

public class CalculadoraDesconto {

    public double calcular(Pedido pedido) {
        switch (pedido.getTipoCliente()) {
            case COMUM:
                return pedido.getValor() * 0.0;
            case VIP:
                return pedido.getValor() * 0.10;
            case CORPORATIVO:
                return pedido.getValor() * 0.20;
            default:
                throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }
    }
}
