import java.util.*;

public class CountBits {
    // Time complexity
    // It will iterate over all the bits give time complexity of O(logN)
    static int countBits(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n & 1;
            n = n >> 1;
        }
        return ans;
    }

    // This method works from right to left
    // It will iterate only for the set bits so time complexity O(n of set bits)
    static int countBitsFast(int n) {
        int ans = 0;
        while (n > 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countBits(n));
        System.out.println(countBitsFast(n));
        System.out.println(Integer.bitCount(n));
    }
}