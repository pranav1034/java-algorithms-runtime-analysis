public class CompareFibonacciApproaches {

    // Recursive Fibonacci (O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int N = 30; // Change this to test different values

        long start, end;

        // Measure Recursive Fibonacci (Only up to small N to avoid long execution)
        if (N <= 30) { // Prevent long execution time
            start = System.nanoTime();
            int fibRec = fibonacciRecursive(N);
            end = System.nanoTime();
            System.out.println("Recursive Fibonacci (" + N + ") = " + fibRec +
                    " | Time: " + (end - start) / 1000000.0 + " ms");
        } else {
            System.out.println("Recursive Fibonacci (" + N + ") is infeasible.");
        }

        // Measure Iterative Fibonacci
        start = System.nanoTime();
        int fibIter = fibonacciIterative(N);
        end = System.nanoTime();
        System.out.println("Iterative Fibonacci (" + N + ") = " + fibIter +
                " | Time: " + (end - start) / 1000000.0 + " ms");
    }
}
