# 💣 Campo Minado (Console) — Java

Implementação completa do clássico jogo **Campo Minado**, executado totalmente no **terminal**, desenvolvido em **Java**, com arquitetura organizada e foco em **Programação Orientada a Objetos (POO)**.

O projeto simula fielmente a lógica original do jogo, incluindo geração aleatória de minas, abertura recursiva de campos seguros, marcação de bandeiras e verificação automática de vitória ou derrota.

Em projetos futuros utilizarei esta base de codigo para implementar a interface no Desktop utilizando Swing.

---

## 🎯 Objetivo

Este projeto foi desenvolvido com fins educacionais para praticar:

* Programação Orientada a Objetos
* Modelagem de domínio
* Arquitetura em camadas
* Tratamento de exceções personalizadas
* Estruturação profissional de projetos Java

---

## 🛠️ Tecnologias utilizadas

* Java (JDK 8 ou superior)
* Terminal / Console
* Streams API
* Collections Framework

---

## 📂 Estrutura do Projeto

```
src/
└── br/
    └── com/
        └── projeto/
            └── cm/
                ├── Aplicacao.java
                │
                ├── modelo/
                │   ├── Campo.java
                │   └── Tabuleiro.java
                │
                ├── visao/
                │   └── TabuleiroConsole.java
                │
                └── excecao/
                    ├── ExplosaoException.java
                    └── SairException.java
```

---

## 🧠 Arquitetura do Projeto

O projeto segue uma arquitetura em camadas bem definida:

```
Aplicacao (Main)
     ↓
Visao (TabuleiroConsole)
     ↓
Modelo (Tabuleiro, Campo)
     ↓
Excecoes (controle de fluxo)
```

Separação clara de responsabilidades:

| Camada    | Responsabilidade              |
| --------- | ----------------------------- |
| Aplicação | Ponto de entrada              |
| Visão     | Interface com usuário         |
| Modelo    | Lógica do jogo                |
| Exceção   | Controle de eventos especiais |

---

## 📦 Descrição das Classes

### Aplicacao.java

Classe principal que inicia o jogo:

```java
public static void main(String[] args) {
    Tabuleiro tabuleiro = new Tabuleiro(6, 6, 4);
    new TabuleiroConsole(tabuleiro);
}
```

Define:

* tamanho do tabuleiro: 6x6
* número de minas: 4

---

### Tabuleiro.java

Responsável por:

* Gerar o tabuleiro
* Distribuir minas aleatoriamente
* Abrir campos
* Alternar marcações
* Verificar vitória
* Reiniciar jogo

Utiliza:

```java
Math.random()
Streams API
```

---

### Campo.java

Representa cada célula do tabuleiro.

Controla:

* posição
* estado (aberto, fechado, marcado)
* presença de mina
* vizinhos
* abertura recursiva

Estados possíveis:

| Símbolo    | Significado    |
| ---------- | -------------- |
| `?`        | fechado        |
| `X`        | marcado        |
| `*`        | mina           |
| `1,2,3...` | minas próximas |
| espaço     | campo vazio    |

---

### TabuleiroConsole.java

Responsável pela interface no terminal.

Permite ao usuário:

* abrir campos
* marcar/desmarcar campos
* reiniciar jogo
* sair do jogo

Entrada esperada:

```
linha,coluna
```

Exemplo:

```
1,3
```

---

### ExplosaoException.java

Exceção lançada quando o jogador abre uma mina.

Usada para encerrar a partida com derrota.

---

### SairException.java

Exceção usada para encerrar o jogo quando o usuário digita:

```
sair
```

---

## ▶️ Como executar

### 1. Compilar

No diretório `src`:

```bash
javac br/com/projeto/cm/**/*.java
```

---

### 2. Executar

```bash
java br.com.projeto.cm.Aplicacao
```

---

## 🎮 Como jogar

O terminal exibirá o tabuleiro:

```
  0  1  2  3  4  5
0 ?  ?  ?  ?  ?  ?
1 ?  ?  ?  ?  ?  ?
2 ?  ?  ?  ?  ?  ?
3 ?  ?  ?  ?  ?  ?
4 ?  ?  ?  ?  ?  ?
5 ?  ?  ?  ?  ?  ?
```

Digite:

```
linha,coluna
```

Depois escolha:

```
1 - Abrir campo
2 - Marcar / Desmarcar campo
```

---

## 🏆 Condições de vitória

O jogador vence quando:

* todos os campos seguros são abertos
* todas as minas estão corretamente marcadas

---

## 💥 Condições de derrota

O jogador perde quando abre um campo com mina.

---

## 🔄 Reinício do jogo

Ao final de uma partida:

```
Outra partida? (S/n)
```

---

## 🚪 Sair do jogo

Digite:

```
sair
```

---

## 🧩 Conceitos aplicados

* Programação Orientada a Objetos
* Encapsulamento
* Streams API
* Recursividade
* Tratamento de exceções personalizadas
* Arquitetura em camadas
* Modelagem de domínio
* Clean Code

---

## 🚀 Possíveis melhorias futuras

* Interface gráfica com JavaFX
* Interface Web (Spring Boot)
* Sistema de níveis
* Ranking
* Salvamento de partidas
* Testes unitários (JUnit)

---

## 👨‍💻 Autor

Projeto desenvolvido para fins de estudo e prática de Java.

---

## 📄 Licença

Uso livre para fins educacionais.
