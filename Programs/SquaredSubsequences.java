import java.util.*;

class SquaredSubsequences {

    static long findSubarraySum(int arr[], int n, int sum) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        long res = 0;
        int currsum = 0;

        for (int i = 0; i < n; i++) {
            currsum += arr[i];
            if (currsum == sum)
                res++;
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }
        return res;
    }

    static int countExponent(int n) {
        int ans = 0;
        if (n == 0) {
            return 0;
        }
        while (n % 2 == 0) {
            ans++;
            n = n / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();
                arr[i] = countExponent(cur);
            }
            long total = ((long) n * n + n) / 2;
            long res = findSubarraySum(arr, n, 1);
            sb.append(total - res).append("\n");
            // System.out.println(total - res);
        }
        System.out.print(sb);
    }
}
