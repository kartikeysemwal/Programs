import java.util.*;

public class MagicalPark {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int s = sc.nextInt();
        sc.nextLine();
        String arr[][] = new String[n][m];

        String current;

        first: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                current = sc.next();
                if (current.equals(".")) {
                    s -= 2;
                } else if (current.equals("*")) {
                    s += 5;
                } else {
                    j++;
                    while (j < m) {
                        sc.next();
                        j++;
                    }
                }
                if (j < m - 1) {
                    s -= 1;
                }
                if (s < k) {
                    System.out.println("No");
                    for (; i < n; i++) {
                        sc.nextLine();
                    }
                    break first;
                }
            }
            if (i != n - 1) {
                sc.nextLine();
            }
        }
        if (s >= k) {
            System.out.println("Yes");
            System.out.println(s);
        }
    }
}
