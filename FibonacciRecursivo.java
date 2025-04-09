public class FibonacciRecursivo {
    public static int fiboRec(int n, int[] contadores) {
        contadores[1]++; // Chamada recursiva (iteração)
        contadores[0]++; // if (n <= 1)
        if (n <= 1) {
            contadores[0]++; // return n
            return n;
        }
    
        // Chamadas recursivas
        int a = fiboRec(n - 1, contadores);
        contadores[0]++; // chamada recursiva n - 1
    
        int b = fiboRec(n - 2, contadores);
        contadores[0]++; // chamada recursiva n - 2
    
        contadores[0]++; // soma final
        return a + b;
    }
    

    public static void main(String[] args) {
        int[] testCases = {4, 8, 16, 32};
        for (int n : testCases) {
            int[] contadores = {0, 0}; // {instruções, iterações}
            long startTime = System.nanoTime();
            int result = fiboRec(n, contadores);
            long endTime = System.nanoTime();
            System.out.println("FIBO-REC(" + n + ") = " + result
                    + " | Tempo: " + (endTime - startTime) + " ns"
                    + " | Instruções: " + contadores[0]
                    + " | Iterações: " + contadores[1]);
        }
    }
}