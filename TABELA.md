1. Monte uma tabela com a contabilização das execuções anteriores (número de iterações e número de instruções) e com os resultados das execuções. As linhas da tabela são os algoritmos implementados, as colunas os valores para testar e contabilizar.


| Algoritmo          | Valor | Resultado     | Tempo (ns) | Instruções   | Iterações   |
|---------------------|-------|---------------|------------|--------------|-------------|
| FibonacciRecursivo | 4     | 3             | 1125       | 26           | 9           |
| FibonacciRecursivo | 8     | 21            | 3291       | 200          | 67          |
| FibonacciRecursivo | 16    | 987           | 83250      | 9578         | 3193        |
| FibonacciRecursivo | 32    | 2178309       | 16295208   | 21147464     | 7049155     |
| FibonacciIterativo | 4     | 3             | 1333       | 9            | 3           |
| FibonacciIterativo | 8     | 21            | 584        | 17           | 7           |
| FibonacciIterativo | 16    | 987           | 625        | 33           | 15          |
| FibonacciIterativo | 32    | 2178309       | 1542       | 65           | 31          |
| FibonacciIterativo | 128   | -1361106235   | 4250       | 257          | 127         |
| FibonacciIterativo | 1000  | 1556111435    | 29542      | 2001         | 999         |
| FibonacciIterativo | 10000 | 1242044891    | 287084     | 20001        | 9999        |
| FibonacciMemoization | 4   | 3             | 8541       | 22           | 7           |
| FibonacciMemoization | 8   | 21            | 2125       | 46           | 15          |
| FibonacciMemoization | 16  | 987           | 1916       | 94           | 31          |
| FibonacciMemoization | 32  | 2178309       | 3292       | 190          | 63          |
| FibonacciMemoization | 128 | -1361106235   | 35334      | 1936         | 645         |
| FibonacciMemoization | 1000| 1556111435    | 132208     | 42796        | 14265       |



## 📊 Comparativo de Resultados - Problema da Mochila

### 🧪 Casos testados

| Caso                     | Abordagem             | Valor Máximo | Iterações | Instruções | Tempo (ns) | Blocos Selecionados   |
|--------------------------|------------------------|--------------|-----------|------------|------------|------------------------|
| Caso Original            | Força Bruta            | 9            | 27        | 146        | 30959      | [2, 3, 4]              |
| Caso Original            | Programação Dinâmica   | 9            | 28        | 100        | 15500      | [2, 3, 4]              |
| Caso de Teste 1 (Moodle) | Força Bruta            | 309          | 362       | 1884       | 170959     | [1, 2, 3, 4, 6]        |
| Caso de Teste 1 (Moodle) | Programação Dinâmica   | 309          | 1650      | 5546       | 69000      | [1, 2, 3, 4, 6]        |
| Caso de Teste 2 (Moodle) | Força Bruta            | 150          | 85        | 442        | 53125      | [1, 2, 5]              |
| Caso de Teste 2 (Moodle) | Programação Dinâmica   | 150          | 1140      | 3870       | 47708      | [1, 2, 5]              |



### 📌 Observações

- A **programação dinâmica** realiza mais iterações porque percorre toda a matriz de possibilidades.
- A **força bruta** pode fazer menos chamadas em casos pequenos, mas seu tempo de execução cresce **exponencialmente** com o número de itens.
- Mesmo com menos iterações em certos casos, a força bruta **não escala bem** com instâncias maiores.

