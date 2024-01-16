import java.util.*;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean firstRow = true;
        boolean lastRow = false;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                if (firstRow) {
                    System.out.print("*");
                    for (int j = 1; j < n; j++) {
                        if (j < n / 2) {
                            System.out.print(" ");
                        } else {
                            System.out.print("*");
                        }
                    }
                    firstRow = false;
                } else {
                    for (int j = 0; j < n; j++) {
                        if (j == 0 || j == n / 2) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            } else if (i == n / 2) {
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else if (i > n / 2) {
                if (!lastRow) {
                    for (int j = 0; j < n; j++) {
                        if (j == n - 1 || j == n / 2) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                } else {
                    for (int j = 0; j < n - 1; j++) {
                        if (j <= n / 2) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("*");
                    lastRow = false;
                }
                System.out.println();
            }
            if (i == n - 2) {
                lastRow = true;
            }
        }
    }
}