import java.util.Arrays;

public class FibonacciMemoization {
    public static int memoizedFibo(int n, int[] contadores) {
        if (n < 0) {
            throw new IllegalArgumentException("O valor de n não pode ser negativo.");
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return lookupFibo(memo, n, contadores);
    }

    private static int lookupFibo(int[] memo, int n, int[] contadores) {
        contadores[1]++; // chamada do método (iteração)
    
        contadores[0]++; // if (memo[n] >= 0)
        if (memo[n] >= 0) {
            contadores[0]++; // return memo[n]
            return memo[n];
        }
    
        contadores[0]++; // if (n <= 1)
        if (n <= 1) {
            contadores[0]++; // atribuição
            memo[n] = n;
        } else {
            contadores[0] += 2; // soma e atribuição
            memo[n] = lookupFibo(memo, n - 1, contadores) + lookupFibo(memo, n - 2, contadores);
        }
    
        return memo[n];
    }
    

    public static void main(String[] args) {
        try {
            int[] testCases = {4, 8, 16, 32, 128, 1000};
            for (int n : testCases) {
                int[] contadores = {0, 0}; // {instruções, iterações}
                long startTime = System.nanoTime();
                int result = memoizedFibo(n, contadores);
                long endTime = System.nanoTime();
                System.out.println("MEMOIZED-FIBO(" + n + ") = " + result
                        + " | Tempo: " + (endTime - startTime) + " ns"
                        + " | Instruções: " + contadores[0]
                        + " | Iterações: " + contadores[1]);
            }
        } catch (StackOverflowError e) {
            System.err.println("Erro: Estouro de pilha. Verifique o valor de n.");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}