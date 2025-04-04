import java.util.Arrays;

public class FibonacciMemoization {
    public static int memoizedFibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O valor de n não pode ser negativo.");
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return lookupFibo(memo, n);
    }

    private static int lookupFibo(int[] memo, int n) {
        if (memo[n] >= 0) { // Retorna o valor armazenado se já foi calculado
            return memo[n];
        }
        if (n <= 1) { // Caso base: Fibonacci(0) = 0, Fibonacci(1) = 1
            memo[n] = n;
        } else { // Calcula recursivamente e armazena o resultado
            memo[n] = lookupFibo(memo, n - 1) + lookupFibo(memo, n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        try {
            int[] testCases = {4, 8, 16, 32, 128, 1000, 10000};
            for (int n : testCases) {
                long startTime = System.nanoTime();
                int result = memoizedFibo(n);
                long endTime = System.nanoTime();
                System.out.println("MEMOIZED-FIBO(" + n + ") = " + result + " | Tempo: " + (endTime - startTime) + " ns");
            }
        } catch (StackOverflowError e) {
            System.err.println("Erro: Estouro de pilha. Verifique o valor de n.");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}