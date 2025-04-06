public class MochilaDinamica {

    public static int mochilaPD(int[] pesos, int[] valores, int capacidade) {
        int n = pesos.length;
        int[][] maxTab = new int[n + 1][capacidade + 1];
        int iteracoes = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacidade; j++) {
                iteracoes++; // Conta cada comparação realizada
                if (pesos[i - 1] <= j) {
                    maxTab[i][j] = Math.max(
                        maxTab[i - 1][j],
                        valores[i - 1] + maxTab[i - 1][j - pesos[i - 1]]
                    );
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }

        System.out.println("Iterações: " + iteracoes);
        return maxTab[n][capacidade];
    }

    public static void main(String[] args) {
        int[] pesos = {5, 2, 2, 1};
        int[] valores = {2, 4, 2, 3};
        int capacidade = 7;

        int valorMaximo = mochilaPD(pesos, valores, capacidade);
        System.out.println("Valor máximo (Programação Dinâmica): " + valorMaximo);
    }
}
