import java.util.*;

public class CompositeColoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int prime[] = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        for (int t = 0; t < testCases; t++) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();

                for (int j = 0; j < prime.length; j++) {
                    if (cur % prime[j] == 0) {
                        if (!map.containsKey(prime[j])) {
                            count++;
                            map.put(prime[j], count);
                        }
                        sb.append(map.get(prime[j])).append(" ");
                        break;
                    }
                }
            }
            System.out.println(count);
            System.out.println(sb);
        }
    }
}