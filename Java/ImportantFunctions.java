import java.util.*;
import java.io.*;

class Tree {

    static ArrayList<Integer> al[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            al = new ArrayList[n + 1];

            for (int i = 0; i < n + 1; i++) {
                al[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                al[start].add(end);
                al[end].add(start);
            }

        }

        System.out.print(sb);
    }

}

class Graph {
    static ArrayList<Integer> al[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            al = new ArrayList[n + 1];

            for (int i = 0; i < n + 1; i++) {
                al[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                al[start].add(end);
                al[end].add(start);
            }

        }

        System.out.print(sb);
    }
}

// optimize inverse
// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/description/
class NCRWithFactorial {
    // NCR and Factorial
    static int mod = 1000000007;
    static int fact[];

    static int size = 1005;

    static long ncr(int n, int r) {

        fact = new int[size];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < size; i++) {
            fact[i] = (int) ((i * (long) fact[i - 1]) % mod);
        }

        if (r > n)
            return 0;
        return fact[n] * power(fact[r], mod - 2) % mod * power(fact[n - r], mod - 2) % mod;
    }

    static long power(long a, long b) {
        long res = 1;
        while (b != 0) {
            if (b % 2 == 1)
                res = res * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return res;
    }
}

class EuclideanAlgorithm {

    static int x;
    static int y;

    static int gcdExtended(int a, int b) {
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }
        int gcd = gcd(b % a, a);
        int x1 = x;
        int y1 = y;
        x = y1 - b / a * x1;
        y = x1;

        return gcd;
    }

    // is associative
    // gcd(a, gcd(b, c)) = gcd(gcd(a, b), c)
    static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    // is associative
    // lcm(a, lcm(b, c)) = lcm(lcm(a, b), c)
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    static void factors() {

        ArrayList<Integer> factors = new ArrayList<>();

        int n = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        // Prime factors
        // use only this method to find prime factors

        long temp = n;

        HashSet<Long> set = new HashSet<>();

        while (temp % 2 == 0) {
            temp = temp / 2;
            set.add((long) 2);
        }

        for (int i = 3; i <= Math.sqrt(temp); i = i + 2) {
            while (temp % i == 0) {
                set.add((long) i);
                temp = temp / i;
            }
        }

        if (temp > 2) {
            set.add(temp);
        }
    }

    void seiveOfEratosthenes() {
        boolean prime[] = new boolean[1005];

        Arrays.fill(prime, true);

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == false) {
                continue;
            }

            for (int j = i + i; j < prime.length; j = j + i) {
                prime[j] = false;
            }
        }
    }

    void smallestPrime() {
        int size = 1000005;

        int smallest_prime[] = new int[size];
        smallest_prime[0] = 1;
        smallest_prime[1] = 1;

        for (int i = 2; i < size; i++) {
            if (smallest_prime[i] == 0) {
                for (int j = i; j <= 1000000; j = j + i) {
                    smallest_prime[j] = i;
                }
            }
        }
    }
}

class TreeClass {

    static ArrayList<Integer> al[];

    static int jumps[][];

    // https://leetcode.com/problems/kth-ancestor-of-a-tree-node/description/

    static void binaryLifting(int cur, int par) {

        if (par != 0) {
            jumps[cur][0] = par;
            for (int i = 1; i < 20; i++) {
                if (jumps[cur][i - 1] != -1) {
                    jumps[cur][i] = jumps[jumps[cur][i - 1]][i - 1];
                } else {
                    jumps[cur][i] = -1;
                }
            }
        }
        for (int child : al[cur]) {
            if (child != par) {
                binaryLifting(child, cur);
            }
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            al = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                al[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                al[start].add(end);
                al[end].add(start);
            }
        }
        System.out.print(sb);
    }
}

class ImportantFunctions {

    static int fastExp(long x, int p, int mod) {
        long res = 1;
        x = x % mod;
        while (p > 0) {
            if (p % 2 != 0)
                res = (res * x) % mod;
            p = p / 2;
            x = (x * x) % mod;
        }
        res = res % mod;
        return (int) res;
    }

