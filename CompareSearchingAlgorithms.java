import java.util.Arrays;
import java.util.Random;

public class CompareSearchingAlgorithms {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();

        for (int size : sizes) {
            int[] data = new int[size];

            // Generate random numbers
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }

            int target = data[random.nextInt(size)]; // Pick a random target

            // Linear Search
            long start = System.nanoTime();
            linearSearch(data, target);
            long end = System.nanoTime();
            System.out.println("Linear Search Time for " + size + " elements: " + (end - start) / 1000000.0 + " ms");

            // Binary Search (requires sorting)
            Arrays.sort(data);
            start = System.nanoTime();
            binarySearch(data, target);
            end = System.nanoTime();
            System.out.println("Binary Search Time for " + size + " elements: " + (end - start) / 1000000.0 + " ms");
        }
    }

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
