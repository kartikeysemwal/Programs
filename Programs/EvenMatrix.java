import java.util.*;

class EvenMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            if (n % 2 != 0) {
                int prev = 0;
                for (int i = 1; i <= n; i++) {
                    int start = prev + 1;
                    for (int j = start; j < start + n; j++) {
                        // System.out.print(j + " ");
                        sb.append(j + " ");
                    }
                    prev = i * n;
                    // System.out.println();
                    sb.append("\n");
                }
            } else {
                int prev = 0;
                for (int i = 1; i <= n; i++) {
                    int start = prev + 1;
                    if (i % 2 != 0) {
                        for (int j = start; j < start + n; j++) {
                            // System.out.print(j + " ");
                            sb.append(j + " ");
                        }
                    } else {
                        for (int j = start + n - 1; j >= start; j--) {
                            // System.out.print(j + " ");
                            sb.append(j + " ");
                        }
                    }
                    prev = i * n;
                    // System.out.println();
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}