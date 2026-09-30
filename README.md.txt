# Biblioteca de Grafos em Java

Biblioteca de grafos desenvolvida em Java como parte da disciplina de **Teoria dos Grafos** do curso de Sistemas de Informação.

O projeto trabalha com **grafos não direcionados** e permite utilizar duas formas de representação: **lista de adjacência** e **matriz de adjacência**.

## Funcionalidades

* Leitura de grafos a partir de arquivo
* Representação por lista de adjacência
* Representação por matriz de adjacência
* Escolha da representação utilizada
* Busca em largura (BFS)
* Busca em profundidade (DFS)
* Cálculo da distância entre dois vértices
* Identificação de componentes conexas
* Cálculo do diâmetro do grafo
* Cálculo de informações básicas do grafo
* Geração dos resultados das buscas em arquivos
* Comparação de desempenho entre lista e matriz
* Comparação de uso de memória entre as representações

## Informações calculadas

O programa permite obter:

* Quantidade de vértices
* Quantidade de arestas
* Grau mínimo
* Grau máximo
* Grau médio
* Grau mediano
* Quantidade de componentes conexas
* Tamanho das componentes
* Distância entre vértices
* Diâmetro do grafo

## Representações

### Lista de adjacência

Armazena, para cada vértice, os seus vértices vizinhos.

Essa representação utiliza memória proporcional à quantidade de vértices e arestas do grafo.

### Matriz de adjacência

Utiliza uma matriz para indicar a existência de arestas entre os vértices.

Essa representação facilita a verificação direta da existência de uma aresta, mas utiliza mais memória em grafos grandes.

## Buscas

### Busca em largura — BFS

A BFS utiliza uma fila para percorrer o grafo por níveis.

Para cada vértice, são armazenados:

* Pai
* Nível

### Busca em profundidade — DFS

A DFS utiliza uma pilha para realizar o percurso em profundidade.

Assim como na BFS, são armazenados o pai e o nível de cada vértice alcançado.

## Estrutura do projeto

```text
biblioteca-grafos-java/
│
├── src/
│   ├── Grafo.java
│   ├── ListaAdjacencia.java
│   ├── MatrizAdjacencia.java
│   ├── LeitorGrafo.java
│   ├── ResultadoBusca.java
│   ├── BuscaLargura.java
│   ├── BuscaLarguraMatriz.java
│   ├── BuscaProfundidade.java
│   ├── BuscaProfundidadeMatriz.java
│   ├── ComponentesConexas.java
│   ├── Diametro.java
│   ├── SaidaBusca.java
│   ├── SaidaComponentes.java
│   └── Main.java
│
├── grafo_1.txt
├── bfs_1.txt
├── bfs_2.txt
├── bfs_3.txt
├── dfs_1.txt
├── dfs_2.txt
└── dfs_3.txt
```

## Como executar

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto em uma IDE compatível com Java.

3. Certifique-se de que o arquivo `grafo_1.txt` esteja no local esperado pelo programa.

4. Execute a classe:

```text
Main.java
```

5. Utilize o menu para carregar o grafo e executar as funcionalidades disponíveis.

## Exemplo do menu

```text
========================================
          BIBLIOTECA DE GRAFOS
========================================
Grafo: nenhum grafo carregado

1 - Carregar grafo
2 - Escolher representacao
3 - Informacoes do grafo
4 - Busca em largura
5 - Busca em profundidade
6 - Distancia entre vertices
7 - Componentes conexas
8 - Diametro
9 - Comparar desempenho
0 - Sair

Escolha:
```

## Resultados do grafo utilizado

O grafo utilizado nos testes possui:

| Informação          | Resultado |
| ------------------- | --------: |
| Vértices            |    10.000 |
| Arestas             |   109.921 |
| Grau mínimo         |         8 |
| Grau máximo         |        43 |
| Grau médio          |   21,9842 |
| Grau mediano        |        22 |
| Componentes conexas |         1 |
| Maior componente    |    10.000 |
| Menor componente    |    10.000 |
| Diâmetro            |         5 |

### Desempenho

Foram realizadas 100 execuções das buscas para comparação entre as representações.

| Busca |       Lista |        Matriz |
| ----- | ----------: | ------------: |
| BFS   | 5,006067 ms | 251,450927 ms |
| DFS   | 4,408272 ms | 242,168420 ms |

### Memória

| Representação        | Memória aproximada |
| -------------------- | -----------------: |
| Lista de adjacência  |          5,0849 MB |
| Matriz de adjacência |        384,8205 MB |

Os valores de memória são aproximados e podem variar de acordo com a JVM e as condições de execução.

## Tecnologias utilizadas

* Java
* Estruturas de dados
* Lista de adjacência
* Matriz de adjacência
* BFS
* DFS

## Autora

**Maria Eduarda**

Curso de Sistemas de Informação — UFV Campus Rio Paranaíba.