    static void subArraySum(int arr[], int n, int sum) {
        int start = 0;
        int end = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += arr[i];
            if (curSum == sum) {
                start = 1;
                end = i + 1;
                // sb.append(start + " " + end).append("\n");
            }
            int toFind = curSum - sum;
            if (map.containsKey(toFind)) {
                start = map.get(toFind) + 1 + 1;
                end = i + 1;
                // sb.append(start + " " + end).append("\n");
            }
            map.put(curSum, i);
        }
    }

    static boolean subsetSum(int arr[], int n, int sum) {
        boolean dp[][] = new boolean[sum + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
                }
            }
        }

        return dp[sum][n];
    }

    static void countDivisor() {
        int size = 1000005;
        int divisor[] = new int[size];
        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j += i) {
                divisor[j]++;
            }
        }
    }

    static int lowerBound(int arr[], int start, int end, int n, long key) {
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                end = mid - 1;
                if (ans == -1 || mid < ans) {
                    ans = mid;
                }
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static int upperBound(long arr[], int start, int end, int n, long key) {
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                start = mid + 1;
                if (ans == -1 || mid > ans) {
                    ans = mid;
                }
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static int KMPAlgorithm(char text[], int pattern[]) {

        int m = pattern.length;

        int arr[] = new int[m];
        int j = 0;
        arr[0] = 0;
        for (int i = 1; i < m; i++) {
            if (pattern[j] == pattern[i]) {
                arr[i] = j + 1;
                j++;
                continue;
            }

            while (j != 0 && pattern[j] != pattern[i]) {
                j = arr[j - 1];
            }

            if (pattern[j] == pattern[i]) {
                arr[i] = j + 1;
                j++;
                continue;
            }
            arr[i] = 0;
        }

        int n = text.length;
        j = 0;
        for (int i = 0; i < n; i++) {
            if (pattern[j] == text[i]) {
                j++;
                if (j == m) {
                    return (i - j + 1);
                }
                continue;
            }

            while (j != 0 && pattern[j] != text[i]) {
                j = arr[j - 1];
            }
            if (pattern[j] == text[i]) {
                j++;
            }
        }
        return -1;
    }

    static public boolean RabinKarp(char text[], char pat[]) {
        int n = text.length;
        int m = pat.length;

        int q = 101;

        int p = 0;
        int t = 0;
        int d = 2;
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < m; i++) {
            p = (d * p + pat[i]) % q;
            t = (d * t + text[i]) % q;
        }

        for (int i = 0; i < n - m + 1; i++) {
            if (p == t) {
                boolean found = true;
                for (int j = 0; j < m; j++) {
                    if (pat[j] != text[i + j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
            if (i < n - m) {
                t = (d * (t - text[i] * h) + text[i + m]) % q;

                t = (t + q) % q;
            }
        }
        return false;
    }

}

class TightBound {
    static int lowerBound(int arr[], int n, int key) {
        int start = 0;
        int end = n - 1;
        int index = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (key <= arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                index = mid;
                start = mid + 1;
            }
        }
        return index;
    }

    static int upperBound(int arr[], int n, int key) {
        int start = 0;
        int end = n - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key < arr[mid]) {
                index = mid;
                end = mid - 1;
            } else if (key >= arr[mid]) {
                start = mid + 1;
            }
        }
        return index;
    }
}

class LCAClass {

    static ArrayList<Integer> al[];
    static int jumps[][];
    static int level[];
    static int parent[];

    static void findLevel(int cur, int par) {
        parent[cur] = par;
        if (par != 0) {
            level[cur] = level[par] + 1;
        }
        for (int child : al[cur]) {
            if (child != par) {
                findLevel(child, cur);
            }
        }
    }

    static void binaryLifting(int cur, int par) {
        jumps[cur][0] = par;

        for (int i = 1; i < 20; i++) {
            if (jumps[cur][i - 1] != -1)
                jumps[cur][i] = jumps[jumps[cur][i - 1]][i - 1];
            else
                jumps[cur][i] = -1;
        }

        for (int child : al[cur]) {
            if (child != par) {
                binaryLifting(child, cur);
            }
        }
    }

    static int liftNode(int node, int jumpRequired) {
        if (jumpRequired == 0 || node == -1) {
            return node;
        }
        for (int i = 19; i >= 0; i--) {
            if (jumpRequired >= 1 << i) {
                jumpRequired -= (1 << i);
                node = jumps[node][i];
            }
        }
        return node;
    }

    static int lcs(int u, int v) {
        if (level[u] < level[v]) {
            v = liftNode(v, Math.abs(level[u] - level[v]));
        }
        if (level[u] > level[v]) {
            u = liftNode(u, Math.abs(level[u] - level[v]));
        }
        if (u == v) {
            return u;
        }
        for (int i = 19; i >= 0; i--) {
            if (jumps[u][i] != jumps[v][i]) {
                u = jumps[u][i];
                v = jumps[v][i];
            }
        }
        return liftNode(u, 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int q = sc.nextInt();

        al = new ArrayList[n + 1];
        jumps = new int[n + 1][20];
        level = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            al[start].add(end);
            al[end].add(start);
        }

        findLevel(1, 0);
        binaryLifting(1, -1);

        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            int lcs = lcs(u, v);
            int ans = (level[u] - level[lcs]) + (level[v] - level[lcs]);

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}

class GraphCycleDirected {

    ArrayList<Integer> al[];
    int vis[];

    boolean found;

    void dfs(int cur) {

        vis[cur] = 1;

        for (int child : al[cur]) {
            if (vis[child] == 1) {
                found = true;
                return;
            }

            if (vis[child] == 0) {
                dfs(cur);
            }

        }

        vis[cur] = 2;

    }

    public boolean solve() {

        int n = 0;

        al = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {

            int u = 0;
            int v = 1;

            al[v].add(u);
        }

        vis = new int[n];

        found = false;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i);
            }
        }

        return found;

    }
}

