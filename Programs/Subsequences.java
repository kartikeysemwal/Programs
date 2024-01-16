import java.util.*;

public class Subsequences {
    public static long taskOfPairing(List<Long> freq) {
        // Write your code here
        long pair = 0;
        Iterator<Long> it = freq.iterator();
        int left = 0;
        while (it.hasNext()) {
            long cur = it.next();
            pair += (cur + left) / 2;
            if (left == 1 && cur % 2 != 0) {
                left = 0;
                continue;
            }
            left = (int) cur % 2;
        }
        return pair;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
    }
}