import java.util.*;

class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int height[] = new int[n];
        int taste[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            taste[i] = sc.nextInt();
        }
        HashMap<String, Long> map = new HashMap<>();
        query: for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int p = sc.nextInt();
                int k = sc.nextInt();
                p--;
                taste[p] = k;
                map.clear();
            } else {
                int a = sc.nextInt();
                int b = sc.nextInt();
                a--;
                b--;
                String str = a + " " + b;
                if (map.containsKey(str)) {
                    sb.append(map.get(str)).append("\n");
                    continue;
                } else if (a == b) {
                    sb.append(taste[a]).append("\n");
                    continue;
                } else if (height[a] <= height[b]) {
                    sb.append("-1").append("\n");
                    continue;
                } else if (a == b + 1 || b == a + 1) {
                    sb.append(taste[a] + taste[b]).append("\n");
                    continue;
                }
                Stack<Integer> stack = new Stack<>();
                stack.add(a);
                String check = " " + b;
                if (a > b) {
                    for (int point = a - 1; point >= b; point--) {
                        int cur = height[point];
                        if (cur >= height[a]) {
                            sb.append("-1").append("\n");
                            map.put(str, (long) -1);
                            continue query;
                        }
                        if (cur <= height[b] && point != b) {
                            continue;
                        }
                        while (stack.size() > 0 && cur >= height[stack.peek()]) {
                            stack.pop();
                        }
                        if (stack.size() == 0) {
                            break;
                        }
                        if (map.containsKey(point + check) && map.get(point + check) != -1) {
                            long sum = 0;
                            while (!stack.isEmpty()) {
                                sum += taste[stack.pop()];
                            }
                            // sb.append(sum).append("\n");
                            map.put(a + " " + point, sum + taste[point]);
                            sum += map.get(point + check);
                            sb.append(sum).append("\n");
                            map.put(str, sum);
                            continue query;
                        }
                        stack.add(point);
                    }
                } else {
                    for (int point = a + 1; point <= b; point++) {
                        int cur = height[point];
                        if (cur >= height[a]) {
                            sb.append("-1").append("\n");
                            map.put(str, (long) -1);
                            continue query;
                        }
                        if (cur <= height[b] && point != b) {
                            continue;
                        }
                        while (stack.size() > 0 && cur >= height[stack.peek()]) {
                            stack.pop();
                        }
                        if (stack.size() == 0) {
                            break;
                        }
                        if (map.containsKey(point + check) && map.get(point + check) != -1) {
                            long sum = 0;
                            while (!stack.isEmpty()) {
                                sum += taste[stack.pop()];
                            }
                            // sb.append(sum).append("\n");
                            map.put(a + " " + point, sum + taste[point]);
                            sum += map.get(point + check);
                            sb.append(sum).append("\n");
                            map.put(str, sum);
                            continue query;
                        }
                        stack.add(point);
                    }
                }
                if (stack.size() == 0) {
                    sb.append("-1").append("\n");
                    map.put(str, (long) -1);
                } else {
                    long sum = 0;
                    while (!stack.isEmpty()) {
                        sum += taste[stack.pop()];
                    }
                    sb.append(sum).append("\n");
                    map.put(str, sum);
                }
            }
        }
        System.out.print(sb);
    }
}