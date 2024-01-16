import java.util.*;

public class TroubleSort {
    static boolean arraySortedOrNot(int arr[], int n) {
        if (n == 0 || n == 1)
            return true;

        for (int i = 1; i < n; i++)
            if (arr[i - 1] > arr[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            int arrOrg[] = new int[n];
            int typeOrg[] = new int[n];
            for (int i = 0; i < n; i++) {
                arrOrg[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                typeOrg[i] = sc.nextInt();
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += typeOrg[i];
            }
            String ans = "";
            if (sum == 0 || sum == n) {
                boolean res = arraySortedOrNot(arrOrg, n);
                if (res) {
                    ans = "YES";
                } else {
                    ans = "No";
                }
            } else {
                // ArrayList<Integer> arr0 = new ArrayList<>();
                // ArrayList<Integer> arr1 = new ArrayList<>();

                // boolean find = false;

                // for (int i = 0; i < n; i++) {
                // int cur = arrOrg[i];
                // int type = typeOrg[i];

                // if (type == 0 && find != true) {
                // if (arr0.size() > 0) {
                // if (cur < arr0.get(arr0.size() - 1)) {
                // find = true;
                // ans = "NO";
                // }
                // }
                // arr0.add(cur);
                // }
                // if (type == 1 && find != true) {
                // if (arr1.size() > 0) {
                // if (cur < arr1.get(arr1.size() - 1)) {
                // find = true;
                // ans = "NO";
                // }
                // }
                // arr1.add(cur);
                // }
                // }
                // if (!find) {
                // ans = "YES";
                // }
                ans = "YES";
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}