import java.util.*;

class TomAndJerry {
    static int countZero(long n) {
        int count0 = 0;
        while (n != 0) {
            if (n % 2 == 0)
                count0++;
            else
                break;
            n /= 2;
        }
        return count0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            long cur = sc.nextLong();
            if (cur % 2 != 0) {
                System.out.println(cur / 2);
                continue;
            }
            System.out.println(cur >> (countZero(cur) + 1));
        }
    }
}