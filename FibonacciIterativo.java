public class FibonacciIterativo {
    public static int fibo(int n, int[] contadores) {
        contadores[0]++; // instrução do if
        if (n <= 1) {
            contadores[1]++; // iteração base
            return n;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        contadores[0] += 2; // atribuições iniciais
    
        for (int i = 2; i <= n; i++) {
            int soma = f[i - 1] + f[i - 2];
            contadores[0]++; // soma
            f[i] = soma;
            contadores[0]++; // atribuição
            contadores[1]++; // iteração
        }
        return f[n];
    }
    

    public static void main(String[] args) {
        int[] testCases = {4, 8, 16, 32, 128, 1000, 10000};
        StringBuilder resultados = new StringBuilder(); 

        for (int n : testCases) {
            int[] contadores = {0, 0}; 
            long startTime = System.nanoTime();
            int result = fibo(n, contadores);
            long endTime = System.nanoTime();
            resultados.append("FIBO(").append(n).append(") = ").append(result)
                      .append(" | Tempo: ").append(endTime - startTime).append(" ns")
                      .append(" | Instruções: ").append(contadores[0])
                      .append(" | Iterações: ").append(contadores[1]).append("\n");
        }

        System.out.println(resultados.toString());
    }
}