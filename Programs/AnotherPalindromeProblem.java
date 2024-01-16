import java.util.*;

public class AnotherPalindromeProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        loop: for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            ArrayList<Integer> al;
            for (int i = 0; i < n; i++) {
                int current = sc.nextInt();
                al = new ArrayList<>();
                if (map.containsKey(current)) {
                    al = map.get(current);
                }
                al.add(i);
                map.put(current, al);
            }

            for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() >= 3) {
                    System.out.println("YES");
                    continue loop;
                }
                al = entry.getValue();
                if (al.size() == 2 && al.get(0) != al.get(1) - 1) {
                    System.out.println("YES");
                    continue loop;
                }
            }
            System.out.println("NO");
        }
    }
}