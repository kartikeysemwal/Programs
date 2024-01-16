import java.util.*;

public class E1 {
    public static int upperBound(int result[], int n, int key) {
        int s = 0, e = n - 1;
        int ans = n;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (result[mid] == key) {
                s = mid + 1;
            } else if (result[mid] > key) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int p = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        List<Integer> al = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = arr[n - 1];
        int min = max - n + 1;
        for (int x = min; x < max; x++) {
            int flag = 1;
            for (int i = 0; i < n; i++) {
                int fx = -1;
                if (map.containsKey(x + i)) {
                    fx = map.get(x + i);
                } else {
                    fx = upperBound(arr, n, x + i);
                    map.put(x + i, fx);
                }
                fx = fx - i;
                if (fx % p == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                al.add(x);
            }
        }
        sb.append(al.size()).append("\n");
        for (int i = 0; i < al.size(); i++) {
            sb.append(al.get(i) + " ");
        }
        System.out.print(sb);
    }
}