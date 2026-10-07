# Projeto: regras de venda com anti-pattern (Strategy)

Sistema simplificado de uma plataforma de vendas que calcula **desconto**, **frete**
e **relatório** de um pedido conforme o **tipo de cliente**.

O objetivo deste projeto é **rastrear** o problema de design e propor uma solução
usando o padrão **Strategy**. Não é um projeto pronto: o código funciona, mas o
design concentra a decisão de comportamento em condicionais repetidas.

## Como rodar

O projeto é Maven (Java 17) e abre direto no Eclipse/IntelliJ.

- **Eclipse/IntelliJ:** importe a pasta do projeto e execute a classe `Main`.
- **Linha de comando:**
  ```bash
  mvn compile
  java -cp target/classes br.venson.net.designpatterns.strategy.Main
  ```

## O cenário

- `TipoCliente`: `COMUM`, `VIP`, `CORPORATIVO`.
- `Pedido`: tipo do cliente, valor, peso e região.
- `CalculadoraDesconto`: decide o desconto com `switch (tipoCliente)`.
- `CalculadoraFrete`: decide o frete com o **mesmo** `switch (tipoCliente)`.
- `RelatorioPedido`: formata o texto com o **mesmo** `switch (tipoCliente)` de novo.
- `Main`: monta alguns pedidos e imprime o relatório.

## O que observar

1. O mesmo `switch` sobre o **mesmo discriminador** (`TipoCliente`) aparece em
   **três classes** diferentes.
2. Para adicionar um novo tipo de cliente, quantas classes precisam ser editadas?
3. As regras de uma mesma família de algoritmos (desconto, frete, formatação)
   estão **espalhadas** em vez de agrupadas.
4. É possível **trocar a regra em tempo de execução** sem recompilar? Por quê?
5. Como testar apenas a regra de desconto do cliente VIP, de forma isolada?

## Tarefa

Rastreie os problemas de design deste código e proponha uma refatoração com o
padrão **Strategy**, deixando claros os papéis: **interface de estratégia**,
**estratégias concretas** e **contexto**.