class GraphCycleUnDirected {

    ArrayList<Integer> al[];
    boolean vis[];

    boolean found;

    void dfs(int cur, int par) {

        vis[cur] = true;

        for (int child : al[cur]) {
            if (child == par) {
                continue;
            }
            if (vis[child]) {
                found = true;
                return;
            }
            dfs(child, cur);
        }

    }

    public boolean canFinish() {

        int n = 0;

        al = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {

            int u = 0;
            int v = 1;

            al[v].add(u);
        }

        vis = new boolean[n];

        found = false;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1);
            }
        }

        return found;

    }
}

class UnionFind {

    // Initialize all vertices as parents

    // https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/description/
    // https://leetcode.com/problems/number-of-good-paths/description/

    static int parent[];
    static int sizes[];

    static int findParent(int a) {
        if (parent[a] == -1 || parent[a] == a)
            return a;
        return parent[a] = findParent(parent[a]);
    }

    static boolean isConnected(int a, int b) {
        if (findParent(a) == findParent(b))
            return true;
        return false;
    }

    static void connect(int a, int b) {
        if (isConnected(a, b))
            return;
        if (sizes[findParent(a)] > sizes[findParent(b)]) {
            int temp = a;
            a = b;
            b = temp;
        }
        sizes[findParent(b)] += sizes[findParent(a)];
        parent[findParent(a)] = findParent(b);
    }

    static int findSize(int a) {
        return sizes[findParent(a)];
    }
}

class UnionFindWithConstructor {
    int parent[];
    int sizes[];

    UnionFindWithConstructor(int n) {
        parent = new int[n];
        sizes = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            sizes[i] = 1;
        }
    }

    int findParent(int a) {
        if (parent[a] == -1 || parent[a] == a)
            return a;
        return parent[a] = findParent(parent[a]);
    }

    boolean isConnected(int a, int b) {
        if (findParent(a) == findParent(b))
            return true;
        return false;
    }

    void connect(int a, int b) {
        if (isConnected(a, b)) {
            return;
        }
        if (sizes[findParent(a)] > sizes[findParent(b)]) {
            int temp = a;
            a = b;
            b = temp;
        }
        sizes[findParent(b)] += sizes[findParent(a)];
        parent[findParent(a)] = findParent(b);
    }

    int findSize(int a) {
        return sizes[findParent(a)];
    }
}

class FenwickTree {

    // 0 based

    static int[] ft;

    static void update(int i, int x) {
        int n = ft.length;
        while (i < n) {
            ft[i] += x;
            i |= i + 1;
        }
    }

    static int query(int i) {
        int x = 0;
        while (i >= 0) {
            x += ft[i];
            i &= i + 1;
            i--;
        }
        return x;
    }

    static void fenwickTree(int arr[]) {
        int n = arr.length;
        ft = new int[n];

        for (int i = 0; i < n; i++) {
            update(i, arr[i]);
        }

    }

}

class FenwickTree1 {
    // https://leetcode.com/problems/range-sum-query-mutable/description/
    // https://leetcode.com/problems/count-of-smaller-numbers-after-self/

    int tree[];

