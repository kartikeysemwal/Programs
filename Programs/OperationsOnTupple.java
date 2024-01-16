import java.util.*;

public class OperationsOnTupple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            long initial[] = new long[3];
            long fin[] = new long[3];

            for (int i = 0; i < 3; i++) {
                initial[i] = sc.nextLong();
            }
            for (int i = 0; i < 3; i++) {
                fin[i] = sc.nextLong();
            }

            long diff[] = new long[3];
            long sum = 0;
            for (int i = 0; i < 3; i++) {
                diff[i] = fin[i] - initial[i];
                sum += diff[i];
            }
            // If it can be done in zero operations
            if (sum == 0) {
                System.out.println("0");
                continue;
            }
            // If it can be done in 1 operations
            // Either add or multiply
            // First check for add
            boolean sameDiff = true;
            if (diff[0] != 0 && diff[1] != 0 && diff[0] != diff[1]) {
                sameDiff = false;
            }
            if (diff[0] != 0 && diff[2] != 0 && diff[0] != diff[2]) {
                sameDiff = false;
            }
            if (diff[1] != 0 && diff[2] != 0 && diff[1] != diff[2]) {
                sameDiff = false;
            }
            if (sameDiff) {
                System.out.println("1");
                continue;
            }

            // Now check for multiply
            if (!((initial[0] == 0 && diff[0] != 0)
                    || (initial[1] == 0 && diff[1] != 0) && initial[2] == 0 && diff[2] != 0)) {
                boolean run = true;
                long factor[] = new long[3];
                for (int i = 0; i < 3; i++) {
                    if (diff[i] == 0 || initial[i] == 0) {
                        continue;
                    }
                    double divide = (double) fin[i] / initial[i];
                    int divideInt = (int) divide;
                    if (divide == divideInt) {
                        factor[i] = divideInt;
                    } else {
                        run = false;
                    }
                }
                if (run) {
                    boolean sameFactor = true;
                    if (diff[0] != 0 && diff[1] != 0 && factor[0] != factor[1]) {
                        sameFactor = false;
                    }
                    if (diff[0] != 0 && diff[2] != 0 && factor[0] != factor[2]) {
                        sameFactor = false;
                    }
                    if (diff[1] != 0 && diff[2] != 0 && factor[1] != factor[2]) {
                        sameFactor = false;
                    }
                    if (sameFactor) {
                        System.out.println("1");
                        continue;
                    }
                }
            }

            // Now check for two operations addtion and multiplication
        }
    }
}