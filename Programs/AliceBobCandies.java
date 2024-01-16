import java.util.*;

public class AliceBobCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();
                q.add(cur);
            }
            int move = 0;
            int alice = 0;
            int bob = 0;
            int alicePrev = 0;
            int bobPrev = 0;
            boolean firstTime = true;
            while (q.size() > 0) {
                if (!firstTime) {
                    move++;
                    int aliceCurrent = 0;
                    while (q.size() > 0 && aliceCurrent <= bobPrev) {
                        int remove = q.removeFirst();
                        alice += remove;
                        aliceCurrent += remove;
                    }
                    alicePrev = aliceCurrent;
                }
                if (firstTime) {
                    move++;
                    alicePrev = q.removeFirst();
                    alice += alicePrev;
                    firstTime = false;
                }
                int bobCurrent = 0;
                while (q.size() > 0 && bobCurrent <= alicePrev) {
                    // move++;
                    int remove = q.removeLast();
                    bob += remove;
                    bobCurrent += remove;
                }
                if (bobCurrent != 0) {
                    move++;
                }
                bobPrev = bobCurrent;
            }
            // System.out.println(move + " " + alice + " " + bob);
            sb.append(move + " " + alice + " " + bob).append("\n");
        }
        System.out.print(sb);
    }
}