    FenwickTree1(int n) {
        tree = new int[n + 1];
    }

    void update(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            index = index + (index & -index);
        }
    }

    int query(int index) {
        int ans = 0;
        while (index > 0) {
            ans = ans + tree[index];
            index = index - (index & -index);
        }

        return ans;
    }
}

class HopcroftKarp {

    // Connect graph using one edge

    ArrayList<Integer> edge[];
    int pairU[], pairV[], dist[];
    int n;

    HopcroftKarp(int n) {
        this.n = n;
        pairU = new int[n + 1];
        pairV = new int[n + 1];
        dist = new int[n + 1];
        edge = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edge[i] = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        edge[u].add(v);
    }

    public boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (pairU[i] == 0) {
                dist[i] = 0;
                queue.add(i);
            } else
                dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (dist[u] < dist[0]) {
                for (int v : edge[u]) {
                    if (dist[pairV[v]] == Integer.MAX_VALUE) {
                        dist[pairV[v]] = dist[u] + 1;
                        queue.add(pairV[v]);
                    }
                }
            }
        }
        return dist[0] != Integer.MAX_VALUE;
    }

    public boolean dfs(int u) {
        if (u != 0) {
            for (int v : edge[u]) {
                if (dist[pairV[v]] == dist[u] + 1) {
                    if (dfs(pairV[v])) {
                        pairV[v] = u;
                        pairU[u] = v;
                        return true;
                    }
                }
            }
            dist[u] = Integer.MAX_VALUE;
            return false;
        }
        return true;
    }

    public int hopcroftkarp() {
        int res = 0;
        while (bfs()) {
            for (int i = 1; i <= n; i++) {
                if (pairU[i] == 0 && dfs(i))
                    res++;
            }
        }
        return res;
    }
}

class DiamterTree {
    static ArrayList<Integer> al[];
    static int diameter;
    static boolean vis[];
    static int dis;

    static int solve(int cur, int par, int curLength) {
        int ans = 0;
        int max1 = 0;
        int max2 = 0;

        for (int child : al[cur]) {
            if (child != par) {
                int val = 1 + solve(child, cur, curLength + 1);
                ans = Math.max(ans, val);
                if (max1 < val) {
                    if (max2 < max1) {
                        max2 = max1;
                    }
                    max1 = val;
                    continue;
                }
                if (max2 < val) {
                    max2 = val;
                }
            }
        }
        diameter = Math.max(diameter, Math.max(max1 + max2, Math.max(max1 + curLength, max2 + curLength)));
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            al = new ArrayList[n + 1];
            vis = new boolean[n + 1];
            diameter = 0;
            dis = 0;

            for (int i = 0; i < n + 1; i++) {
                al[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                al[start].add(end);
                al[end].add(start);
            }

        }

        System.out.print(sb);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class CustomerComparatorImplementation {

    // Merge k Sorted Lists on Leetcode

    static class CompareObj implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            // for smaller first
            return a.val - b.val;
        }
    }

    public ListNode mergeKLists(ListNode lists[]) {

        // PriorityQueue<ListNode> pq = new PriorityQueue<>(new CompareObj());
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> {
            return a.val - b.val;
        });

        int n = lists.length;

        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode head = null;
        ListNode temp = head;

        while (pq.isEmpty() == false) {
            ListNode min = pq.remove();

            if (temp == null) {
                head = new ListNode(min.val);
                temp = head;
            } else {
                ListNode toAdd = new ListNode(min.val);
                temp.next = toAdd;
                temp = temp.next;
            }

            if (min.next != null) {
                pq.add(min.next);
            }

        }

        // 2d array can be sorted but 1d array be cant

        int[][] intervals = new int[2][2];

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        return head;
    }

}

// from Striver's video, is not tested
class SegmentTreeMaxInRange {

    int tree[];
    int arr[];
    int lazy[];

    SegmentTreeMaxInRange(int n) {
        tree = new int[4 * n];
        lazy = new int[4 * n];
    }

