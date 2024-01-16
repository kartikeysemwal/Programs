import java.util.*;

public class AlternatingSubsequeces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            al.add(sc.nextInt());
            for (int i = 1; i < n; i++) {
                int cur = sc.nextInt();
                int prev = al.get(al.size() - 1);
                if ((cur < 0 && prev < 0) || (cur > 0 && prev > 0)) {
                    if (cur > prev) {
                        al.remove(al.size() - 1);
                        al.add(cur);
                    } else if (cur > prev) {
                        al.remove(al.size() - 1);
                        al.add(cur);
                    }
                } else {
                    al.add(cur);
                }
            }
            long sum = 0;
            for (int a : al) {
                sum += a;
            }
            System.out.println(sum);
        }
    }
}