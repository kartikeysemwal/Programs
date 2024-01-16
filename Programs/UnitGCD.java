import java.util.*;

class UnitGCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int d = n / 2;
            if (n == 1) {
                sb.append("1").append("\n");
                sb.append("1 1").append("\n");
                continue;
            }
            sb.append(d).append("\n");
            if (n % 2 == 1) {
                sb.append("3 1 2 " + n).append("\n");
                for (int i = 3; i < n - 1; i += 2) {
                    sb.append("2 " + i + " " + (i + 1)).append("\n");
                }
            } else {
                // sb.append("2 1 2").append("\n");
                for (int i = 1; i < n; i += 2) {
                    sb.append("2 " + i + " " + (i + 1)).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}