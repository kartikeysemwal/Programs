import java.util.*;

public class SortTheStrings {

    public static void swapValues(String arr[][], int index1, int index2, int length) {
        for (int i = 0; i < length; i++) {
            String temp = arr[index1][i];
            arr[index1][i] = arr[index2][i];
            arr[index2][i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        // First string to find out the number of columns
        String str = sc.nextLine();
        String splitString[] = str.split(" ");

        int length = splitString.length;

        String arr[][] = new String[n][length];
        for (int i = 0; i < length; i++) {
            arr[0][i] = splitString[i];
        }

        for (int i = 1; i < n; i++) {
            str = sc.nextLine();
            splitString = str.split(" ");
            for (int j = 0; j < length; j++) {
                arr[i][j] = splitString[j];
            }
        }
        int column = sc.nextInt();
        boolean reversed = sc.nextBoolean();
        String comparisonType = sc.next();

        if (comparisonType.equals("numeric")) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n - i; j++) {
                    int a = Integer.valueOf(arr[j - 1][column - 1]);
                    int b = Integer.valueOf(arr[j][column - 1]);
                    if (a > b) {
                        swapValues(arr, j - 1, j, length);
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n - 1; j++) {
                    String a = arr[j - 1][column - 1];
                    String b = arr[j][column - 1];
                    if (b.compareTo(a) < 0) {
                        swapValues(arr, j - 1, j, length);
                    }
                }
            }
        }

        if (!reversed) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}