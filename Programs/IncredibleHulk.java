import java.util.*;

public class IncredibleHulk {
    static int powerOfTwo[] = new int[18];

    static void calc() {
        powerOfTwo[0] = 1;
        for (int i = 1; i < powerOfTwo.length; i++) {
            powerOfTwo[i] = powerOfTwo[i - 1] * 2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        calc();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int index = -1;
            int steps = 0;
            while (n != 0) {
                for (int i = 0; i < powerOfTwo.length; i++) {
                    if (n < powerOfTwo[i]) {
                        break;
                    } else if (n == powerOfTwo[i]) {
                        index = i;
                    }
                    index = i;
                }
                if (n % powerOfTwo[index] == 0) {
                    n = 0;
                    steps++;
                    break;
                }
                n = n - powerOfTwo[index];
                steps++;
            }
            System.out.println(steps);
        }
    }
}