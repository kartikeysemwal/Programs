import java.util.*;

public class SpecialElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n + 1];
            int isSpecial[] = new int[n + 1];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int sum = arr[i];

                for (int j = i + 1; j < n; j++) {
                    sum += arr[j];
                    if (sum > n) {
                        break;
                    }
                    isSpecial[sum] = 1;
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (isSpecial[arr[i]] == 1) {
                    ans++;
                }
            }
            // System.out.println(ans);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}