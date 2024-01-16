import java.util.*;

public class SpecialPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            if (n < 4) {
                sb.append("-1").append("\n");
                continue;
            }
            Deque<Integer> q = new ArrayDeque<>();
            q.add(3);
            q.add(1);
            q.add(4);
            q.add(2);
            int turn = 0;
            for (int i = 5; i <= n; i++) {
                if (turn == 0) {
                    q.addFirst(i);
                } else {
                    q.addLast(i);
                }
                turn = turn ^ 1;
            }
            while (q.size() > 0) {
                sb.append(q.removeFirst() + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}