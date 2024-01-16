import java.util.*;

public class Candies {
    static int arr[] = new int[30];

    static void preCompute() {
        for (int i = 2; i < 30; i++) {
            arr[i] = (int) Math.pow(2, i) - 1;
        }
    }

    public static void main(String[] args) {
        preCompute();
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            second: for (int i = 2; i < 30; i++) {
                if (n % arr[i] == 0) {
                    sb.append(n / arr[i]).append("\n");
                    break second;
                }
            }
        }
        System.out.print(sb);
    }
}