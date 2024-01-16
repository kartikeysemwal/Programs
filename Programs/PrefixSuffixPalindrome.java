import java.util.*;

public class PrefixSuffixPalindrome {
    static int kmp(String s) {
        int n = s.length();
        char str[] = s.toCharArray();
        int lps[] = new int[n]; // Longest proper suffix which is also prefix
        for (int i = 1; i < n; i++) {
            int prevIndex = lps[i - 1];
            while (prevIndex > 0 && str[i] != str[prevIndex]) {
                prevIndex = lps[prevIndex - 1];
            }
            lps[i] = prevIndex + (str[i] == str[prevIndex] ? 1 : 0);
        }
        return lps[n - 1];
    }

    static int largestPrePal(String s) {
        String t = s + "?";
        s = new StringBuilder(s).reverse().toString();
        t += s;
        return kmp(t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            String str = sc.nextLine();
            int n = str.length();

            char arr[] = str.toCharArray();
            int l = 0;
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                if (arr[i] == arr[j]) {
                    l++;
                } else {
                    break;
                }
            }

            String rem = str.substring(l, n - l);
            String ans = str.substring(0, l);

            if (rem.length() > 0) {
                int l_pre = largestPrePal(rem);
                rem = new StringBuilder(rem).reverse().toString();
                int l_suff = largestPrePal(rem);

                if (l_pre > l_suff) {
                    rem = new StringBuilder(rem).reverse().toString();
                    ans += rem.substring(0, l_pre);
                } else {
                    ans += rem.substring(0, l_suff);
                }
            }
            ans += str.substring(n - l, n);
            // System.out.println(ans);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}