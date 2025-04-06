import java.util.*;

public class MochilaForcaBruta {

    public static int mochilaForcaBruta(int[] pesos, int[] valores, int capacidade, int n, List<Integer> blocosSelecionados) {
        if (n == 0 || capacidade == 0) return 0;

        if (pesos[n - 1] > capacidade) {
            return mochilaForcaBruta(pesos, valores, capacidade, n - 1, blocosSelecionados);
        } else {
            List<Integer> incluir = new ArrayList<>();
            List<Integer> excluir = new ArrayList<>();

            int valorIncluir = valores[n - 1] + mochilaForcaBruta(pesos, valores, capacidade - pesos[n - 1], n - 1, incluir);
            int valorExcluir = mochilaForcaBruta(pesos, valores, capacidade, n - 1, excluir);

            if (valorIncluir > valorExcluir) {
                incluir.add(n); // Base 1
                blocosSelecionados.addAll(incluir);
                return valorIncluir;
            } else {
                blocosSelecionados.addAll(excluir);
                return valorExcluir;
            }
        }
    }

    public static void executarCaso(String titulo, int[] pesos, int[] valores, int capacidade) {
        System.out.println("=== Força Bruta: " + titulo + " ===");
        List<Integer> blocos = new ArrayList<>();
        int valorMax = mochilaForcaBruta(pesos, valores, capacidade, pesos.length, blocos);
        Collections.sort(blocos);
        System.out.println("Valor máximo: " + valorMax);
        System.out.println("Blocos selecionados: " + blocos);
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
