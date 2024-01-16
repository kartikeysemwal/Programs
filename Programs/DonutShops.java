import java.util.*;

public class DonutShops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (1 * a < Math.ceil((double) 1 / b) * (long) c) {
                sb.append("1 ");
            } else {
                sb.append("-1 ");
            }
            if (b * (long) a > Math.ceil(1 * c)) {
                sb.append(b + " ");
            } else {
                sb.append("-1 ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}