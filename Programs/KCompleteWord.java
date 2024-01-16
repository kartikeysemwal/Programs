import java.util.*;

public class KCompleteWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String str = " " + sc.next();
            byte str1[] = str.getBytes();
            int middle = -1;
            if (k % 2 != 0) {
                middle = (k / 2) + 1;
            }
            int count = 0;

            int length = str1.length;

            for (int i = 1; i <= k / 2; i++) {
                int cur = str1[i];
                int arrLetters[] = new int[26];
                arrLetters[cur - 'a']++;
                int max = 1;
                for (int l = 1; l <= (n / k); l++) {
                    int pos1 = l * k - i + 1;
                    int pos2 = l * k + i;
                    arrLetters[str1[pos1] - 'a']++;
                    max = Integer.max(max, arrLetters[str1[pos1] - 'a']);
                    if (pos2 < length) {
                        arrLetters[str1[pos2] - 'a']++;
                        max = Integer.max(max, arrLetters[str1[pos2] - 'a']);
                    }
                }
                int req = 2 * (n / k);
                // int max = Arrays.stream(arrLetters).max().getAsInt();
                count += req - max;
            }
            if (middle != -1) {
                int cur = str1[middle];
                int arrLetters[] = new int[26];
                arrLetters[cur - 'a']++;
                int max = 1;
                for (int l = 1; l <= (n / k); l++) {
                    int pos2 = l * k + middle;
                    if (pos2 < length) {
                        arrLetters[str1[pos2] - 'a']++;
                        max = Integer.max(max, arrLetters[str1[pos2] - 'a']);
                    }
                }
                int req = (n / k);
                // int max = Arrays.stream(arrLetters).max().getAsInt();
                count += req - max;
            }
            // System.out.println(count);
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}

// import java.util.*;

// public class KCompleteWord {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int testCases = sc.nextInt();
// StringBuilder sb = new StringBuilder();

// for (int t = 0; t < testCases; t++) {
// int n = sc.nextInt();
// int k = sc.nextInt();
// // String str1 = sc.nextLine();
// String str = " " + sc.next();
// char str1[] = str.toCharArray();
// int middle = -1;
// if (k % 2 != 0) {
// middle = (k / 2) + 1;
// }
// int count = 0;
// // Sequence is i, i-k+1, i+k, 2k+i-1, 2k+i if string is even for all
// // If string is odd i, i+k, i+2k 1<=i<=k
// int length = str1.length;
// for (int i = 1; i <= k / 2 + 1; i++) {

// char cur = str1[i];
// // This is to see whose count is maximum
// int max = 1;
// int index = i;

// int arrLetters[] = new int[124];
// arrLetters[cur]++;

// for (int l = 1; l <= (n / k); l++) {
// int pos1 = l * k - i + 1;
// int pos2 = l * k + i;

// if (middle != -1 && i == middle && pos2 < length) {
// char pos2Char = str1[pos2];
// arrLetters[pos2Char]++;
// if (arrLetters[pos2Char] > max) {
// max = arrLetters[pos2Char];
// index = pos2;
// }
// }

// if (i != middle && pos1 < length) {
// char pos1Char = str1[pos1];
// arrLetters[pos1Char]++;
// if (arrLetters[pos1Char] > max) {
// max = arrLetters[pos1Char];
// index = pos1;
// }
// }
// if (i != middle && pos2 < length) {
// char pos2Char = str1[pos2];
// arrLetters[pos2Char]++;
// if (arrLetters[pos2Char] > max) {
// max = arrLetters[pos2Char];
// index = pos2;
// }
// }
// }

// if (str1[index] != cur) {
// str1[i] = str1[index];
// count++;
// }

// cur = str1[i];

// for (int l = 1; l <= (n / k); l++) {
// int pos1 = l * k - i + 1;
// int pos2 = l * k + i;

// if (middle != -1 && i == middle && pos2 < length && str1[pos2] != cur) {
// str1[pos2] = cur;
// count++;
// continue;
// }

// if (i != middle && pos1 < length && str1[pos1] != cur) {
// str1[pos1] = cur;
// count++;
// }
// if (i != middle && pos2 < length && str1[pos2] != cur) {
// str1[pos2] = cur;
// count++;
// }
// }
// }
// // System.out.println(count);
// sb.append(count).append("\n");
// }
// System.out.print(sb);
// }
// }
