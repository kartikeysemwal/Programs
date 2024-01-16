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

    static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

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

    // 1 based indexing

    static int fenwick_tree[];

    static void fenwickTree(int arr[]) {
        int n = arr.length;
        fenwick_tree = new int[n];

        for (int i = 1; i < n; i++) {
            update(i, arr[i]);
        }

    }

    public static int query(int l, int r) {
        return prefixSum(r) - prefixSum(l - 1);
    }

    public static int prefixSum(int index) {
        int sum = 0;

        while (index > 0) {
            sum = sum + fenwick_tree[index];
            index = index - (index & -index);
        }

        return sum;
    }

    public static void update(int index, int delta) {
        while (index < fenwick_tree.length) {
            fenwick_tree[index] = fenwick_tree[index] + delta;
            index = index + (index & -index);
        }
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

// Longest Increasing Subsequence variation, Russian Doll Envelopes

// Pattern matching algorithm
// https://leetcode.com/problems/longest-happy-prefix/description/