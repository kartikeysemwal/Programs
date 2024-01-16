import java.util.*;

class HouseAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        PriorityQueue<Integer> pq;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int b = sc.nextInt();

            pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                int current = sc.nextInt();
                pq.add(current);
            }
            int count = 0;
            while (!pq.isEmpty()) {
                int remove = pq.poll();
                if (b - remove >= 0) {
                    b -= remove;
                    count++;
                } else {
                    break;
                }
            }
            // System.out.println("Case #" + (t + 1) + ": " + count);
            sb.append("Case #" + (t + 1) + ": " + count).append("\n");
        }
        System.out.print(sb);
    }
}