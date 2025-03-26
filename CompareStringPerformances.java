public class CompareStringPerformances {
    public static void main(String[] args) {
        int N = 100000; // Number of concatenations
        long start, end;

        // Using String (Inefficient)
        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str += "a"; // Creates a new object each time (O(N²))
        }
        end = System.nanoTime();
        System.out.println("String Concatenation took: " + (end - start) / 1000000.0 + " ms");

        // Using StringBuilder (Efficient)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a"); // Mutable, O(N)
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Concatenation took: " + (end - start) / 1000000.0 + " ms");

        // Using StringBuffer (Thread-Safe, Slightly Slower)
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a"); // Thread-safe, O(N)
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Concatenation took: " + (end - start) / 1000000.0 + " ms");
    }
}
