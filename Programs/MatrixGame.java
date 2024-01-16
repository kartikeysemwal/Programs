import java.util.*;

public class MatrixGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int arr[][] = new int[r][c];

            int max = Integer.max(r, c);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int cur = sc.nextInt();
                    arr[i][j] = cur;
                }
            }
            int arrCountRow[] = new int[r];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arrCountRow[i] += arr[i][j];
                }
            }
            int arrCountCol[] = new int[c];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    arrCountCol[i] += arr[j][i];
                }
            }
            int countRow = 0;
            for (int i = 0; i < arrCountRow.length; i++) {
                if (arrCountRow[i] == 0) {
                    countRow++;
                }
            }
            int countCol = 0;
            for (int i = 0; i < arrCountCol.length; i++) {
                if (arrCountCol[i] == 0) {
                    countCol++;
                }
            }
            int count = Math.min(countRow, countCol);
            if (count % 2 == 0) {
                System.out.println("Vivek");
            } else {
                System.out.println("Ashish");
            }
        }
    }
}