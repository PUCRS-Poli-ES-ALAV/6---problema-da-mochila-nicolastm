import java.util.*;

public class MochilaDinamica {

    public static int mochilaPD(int[] pesos, int[] valores, int capacidade, int[][] maxTab) {
        int n = pesos.length;
        int iteracoes = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacidade; j++) {
                iteracoes++;
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

    public static List<Integer> recuperarItensSelecionados(int[][] maxTab, int[] pesos, int capacidade) {
        List<Integer> selecionados = new ArrayList<>();
        int i = pesos.length;
        int j = capacidade;

        while (i > 0 && j > 0) {
            if (maxTab[i][j] != maxTab[i - 1][j]) {
                selecionados.add(i); // Base 1
                j -= pesos[i - 1];
            }
            i--;
        }

        Collections.reverse(selecionados);
        return selecionados;
    }

    public static void executarCaso(String titulo, int[] pesos, int[] valores, int capacidade) {
        System.out.println("=== PD: " + titulo + " ===");
        int[][] maxTab = new int[pesos.length + 1][capacidade + 1];
        int valorMax = mochilaPD(pesos, valores, capacidade, maxTab);
        List<Integer> selecionados = recuperarItensSelecionados(maxTab, pesos, capacidade);
        System.out.println("Valor máximo: " + valorMax);
        System.out.println("Blocos selecionados: " + selecionados);
        System.out.println();
    }

    public static void main(String[] args) {
        executarCaso("Caso original", 
            new int[]{5, 2, 2, 1}, 
            new int[]{2, 4, 2, 3}, 
            7
        );

        executarCaso("Caso de teste 1 do Moodle", 
            new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82}, 
            new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72}, 
            165
        );

        executarCaso("Caso de teste 2 do Moodle", 
            new int[]{56, 59, 80, 64, 75, 17}, 
            new int[]{50, 50, 64, 46, 50, 5}, 
            190
        );
    }
}
