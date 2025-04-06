1. Monte uma tabela com a contabilização das execuções anteriores (número de iterações e número de instruções) e com os resultados das execuções. As linhas da tabela são os algoritmos implementados, as colunas os valores para testar e contabilizar.


| Algoritmo          | Valor | Resultado     | Tempo (ns) |
|---------------------|-------|---------------|------------|
| FibonacciRecursivo | 4     | 3             | 1814       |
| FibonacciRecursivo | 8     | 21            | 4850       |
| FibonacciRecursivo | 16    | 987           | 199130     |
| FibonacciRecursivo | 32    | 2178309       | 10672064   |
| FibonacciIterativo | 4     | 3             | 1042       |
| FibonacciIterativo | 8     | 21            | 458        |
| FibonacciIterativo | 16    | 987           | 459        |
| FibonacciIterativo | 32    | 2178309       | 625        |
| FibonacciIterativo | 128   | -1361106235   | 1875       |
| FibonacciIterativo | 1000  | 1556111435    | 13917      |
| FibonacciIterativo | 10000 | 1242044891    | 140875     |
| FibonacciMemoization | 4   | 3             | 8041       |
| FibonacciMemoization | 8   | 21            | 1750       |
| FibonacciMemoization | 16  | 987           | 1333       |
| FibonacciMemoization | 32  | 2178309       | 2000       |
| FibonacciMemoization | 128 | -1361106235   | 25584      |
| FibonacciMemoization | 1000| 1556111435    | 432500     |
| FibonacciMemoization | 10000| 1242044891   | 795750     |

## Comparativo de Resultados - Problema da Mochila

### 🧪 Casos testados

| Caso                      | Abordagem             | Valor Máximo | Iterações | Blocos Selecionados   |
|---------------------------|------------------------|---------------|------------|------------------------|
| Caso Original             | Força Bruta            | 9             | 27         | [2, 3, 4]              |
| Caso Original             | Programação Dinâmica   | 9             | 28         | [2, 3, 4]              |
| Caso de Teste 1 (Moodle)  | Força Bruta            | 309           | 362        | [1, 2, 3, 4, 6]        |
| Caso de Teste 1 (Moodle)  | Programação Dinâmica   | 309           | 1650       | [1, 2, 3, 4, 6]        |
| Caso de Teste 2 (Moodle)  | Força Bruta            | 150           | 85         | [1, 2, 5]              |
| Caso de Teste 2 (Moodle)  | Programação Dinâmica   | 150           | 1140       | [1, 2, 5]              |

### 📌 Observações

- A **programação dinâmica** realiza mais iterações porque percorre toda a matriz de possibilidades.
- A **força bruta** pode fazer menos chamadas em casos pequenos, mas seu tempo de execução cresce **exponencialmente** com o número de itens.
- Mesmo com menos iterações em certos casos, a força bruta **não escala bem** com instâncias maiores.

