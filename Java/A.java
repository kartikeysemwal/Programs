import java.util.*;

class Solution {

    static class Pair {
        long ans;
        List<Integer> indexes;

        Pair(long ans, List<Integer> indexes) {
            this.ans = ans;
            this.indexes = indexes;
        }

        Pair copy() {
            Pair pair = new Pair(ans, new ArrayList<>(indexes));
            return pair;
        }
    }

    Pair findBetter(Pair ans1, Pair ans2) {
        if (ans1.ans < ans2.ans) {
            return ans2;
        } else if (ans1.ans > ans2.ans) {
            return ans1;
        } else {
            Collections.sort(ans1.indexes);
            Collections.sort(ans2.indexes);

            List<Integer> al1 = ans1.indexes;
            List<Integer> al2 = ans2.indexes;

            for (int i = 0; i < Math.min(al1.size(), al2.size()); i++) {
                if (al1.get(i) < al2.get(i)) {
                    return ans1;
                } else if (al2.get(i) < al1.get(i)) {
                    return ans2;
                }
            }

            if (al1.size() < al2.size()) {
                return ans1;
            }

            return ans2;
        }
    }

    int find(List<List<Integer>> intervals, List<Integer> al, int val) {
        int start = 0;
        int end = al.size() - 1;
        int ans = al.size();

        while (start <= end) {
            int mid = (start + end) / 2;
            int midIndex = al.get(mid);
            int midVal = intervals.get(midIndex).get(0);

            if (midVal == val) {
                ans = mid;
                end = mid - 1;
            } else if (midVal < val) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    Pair dp[][];

    Pair solve(List<List<Integer>> intervals, List<Integer> sorted, int sortIndex, int done) {
        if (done >= 4 || sortIndex >= intervals.size()) {
            return new Pair(0, new ArrayList<>());
        }

        if (dp[sortIndex][done] != null) {
            return dp[sortIndex][done].copy();
        }

        // don't include this
        Pair ans1 = solve(intervals, sorted, sortIndex + 1, done);

        int index = sorted.get(sortIndex);

        // include this
        List<Integer> interval = intervals.get(index);

        Pair ans2 = solve(intervals, sorted, find(intervals, sorted, interval.get(1) + 1), done + 1);
        ans2.ans = ans2.ans + interval.get(2);
        ans2.indexes.add(index);

        return dp[sortIndex][done] = findBetter(ans1, ans2).copy();
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        dp = new Pair[n][4];

        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(i);
        }

        Collections.sort(al, (a, b) -> {
            return intervals.get(a).get(0) - intervals.get(b).get(0);
        });

        Pair ans = solve(intervals, al, 0, 0);

        Collections.sort(ans.indexes);

        int ansArr[] = new int[ans.indexes.size()];
        for (int i = 0; i < ans.indexes.size(); i++) {
            ansArr[i] = ans.indexes.get(i);
        }

        return ansArr;
    }
}