    void build2(int low, int high, int index) {
        if (low == high) {
            tree[index] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        build2(low, mid, index * 2 + 1);
        build2(mid + 1, high, index * 2 + 2);

        tree[index] = Math.max(tree[index * 2 + 1], tree[index * 2 + 2]);
    }

    int query2(int curLow, int curHigh, int low, int high, int index) {
        if (curLow >= low && curHigh <= high) {
            return tree[index];
        }

        if (curHigh < low || high < curLow) {
            return Integer.MIN_VALUE;
        }

        int mid = (curLow + curHigh) / 2;
        int res1 = query2(curLow, mid, low, high, index * 2 + 1);
        int res2 = query2(mid + 1, curHigh, low, high, index * 2 + 2);

        return Math.max(res1, res2);
    }

    void build(int arr[]) {
        this.arr = arr;
        build2(0, arr.length - 1, 0);
    }

    int query(int low, int high) {
        return query2(0, arr.length - 1, low, high, 0);
    }
}

// https://leetcode.com/problems/range-sum-query-mutable/
class SegmentTreePointUpdate {
    int tree[];
    int n;

    SegmentTreePointUpdate(int n) {
        tree = new int[n * 4 + 1];
        this.n = n;
    }

    void build(int nums[]) {
        build(nums, 0, nums.length - 1, 0);
    }

    void build(int nums[], int low, int high, int treeIndex) {
        if (low == high) {
            tree[treeIndex] = nums[low];
            return;
        }

        int mid = (low + high) / 2;

        build(nums, low, mid, treeIndex * 2 + 1);
        build(nums, mid + 1, high, treeIndex * 2 + 2);

        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }

    void pointUpdate(int index, int val) {
        pointUpdate(0, n - 1, 0, index, val);
    }

    void pointUpdate(int low, int high, int treeIndex, int index, int val) {
        if (low == high) {
            tree[treeIndex] = val;
            return;
        }

        int mid = (low + high) / 2;

        if (index <= mid) {
            pointUpdate(low, mid, treeIndex * 2 + 1, index, val);
        } else {
            pointUpdate(mid + 1, high, treeIndex * 2 + 2, index, val);
        }

        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }

    int query(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    int query(int treeIndex, int curLow, int curHigh, int low, int high) {
        if (curLow > high || curHigh < low) {
            return 0;
        }

        if (low <= curLow && curHigh <= high) {
            return tree[treeIndex];
        }

        int mid = (curLow + curHigh) / 2;

        int ans = query(treeIndex * 2 + 1, curLow, mid, low, high);
        ans = ans + query(treeIndex * 2 + 2, mid + 1, curHigh, low, high);

        return ans;
    }
}

class NumArray {

    SegmentTree segmentTree;

    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums.length);

        segmentTree.build(nums);
    }

