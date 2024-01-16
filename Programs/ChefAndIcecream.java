import java.util.*;

class ChefAndIcecream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        HashMap<Integer, Integer> map;
        first: for (int t = 0; t < testCases; t++) {
            map = new HashMap<>();
            map.put(5, 0);
            map.put(10, 0);
            map.put(15, 0);

            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt() - 5;
                if (cur == 0) {
                    map.put(5, map.get(5) + 1);
                    continue;
                }
                if (cur == 5) {
                    int val = map.get(5);
                    if (val >= 1) {
                        val--;
                        map.put(5, val);
                        map.put(10, map.get(10) + 1);
                        continue;
                    }
                    i = i + 1;
                    for (; i < n; i++) {
                        sc.nextInt();
                    }
                    System.out.println("NO");
                    continue first;
                } else if (cur == 10) {
                    int val10 = map.get(10);
                    if (val10 >= 1) {
                        val10--;
                        map.put(10, val10);
                        continue;
                    }
                    int val5 = map.get(5);
                    if (val5 >= 2) {
                        val5 -= 2;
                        map.put(5, val5);
                        continue;
                    }
                    i = i + 1;
                    for (; i < n; i++) {
                        sc.nextInt();
                    }
                    System.out.println("NO");
                    continue first;
                }
            }
            System.out.println("YES");
        }
    }
}