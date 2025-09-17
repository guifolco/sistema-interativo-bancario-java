# 🏦 Sistema Bancário Interativo em Java (POO)

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=java)

## 📄 Descrição

Este projeto é uma **aplicação de console interativa** que simula as operações de um caixa eletrônico ou um internet banking simplificado. O usuário pode criar e gerenciar múltiplos tipos de contas bancárias (Conta Corrente e Conta Poupança) através de um menu de fácil navegação.

O principal objetivo deste projeto é a aplicação prática dos pilares da Programação Orientada a Objetos (**Herança**, **Polimorfismo** e **Encapsulamento**) em um ambiente dinâmico e interativo, criando um sistema coeso, organizado e que gerencia o estado da aplicação em tempo de execução.

## 📸 Screenshots da Aplicação



## ✨ Funcionalidades

* **Menu Principal e Sub-menus Interativos:** Navegação clara através de um loop principal que permite ao usuário escolher a ação desejada.
* **Criação Dinâmica de Contas:** Permite a criação de `Conta Corrente` e `Conta Poupança` em tempo de execução, que são armazenadas em uma lista.
* **Acesso Seguro a Contas:** O usuário pode acessar uma conta específica através de seu número para realizar operações.
* **Operações Bancárias Completas:** Implementa as funcionalidades de `sacar`, `depositar` e `verificar saldo`.
* **Funcionalidades Específicas por Conta:**
    * **Conta Corrente:** Possui uma lógica de **cheque especial**, permitindo saques além do saldo.
    * **Conta Poupança:** Possui um método para aplicar um **rendimento mensal** e uma opção de menu exclusiva para esta ação.

## 🧠 Conceitos de Software Demonstrados

* **Programação Orientada a Objetos (POO):**
    * **Herança:** Reutilização de código através de uma superclasse `Conta`.
    * **Polimorfismo:** Sobrescrita (`@Override`) do método `sacar()` na `ContaCorrente` para um comportamento especializado.
    * **Encapsulamento:** Proteção dos dados (`private`) com acesso controlado por métodos.
* **Gerenciamento de Estado da Aplicação:** Utilização de um `ArrayList` para gerenciar uma coleção dinâmica de objetos `Conta` em memória.
* **Controle de Fluxo com Menus:** Implementação de loops `while` e lógica condicional (`switch`/`if-else`) para gerenciar a navegação e os sub-menus.
* **Interação com Usuário (I/O):** Uso da classe `Scanner` para criar uma experiência de usuário robusta no console.
* **Busca de Dados:** Implementação de uma lógica de busca para encontrar um objeto específico dentro de uma coleção.
* **Uso de `instanceof` e Casting:** Para identificar o tipo de conta em tempo de execução e habilitar funcionalidades exclusivas.

## 🛠️ Tecnologias Utilizadas

* **Java (JDK 17+)**
* **Java Collections (`ArrayList`)**
* **Git & GitHub** para controle de versão.

## 🚀 Como Executar o Projeto

1.  **Pré-requisitos:**
    * Ter o **Java (JDK 17 ou superior)** e o **Git** instalados.

2.  **Clone o Repositório:**
    ```bash
    # Substitua pela URL HTTPS do seu repositório
    git clone [https://github.com/seu-usuario/sistema-bancario-interativo-java.git](https://github.com/seu-usuario/sistema-bancario-interativo-java.git)
    ```

3.  **Navegue até a Pasta do Projeto:**
    ```bash
    cd sistema-bancario-interativo-java
    ```

4.  **Navegue até a Pasta `src`:**
    ```bash
    cd src
    ```

5.  **Compile o Código:**
    ```bash
    # O asterisco (*) compila todas as classes Java necessárias na ordem correta
    javac *.java
    ```

6.  **Execute o Programa:**
    ```bash
    # Substitua 'App' pelo nome da sua classe com o método main
    java App
    ```
    O menu interativo aparecerá no seu terminal.

## ✒️ Autor

Desenvolvido por **[Seu Nome Completo]**

[<img src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" />](https://www.linkedin.com/in/seu-usuario-do-linkedin/)