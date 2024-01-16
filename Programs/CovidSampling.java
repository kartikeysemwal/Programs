import java.util.*;

class CovidSampling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = sc.nextInt();
            int P = sc.nextInt();

            int arr[][] = new int[N][N];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.println("1 " + i + " " + j + " " + i + " " + j);
                    arr[i - 1][j - 1] = sc.nextInt();
                }
            }
            System.out.println("2");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            int ans = sc.nextInt();
            if (ans == -1) {
                break;
            }
        }
    }
}