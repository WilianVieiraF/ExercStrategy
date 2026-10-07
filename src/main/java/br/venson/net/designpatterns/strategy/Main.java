package br.venson.net.designpatterns.strategy;

import java.util.List;

import br.venson.net.designpatterns.strategy.contexto.PoliticaComercial;
import br.venson.net.designpatterns.strategy.contexto.PoliticaComercialFactory;
import br.venson.net.designpatterns.strategy.desconto.DescontoPromocional;
import br.venson.net.designpatterns.strategy.desconto.DescontoVip;
import br.venson.net.designpatterns.strategy.etiqueta.EtiquetaVip;

public class Main {

    public static void main(String[] args) {
        Pedido comum = new Pedido(TipoCliente.COMUM, 200.0, 2.0, "sul");
        Pedido vip = new Pedido(TipoCliente.VIP, 200.0, 2.0, "sul");
        Pedido corporativo = new Pedido(TipoCliente.CORPORATIVO, 200.0, 2.0, "norte");

        // Mesmo resultado de antes, agora via políticas montadas pela factory
        for (Pedido p : List.of(comum, vip, corporativo)) {
            PoliticaComercial politica = PoliticaComercialFactory.para(p.getTipoCliente());
            System.out.println(new RelatorioPedido(politica).formatar(p));
        }

        // Troca em runtime: promoção e volta à regra padrão
        PoliticaComercial politicaVip = PoliticaComercialFactory.para(TipoCliente.VIP);
        RelatorioPedido relatorioVip = new RelatorioPedido(politicaVip);

        System.out.println(relatorioVip.formatar(vip));   // regra padrão

        politicaVip.setDesconto(new DescontoPromocional(0.30));
        politicaVip.setEtiqueta(() -> "Cliente VIP (promoção de 30%)");
        System.out.println(relatorioVip.formatar(vip));   // promoção

        politicaVip.setDesconto(new DescontoVip());
        politicaVip.setEtiqueta(new EtiquetaVip());
        System.out.println(relatorioVip.formatar(vip));   // volta ao padrão
    }
}