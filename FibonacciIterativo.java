public class FibonacciIterativo {
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        int[] testCases = {4, 8, 16, 32, 128, 1000, 10000};
        StringBuilder resultados = new StringBuilder(); // Armazena os resultados

        for (int n : testCases) {
            long startTime = System.nanoTime();
            int result = fibo(n);
            long endTime = System.nanoTime();
            resultados.append("FIBO(").append(n).append(") = ").append(result)
                      .append(" | Tempo: ").append(endTime - startTime).append(" ns\n");
        }

        // Imprime todos os resultados de uma vez
        System.out.println(resultados.toString());
    }
}