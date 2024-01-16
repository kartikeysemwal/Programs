import java.util.*;

public class HelpRahul {
    public static int binarySearch(int arr[], int begin, int end, int toFind, int length) {
        if (begin == end && arr[begin % length] != toFind) {
            return -1;
        }
        int index = (begin + end) / 2;
        if (arr[index % length] == toFind) {
            return index % length;
        } else if (arr[index % length] > toFind) {
            return binarySearch(arr, begin, index - 1, toFind, length);
        } else {
            return binarySearch(arr, index + 1, end, toFind, length);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        int toFind = sc.nextInt();

        int newLength = n + index - 1;
        System.out.println(binarySearch(arr, index, newLength, toFind, arr.length));
    }
}