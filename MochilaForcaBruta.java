public class MochilaForcaBruta {

    static int iteracoes = 0;

    public static int mochilaForcaBruta(int[] pesos, int[] valores, int capacidade, int n) {
        iteracoes++;

        if (n == 0 || capacidade == 0) {
            return 0;
        }

        if (pesos[n - 1] > capacidade) {
            return mochilaForcaBruta(pesos, valores, capacidade, n - 1);
        } else {
            int excluirItem = mochilaForcaBruta(pesos, valores, capacidade, n - 1);
            int incluirItem = valores[n - 1] + mochilaForcaBruta(pesos, valores, capacidade - pesos[n - 1], n - 1);
            return Math.max(excluirItem, incluirItem);
        }
    }

    public static void main(String[] args) {
        int[] pesos = {5, 2, 2, 1};
        int[] valores = {2, 4, 2, 3};
        int capacidade = 7;

        int valorMaximo = mochilaForcaBruta(pesos, valores, capacidade, pesos.length);
        System.out.println("Valor máximo (Força Bruta): " + valorMaximo);
        System.out.println("Iterações: " + iteracoes);
    }
}
