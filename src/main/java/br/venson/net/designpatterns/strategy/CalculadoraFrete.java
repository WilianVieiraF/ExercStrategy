package br.venson.net.designpatterns.strategy;

public class CalculadoraFrete {

    public double calcular(Pedido pedido) {
        double freteBase;
        switch (pedido.getTipoCliente()) {
            case COMUM:
                freteBase = 25.0;
                break;
            case VIP:
                freteBase = 12.0;
                break;
            case CORPORATIVO:
                freteBase = 0.0;
                break;
            default:
                throw new IllegalArgumentException("Tipo de cliente desconhecido");
        }

        double fretePorPeso = pedido.getPeso() * 3.0;
        double adicionalRegiao = pedido.getRegiao().equalsIgnoreCase("norte") ? 30.0 : 0.0;

        return freteBase + fretePorPeso + adicionalRegiao;
    }
}
