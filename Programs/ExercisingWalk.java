import java.util.*;

public class ExercisingWalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        first: for (int t = 0; t < testCases; t++) {
            long left = sc.nextLong();
            long right = sc.nextLong();
            long down = sc.nextLong();
            long up = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();

            // Current position is x y
            // Right walk relates to left walk
            // Up walk relates to down walk
            long spaceHor = (right - left);
            long spaceVer = (up - down);

            if (spaceHor == 0 && left != 0 && right != 0 && !((x - x1) >= 1 || (x2 - x) >= 1)) {
                // 1 space is needed on any side
                System.out.println("No");
                continue first;
            } else if (spaceHor < 0 && (x - x1) < Math.abs(spaceHor)) {
                // We need a space of spaceHor on the left side
                System.out.println("No");
                continue first;
            } else if (spaceHor > 0 && (x2 - x) < Math.abs(spaceHor)) {
                System.out.println("No");
                continue first;
            }

            if (spaceVer == 0 && down != 0 && up != 0 && !((y - y1) >= 1 || (y2 - y) >= 1)) {
                // 1 space is needed on any side
                System.out.println("No");
                continue first;
            } else if (spaceVer < 0 && (y - y1) < Math.abs(spaceVer)) {
                // We need a space of spaceVer on the down side
                System.out.println("No");
                continue first;
            } else if (spaceVer > 0 && (y2 - y) < Math.abs(spaceVer)) {
                System.out.println("No");
                continue first;
            }

            System.out.println("Yes");
        }
    }
}