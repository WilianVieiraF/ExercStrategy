package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

public abstract class FreteBase implements FreteStrategy {
    private static final double VALOR_POR_KG = 3.0;
    private static final double ADICIONAL_NORTE = 30.0;

    protected abstract double freteBase();

    @Override
    public final double calcular(Pedido pedido) {
        double fretePorPeso = pedido.getPeso() * VALOR_POR_KG;
        double adicionalRegiao =
                pedido.getRegiao().equalsIgnoreCase("norte") ? ADICIONAL_NORTE : 0.0;
        return freteBase() + fretePorPeso + adicionalRegiao;
    }
}