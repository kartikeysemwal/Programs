import java.util.*;

public class TetrisProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            int odd = 0;
            int even = 0;

            for (int i = 0; i < n; i++) {
                int current = sc.nextInt();
                if (current % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            if (odd != 0 && even != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}