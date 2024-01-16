import java.util.*;

public class FrogJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < testCases; t++) {
            String s = sc.nextLine();
            int count = 1;
            int max = 1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'L') {
                    count++;
                    max = Integer.max(max, count);
                } else if (s.charAt(i) == 'R') {
                    count = 1;
                }
            }
            System.out.println(max);
        }
    }
}