    public void update(int index, int val) {
        segmentTree.pointUpdate(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

// tested for point update and range query
// https://leetcode.com/problems/range-sum-query-mutable/description/
// https://leetcode.com/problems/peaks-in-array/description/

class SegmentTree {
    int tree[];
    int lazy[];
    int n;

    SegmentTree(int n) {
        this.n = n;
        tree = new int[4 * n + 5];
        lazy = new int[4 * n + 5];
    }

    void build(int arr[]) {
        buildInternal(arr, 0, arr.length - 1, 0);
    }

    void buildInternal(int arr[], int low, int high, int treeIndex) {
        if (low == high) {
            tree[treeIndex] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        buildInternal(arr, low, mid, treeIndex * 2 + 1);
        buildInternal(arr, mid + 1, high, treeIndex * 2 + 2);

        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }

    void pointUpdate(int index, int val) {
        pointUpdateInternal(0, 0, n - 1, index, val);
    }

    void pointUpdateInternal(int treeIndex, int low, int high, int index, int val) {
        if (low == high) {
            tree[treeIndex] = val;
            return;
        }

        int mid = (low + high) / 2;

        if (index <= mid) {
            pointUpdateInternal(treeIndex * 2 + 1, low, mid, index, val);
        } else {
            pointUpdateInternal(treeIndex * 2 + 2, mid + 1, high, index, val);
        }

        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }

    void rangeUpdate(int low, int high, int val) {
        rangeUpdateInternal(0, 0, n - 1, low, high, val);
    }

    void rangeUpdateInternal(int treeIndex, int curLow, int curHigh, int low, int high, int val) {
        if (lazy[treeIndex] != 0) {
            tree[treeIndex] = tree[treeIndex] + (curHigh - curLow + 1) * lazy[treeIndex];

            if (curLow != curHigh) {
                lazy[treeIndex * 2 + 1] += lazy[treeIndex];
                lazy[treeIndex * 2 + 2] += lazy[treeIndex];
            }

            lazy[treeIndex] = 0;
        }

        if (high < curLow || curHigh < low) {
            return;
        }

        if (curLow >= low && curHigh <= high) {
            tree[treeIndex] = tree[treeIndex] + (curHigh - curLow + 1) * val;

            if (curLow != curHigh) {
                lazy[treeIndex * 2 + 1] += val;
                lazy[treeIndex * 2 + 2] += val;
            }

            return;
        }

        int mid = (curLow + curHigh) / 2;

        rangeUpdateInternal(treeIndex * 2 + 1, curLow, mid, low, high, val);
        rangeUpdateInternal(treeIndex * 2 + 2, mid + 1, curHigh, low, high, val);

        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }

    int query(int low, int high) {
        return queryLazySumInternal(0, 0, n - 1, low, high);
    }

    int queryLazySumInternal(int treeIndex, int curLow, int curHigh, int low, int high) {
        if (lazy[treeIndex] != 0) {
            tree[treeIndex] = tree[treeIndex] + (curHigh - curLow + 1) * lazy[treeIndex];

            if (curLow != curHigh) {
                lazy[treeIndex * 2 + 1] += lazy[treeIndex];
                lazy[treeIndex * 2 + 2] += lazy[treeIndex];
            }

            lazy[treeIndex] = 0;
        }

        if (high < curLow || curHigh < low) {
            return 0;
        }

        if (curLow >= low && curHigh <= high) {
            return tree[treeIndex];
        }

        int mid = (curLow + curHigh) / 2;

        return queryLazySumInternal(treeIndex * 2 + 1, curLow, mid, low, high)
                + queryLazySumInternal(treeIndex * 2 + 2, mid + 1, curHigh, low, high);
    }
}

class ConvertArrayListToIntArray {
    static void convert() {
        ArrayList<int[]> al = new ArrayList<>();
        al.toArray(new int[al.size()][]);
    }
}

class Solution {

    // Factors of number

    HashSet<Integer> getFactors(int n) {
        HashSet<Integer> ans = new HashSet<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                ans.add(i);
                ans.add(n / i);
            }
        }

        return ans;
    }
}

class RandomNumber {
    public void generateRandom() {
        Random random = new Random();
        int min = 0;
        int max = 10;

        // max is exclusive so adding 1
        int num = random.nextInt((max - min) + 1) + min;
    }
}

class Utils {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello world");

        int n = sc.nextInt();
        sc.nextLine();
        int b = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        int a = sc.nextInt();

        double da = sc.nextDouble();

        Integer.toBinaryString(a);

        System.out.println(n + " " + str + " " + b + "  " + a + "  " + da);

        System.out.println(Integer.toBinaryString(10));
    }
}

// custom hashset equal
// https://leetcode.com/problems/maximum-value-sum-by-placing-three-rooks-ii/
class SolutionCustomHashSetEqual {

    static class Node {
        int row;
        int col;
        int val;

        Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node node = (Node) o;
            return row == node.row && col == node.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public long maximumValueSum(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        HashSet<Node> rowMax = new HashSet<>();

        for (int i = 0; i < n; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
                return a.val - b.val;
            });

            for (int j = 0; j < m; j++) {
                pq.add(new Node(i, j, board[i][j]));

                if (pq.size() > 3) {
                    pq.remove();
                }
            }

            while (!pq.isEmpty()) {
                rowMax.add(pq.remove());
            }
        }

        ArrayList<Node> al = new ArrayList<>();

        for (int j = 0; j < m; j++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
                return a.val - b.val;
            });

            for (int i = 0; i < n; i++) {
                pq.add(new Node(i, j, board[i][j]));

                if (pq.size() > 3) {
                    pq.remove();
                }
            }

            while (!pq.isEmpty()) {
                Node rem = pq.remove();

                if (rowMax.contains(rem)) {
                    al.add(rem);
                }
            }
        }

        Collections.sort(al, (a, b) -> {
            return b.val - a.val;
        });

        while (al.size() > 11) {
            al.remove(al.size() - 1);
        }

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < al.size(); i++) {
            for (int j = i + 1; j < al.size(); j++) {
                for (int k = j + 1; k < al.size(); k++) {
                    HashSet<Integer> setR = new HashSet<>();
                    HashSet<Integer> setC = new HashSet<>();

                    setR.add(al.get(i).row);
                    setR.add(al.get(j).row);
                    setR.add(al.get(k).row);

                    setC.add(al.get(i).col);
                    setC.add(al.get(j).col);
                    setC.add(al.get(k).col);

                    if (setR.size() != 3 || setC.size() != 3) {
                        continue;
                    }

                    long curAns = (long) al.get(i).val + al.get(j).val + al.get(k).val;
                    ans = Math.max(ans, curAns);
                }
            }
        }

        return ans;
    }
}

