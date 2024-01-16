import java.util.*;

public class LowerBoundUpperBound {
    static int lowerBound(int arr[], int start, int end, int n, long key) {
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                end = mid - 1;
                ans = mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                ans = mid;
                end = mid + 1;
            }
        }
        return ans;
    }

    static int upperBound(long result[], int start, int end, int n, long key) {
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (result[mid] == key) {
                start = mid + 1;
                ans = mid;
            } else if (result[mid] > key) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}