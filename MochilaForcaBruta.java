import java.util.*;

public class MochilaForcaBruta {

    static int iteracoes = 0;
    static int instrucoes = 0;

    public static int mochilaForcaBruta(int[] pesos, int[] valores, int capacidade, int n, List<Integer> blocosSelecionados) {
        iteracoes++;
        instrucoes++;

        if (n == 0 || capacidade == 0) {
            instrucoes += 2;
            return 0;
        }

        if (pesos[n - 1] > capacidade) {
            instrucoes += 2;
            return mochilaForcaBruta(pesos, valores, capacidade, n - 1, blocosSelecionados);
        } else {
            instrucoes += 3;

            List<Integer> incluir = new ArrayList<>();
            List<Integer> excluir = new ArrayList<>();

            int valorIncluir = valores[n - 1] + mochilaForcaBruta(pesos, valores, capacidade - pesos[n - 1], n - 1, incluir);
            int valorExcluir = mochilaForcaBruta(pesos, valores, capacidade, n - 1, excluir);
            instrucoes += 3;

            if (valorIncluir > valorExcluir) {
                instrucoes++;
                incluir.add(n);
                blocosSelecionados.addAll(incluir);
                instrucoes++;
                return valorIncluir;
            } else {
                blocosSelecionados.addAll(excluir);
                instrucoes++;
                return valorExcluir;
            }
        }
    }

    public static void executarCaso(String titulo, int[] pesos, int[] valores, int capacidade) {
        iteracoes = 0;
        instrucoes = 0;
        System.out.println("=== Força Bruta: " + titulo + " ===");

        List<Integer> blocos = new ArrayList<>();
        long inicio = System.nanoTime();
        int valorMax = mochilaForcaBruta(pesos, valores, capacidade, pesos.length, blocos);
        long fim = System.nanoTime();

        Collections.sort(blocos);
        System.out.println("Valor máximo: " + valorMax);
        System.out.println("Blocos selecionados: " + blocos);
        System.out.println("Tempo (ns): " + (fim - inicio));
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Instruções: " + instrucoes);
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
