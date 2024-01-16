import java.util.*;

class Plates {

    public static int solve(int N, int K, int P, int arr[][], int currentOfStack[]) {
        if (P == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (currentOfStack[i] >= K) {
                continue;
            }
            currentOfStack[i]++;
            ans = Math.max(ans, arr[i][currentOfStack[i] - 1] + solve(N, K, P - 1, arr, currentOfStack));
            currentOfStack[i]--;
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int P = sc.nextInt();

            int arr[][] = new int[N][K];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < K; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int currentOfStack[] = new int[N];
            // System.out.println(solve(N, K, P, arr, currentOfStack));
            sb.append("Case #" + (t + 1) + ": " + solve(N, K, P, arr, currentOfStack)).append("\n");
        }
        System.out.print(sb);
    }
}

// import java.util.*;

// class Plates {
// static int N, K, P;
// static int pre[][];
// static int cache[][];

// // static int a[][] = new int[N][31];

// static int solve(int idx, int taken) {
// if (taken == P) {
// return 0;
// }
// if (taken > P || idx > N) {
// return Integer.MIN_VALUE;
// }
// if (cache[idx][taken] != 0) {
// return cache[idx][taken];
// }
// int ans = Integer.MIN_VALUE;
// for (int i = 0; i <= K; i++) {
// ans = Math.max(ans, pre[idx][i] + solve(idx + 1, taken + i));
// }
// return cache[idx][taken] = ans;
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int testCases = sc.nextInt();

// StringBuilder sb = new StringBuilder();

// for (int t = 0; t < testCases; t++) {
// N = sc.nextInt();
// K = sc.nextInt();
// P = sc.nextInt();

// pre = new int[N + 1][31];
// cache = new int[N + 1][P];

// for (int i = 1; i <= N; i++) {
// for (int j = 1; j <= K; j++) {
// pre[i][j] = sc.nextInt() + pre[i][j - 1];
// }
// }
// sb.append("Case #" + (t + 1) + ": " + solve(1, 0)).append("\n");
// }
// System.out.print(sb);
// }
// }
