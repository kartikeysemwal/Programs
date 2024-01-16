import java.util.*;

class ChefAndString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < testCases; t++) {
            String str = sc.nextLine();
            char arr[] = str.toCharArray();
            int length = str.length();
            long ans = 0;
            for (int i = 1; i < length; i++) {
                if (arr[i] != arr[i - 1]) {
                    ans++;
                    i++;
                }
            }
            System.out.println(ans);
        }
    }
}