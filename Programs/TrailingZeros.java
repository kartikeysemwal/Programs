import java.util.*;

public class TrailingZeros {
    public static void trailingZeros(int n) {
        int ans = 0;
        for (int i = 1; Math.pow(5, i) <= n; i++) {
            ans += Math.floorDiv(n, (int) Math.pow(5, i));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        trailingZeros(n);
    }
}