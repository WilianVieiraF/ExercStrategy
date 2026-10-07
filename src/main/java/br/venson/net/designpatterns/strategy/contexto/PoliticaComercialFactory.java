package br.venson.net.designpatterns.strategy.contexto;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import br.venson.net.designpatterns.strategy.TipoCliente;
import br.venson.net.designpatterns.strategy.desconto.DescontoComum;
import br.venson.net.designpatterns.strategy.desconto.DescontoCorporativo;
import br.venson.net.designpatterns.strategy.desconto.DescontoVip;
import br.venson.net.designpatterns.strategy.etiqueta.EtiquetaComum;
import br.venson.net.designpatterns.strategy.etiqueta.EtiquetaCorporativa;
import br.venson.net.designpatterns.strategy.etiqueta.EtiquetaVip;
import br.venson.net.designpatterns.strategy.frete.FreteComum;
import br.venson.net.designpatterns.strategy.frete.FreteCorporativo;
import br.venson.net.designpatterns.strategy.frete.FreteVip;

public final class PoliticaComercialFactory {

    private static final Map<TipoCliente, Supplier<PoliticaComercial>> REGISTRO =
            new EnumMap<>(TipoCliente.class);

    static {
        REGISTRO.put(TipoCliente.COMUM, () -> new PoliticaComercial(
                new DescontoComum(), new FreteComum(), new EtiquetaComum()));
        REGISTRO.put(TipoCliente.VIP, () -> new PoliticaComercial(
                new DescontoVip(), new FreteVip(), new EtiquetaVip()));
        REGISTRO.put(TipoCliente.CORPORATIVO, () -> new PoliticaComercial(
                new DescontoCorporativo(), new FreteCorporativo(), new EtiquetaCorporativa()));
    }

    private PoliticaComercialFactory() { }

    public static PoliticaComercial para(TipoCliente tipo) {
        Supplier<PoliticaComercial> fornecedor = REGISTRO.get(tipo);
        if (fornecedor == null) {
            throw new IllegalArgumentException("Tipo de cliente sem política: " + tipo);
        }
        return fornecedor.get(); // instância nova: trocar uma regra não afeta outros pedidos
    }
}