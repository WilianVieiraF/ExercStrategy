package br.venson.net.designpatterns.strategy.contexto;

import br.venson.net.designpatterns.strategy.Pedido;
import br.venson.net.designpatterns.strategy.desconto.DescontoStrategy;
import br.venson.net.designpatterns.strategy.etiqueta.EtiquetaStrategy;
import br.venson.net.designpatterns.strategy.frete.FreteStrategy;

public class PoliticaComercial {
    private DescontoStrategy desconto;
    private FreteStrategy frete;
    private EtiquetaStrategy etiqueta;

    public PoliticaComercial(DescontoStrategy desconto, FreteStrategy frete,
                             EtiquetaStrategy etiqueta) {
        this.desconto = desconto;
        this.frete = frete;
        this.etiqueta = etiqueta;
    }

    public double calcularDesconto(Pedido pedido) { return desconto.calcular(pedido); }
    public double calcularFrete(Pedido pedido)    { return frete.calcular(pedido); }
    public String etiqueta()                      { return etiqueta.etiqueta(); }

    public void setDesconto(DescontoStrategy desconto) { this.desconto = desconto; }
    public void setFrete(FreteStrategy frete)          { this.frete = frete; }
    public void setEtiqueta(EtiquetaStrategy etiqueta) { this.etiqueta = etiqueta; }
}