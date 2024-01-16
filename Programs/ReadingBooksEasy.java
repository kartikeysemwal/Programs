import java.util.*;

public class ReadingBooksEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        LinkedList<Integer> both = new LinkedList<>();
        LinkedList<Integer> alice = new LinkedList<>();
        LinkedList<Integer> bob = new LinkedList<>();
        LinkedList<Integer> noone = new LinkedList<>();
        HashMap<String, LinkedList<Integer>> set = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            String s = String.valueOf(t) + String.valueOf(a) + String.valueOf(b);
            LinkedList<Integer> ll = set.get(s);
            if (ll == null) {
                ll = new LinkedList<>();
            }
            ll.add(i + 1);
            set.put(s, ll);

            if (a == 1 && b == 1) {
                both.add(t);
                continue;
            }
            if (a == 1 && b == 0) {
                alice.add(t);
                continue;
            }
            if (a == 0 && b == 1) {
                bob.add(t);
                continue;
            }
            noone.add(t);
        }
        int cboth = both.size();
        int calice = alice.size();
        int cbob = bob.size();

        if (cboth + calice < k || cboth + cbob < k) {
            System.out.println("-1");
            return;
        }
        Collections.sort(both);
        Collections.sort(alice);
        Collections.sort(bob);
        int count = k;
        long ans = 0;
        int max = Integer.MAX_VALUE;
        while (count != 0) {
            int bv = max;
            if (!both.isEmpty())
                bv = both.get(0);
            int ab = max;
            if (!alice.isEmpty() && !bob.isEmpty())
                ab = alice.get(0) + bob.get(0);
            if ((ab <= bv && m != 1) || (ab != max && m == 2 && both.size() < 2)) {
                int a = alice.remove(0);
                int b = bob.remove(0);
                ans += a + b;
                String s = String.valueOf(a) + String.valueOf("10");
                LinkedList<Integer> ll = set.get(s);
                int index = ll.remove(0);
                set.put(s, ll);
                sb.append(index + " ");
                s = String.valueOf(b) + String.valueOf("01");
                ll = set.get(s);
                index = ll.remove(0);
                set.put(s, ll);
                sb.append(index + " ");
                m -= 2;
                count--;
            } else {
                if (both.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                int a = both.remove(0);
                ans += a;
                String s = String.valueOf(a) + String.valueOf("11");
                LinkedList<Integer> ll = set.get(s);
                int index = ll.remove(0);
                set.put(s, ll);
                sb.append(index + " ");
                count--;
                m--;
            }
        }
        if (m > 0) {
            Collections.sort(noone);
        }
        while (m > 0) {
            int bv = max;
            if (!both.isEmpty())
                bv = both.get(0);
            int al = max;
            if (!alice.isEmpty()) {
                al = alice.get(0);
            }
            int bb = max;
            if (!bob.isEmpty()) {
                bb = bob.get(0);
            }
            int nn = max;
            if (!noone.isEmpty()) {
                nn = noone.get(0);
            }
            int min = getMin(bv, al, bb, nn);
            if (bv == min) {
                int a = both.remove(0);
                ans += a;
                String s = String.valueOf(a) + String.valueOf("11");
                LinkedList<Integer> ll = set.get(s);
                int index = ll.remove(0);
                set.put(s, ll);
                sb.append(index + " ");
                m--;
            } else if (al == min) {
                int a = alice.remove(0);
                ans += a;
                String s = String.valueOf(a) + String.valueOf("10");
                LinkedList<Integer> ll = set.get(s);
                int index = ll.remove(0);
                set.put(s, ll);
                sb.append(index + " ");
                m--;
            } else if (bb == min) {
                int a = bob.remove(0);
                ans += a;
                String s = String.valueOf(a) + String.valueOf("01");
                LinkedList<Integer> ll = set.get(s);
                int index = ll.remove(0);
                set.put(s, ll);
                sb.append(index + " ");
                m--;
            } else if (nn == min) {
                int a = noone.remove(0);
                ans += a;
                String s = String.valueOf(a) + String.valueOf("00");
                LinkedList<Integer> ll = set.get(s);
                int index = ll.remove(0);
                set.put(s, ll);
                sb.append(index + " ");
                m--;
            }
        }
        System.out.println(ans);
        System.out.println(sb);
    }

    static int getMin(int a, int b, int c, int d) {
        return Math.min(Math.min(Math.min(a, b), c), d);
    }
}