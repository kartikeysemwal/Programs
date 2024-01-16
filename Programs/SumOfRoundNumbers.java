import java.util.*;

public class SumOfRoundNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int cur = sc.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            int mul = 1;
            while (cur > 0) {
                int x = cur % 10 * mul;
                if (x != 0) {
                    al.add(x);
                }
                mul *= 10;
                cur = cur / 10;
            }
            sb.append(al.size()).append("\n");
            for (int i = 0; i < al.size(); i++) {
                sb.append(al.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}