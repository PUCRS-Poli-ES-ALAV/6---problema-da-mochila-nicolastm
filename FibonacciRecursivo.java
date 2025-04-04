public class FibonacciRecursivo {
    public static int fiboRec(int n) {
        if (n <= 1) {
            return n;
        }
        return fiboRec(n - 1) + fiboRec(n - 2);
    }

    public static void main(String[] args) {
        int[] testCases = {4, 8, 16, 32};
        for (int n : testCases) {
            long startTime = System.nanoTime();
            int result = fiboRec(n);
            long endTime = System.nanoTime();
            System.out.println("FIBO-REC(" + n + ") = " + result + " | Tempo: " + (endTime - startTime) + " ns");
        }
    }
}