// https://leetcode.com/problems/minimum-time-to-revert-word-to-initial-state-ii/
// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-ii/description/
class KMPAlgorithmSolution {

    int[] KMPAlgorithm(String str) {
        char c[] = str.toCharArray();
        int n = c.length;
        int lps[] = new int[n];
        lps[0] = 0;

        for (int i = 1; i < n; i++) {
            int prevIndex = lps[i - 1];

            while (prevIndex > 0 && c[prevIndex] != c[i]) {
                prevIndex = lps[prevIndex - 1];
            }

            lps[i] = prevIndex + (c[prevIndex] == c[i] ? 1 : 0);
        }

        return lps;
    }
}

// Calculate ways with relative ordering, use nCr
// like we have (a,b,c,d) (e,f,g,h) and we want to maintain order in each set
// so there will be 8C4 ways of doing it
// similar problem
// https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/description/
// if we have to preserve relative order between more than 2 array, lets n1, n2,
// n3, n4
// it will be n1Cn1 * (n1 + n2) C (n2) * (n1 + n2 + n3) C (n3) * (n1 + n2 + n3 +
// n4) C (n4)
// https://leetcode.com/problems/count-the-number-of-infection-sequences/

// sum of binomial coefficient is nC0 + nC1 .... + nCn = 2^n
// https://
// leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

// Treeset comparator
// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/submissions/

// whenever subarray problem think in the direction of subarray and what will
// each element contribute to the answer
// keep in mind the negative numbers in subarray problems
// "https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/"
// https://leetcode.com/problems/find-the-median-of-the-uniqueness-array/

// Longest Increasing Subsequence variation, Russian Doll Envelopes

// Pattern matching algorithm
// https://leetcode.com/problems/longest-happy-prefix/description/

// Bitwise good questions of OR and AND
// https://leetcode.com/problems/bitwise-ors-of-subarrays/
// https://leetcode.com/problems/number-of-subarrays-with-and-value-of-k/

// Probability based questions
// https://leetcode.com/problems/linked-list-random-node/description/
// https://leetcode.com/problems/knight-probability-in-chessboard/editorial/
// https://leetcode.com/problems/random-pick-with-weight/

// TreeSet and TreeMap good APIs description
// https://leetcode.com/problems/range-module/description/

// BFS VS DFS
// Use BFS when we need to build answer using our inital results, like bottom up
// Use DFS when we need to build answer from the end, like top down
// Be very cautious when you see states have two or more variable which we have
// to optimize like in below question
// there is curHealth as well as minimum seen
// https://leetcode.com/problems/dungeon-game/description/
// also this question can't be solved using bottom up because we have to use
// information from end
// BFS
// https://www.interviewbit.com/problems/useful-extra-edges/

// O(1) space inorder traversal of tree, Morris Traversal
// https://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html

// In every stack question keep in mind stack.peek() plays a very important role
// Largest histogram

// Out of the box question
// https://leetcode.com/problems/trapping-rain-water-ii/description/

// Bipartite graph
// https://leetcode.com/problems/is-graph-bipartite/description/

// https://leetcode.com/problems/find-the-count-of-good-integers/description/
// if we have 11234555 and we want to find out unique shuffle of the numbers it
// would be 8! / (2! * 3!)

// linked list cycle detection
// https://leetcode.com/problems/linked-list-cycle-ii/description/
// let distance travelled by slow is d. Let from start to cycle point distance
// is x and in cycle to meet fast it is y
// so d = (x + y)
// fast travels 2 times as of slow, so fast distance is 2d. As the slow meets
// fast, fast would have covered the cycle some n times
// so fast distance = x + y + n = 2d = 2(x + y)
// this gives cycle n = x + y and x = n - y
// now if we start from head, to reach the cycle point we will cover x distance
// also from the meeting point if we will go x we will complete a cycle and be
// at position from where cycle starts

// Rabin Karp
// https://leetcode.com/problems/minimum-time-to-revert-word-to-initial-state-ii/