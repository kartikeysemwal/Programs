import java.util.*;
import java.io.*;

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

        for (int i = 2; i <= Math.sqrt(n); i++) {
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
        parent[findParent(a)] = findParent(b);
        sizes[findParent(b)] += sizes[findParent(a)];
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
