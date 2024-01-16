import java.util.*;

public class MaxGCD {
    public static int findGCD(int n) {
        int high = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        high = n;
        int count[] = new int[high + 1];
        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        int counter = 0;
        for (int i = high; i >= 1; i--) {
            int j = i;
            while (j <= high) {
                if (count[j] > 0)
                    counter += count[j];
                j += i;
                if (counter == 2)
                    return i;
            }
            counter = 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            System.out.println(findGCD(n));
        }
    }
}