# Strategy

## O que é o padrão Strategy?

O **Strategy** é um padrão comportamental usado quando temos **várias formas diferentes de realizar uma mesma tarefa**.

Ele permite separar cada algoritmo em uma classe diferente e escolher qual será utilizado **em tempo de execução**, sem precisar alterar a classe principal.

Em resumo:

- Existem vários algoritmos para o mesmo objetivo.
- Cada algoritmo fica separado em uma estratégia.
- A estratégia pode ser escolhida ou trocada durante a execução.
- Facilita adicionar novas formas de comportamento sem modificar o código principal.

---

## Exercício 1: Aplicações

### 1. Cálculo de frete

**Faz sentido usar Strategy.**

Existem diferentes formas de calcular o frete, como **Sedex, PAC e Retirada**, que podem ser tratadas como estratégias diferentes. O Strategy permite adicionar novas modalidades de frete sem precisar modificar o `Checkout`.

---

### 2. Formas de pagamento

**Faz sentido usar Strategy.**

Pix, cartão e boleto possuem **fluxos diferentes para realizar o pagamento**, mas todos têm o mesmo objetivo. Cada forma de pagamento pode ser uma estratégia escolhida pelo cliente em tempo de execução, facilitando também a adição de novos métodos.

---

### 3. Fórmulas de dano em um jogo

**Faz sentido usar Strategy.**

As diferentes fórmulas de dano, como dano bruto, crítico e à distância, são **algoritmos alternativos para calcular o dano**. O Strategy permite trocar a fórmula utilizada sem alterar a lógica principal do combate.

---

### 4. Relatório com PDF fixo

**Não faz sentido usar Strategy.**

Nesse caso existe apenas **um algoritmo estável**, pois o relatório sempre será gerado da mesma maneira. Criar estratégias diferentes adicionaria complexidade sem trazer um benefício real, sendo um caso de overengineering.

---

### 5. Classe Ponto

**Não faz sentido usar Strategy.**

A classe possui apenas `x` e `y` e realiza uma operação simples de soma, sem diferentes algoritmos ou comportamentos que possam ser trocados. Usar Strategy nesse caso seria desnecessário e deixaria o código mais complexo.