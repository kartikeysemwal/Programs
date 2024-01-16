import java.util.*;

class Bundling {
    static int N = (int) 1E5 + 5;

    static class data {
        data child[] = new data[26];
        int count = 0;
    }

    static data root;

    static int n, k;
    static String a[];

    static void insert(String s) {
        data temp = root;
        for (int i = 0; i < s.length(); i++) { // A-Z 0-25
            char ch = s.charAt(i);
            int reqd = ch - 'A';
            if (temp.child[reqd] == null) {
                temp.child[reqd] = new data();
            }
            temp = temp.child[reqd];
        }
        temp.count++;
    }

    static int ans;

    static void dfs(data temp, int level) {
        for (int i = 0; i <= 25; i++) {
            if (temp.child[i] != null) {
                dfs(temp.child[i], level + 1);
                temp.count += temp.child[i].count;
            }
        }
        while (temp.count >= k) {
            temp.count -= k;
            ans += level;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            n = sc.nextInt();
            k = sc.nextInt();

            root = new data();
            ans = 0;
            a = new String[N];

            sc.nextLine();
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextLine();
                insert(a[i]);
            }
            dfs(root, 0);
            System.out.println("Case #" + (t + 1) + ": " + ans);
        }
    }
}

// long ans = 0;

// sc.nextLine();
// HashMap<String, Integer> map = new HashMap<>();
// for (int i = 0; i < n; i++) {
// String current = sc.nextLine();

// StringBuilder sb = new StringBuilder();
// for (int j = 0; j < current.length(); j++) {
// sb.append(current.charAt(j));

// if (map.containsKey(sb.toString())) {
// map.put(sb.toString(), map.get(sb.toString()) + 1);
// } else {
// map.put(sb.toString(), 1);
// }
// }
// }
// for (Map.Entry<String, Integer> entry : map.entrySet()) {
// ans += entry.getValue() / k;
// // System.out.println("Key = " + entry.getKey() + ", Value = " +
// // entry.getValue());
// }
// System.out.println("Case #" + (t + 1) + ": " + ans);