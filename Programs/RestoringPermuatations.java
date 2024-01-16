import java.util.*;

public class RestoringPermuatations {
    static <T> void initialize(ArrayList<T> al, int n, T val) {
        for (int i = 0; i < n; i++) {
            al.add(val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> present = new ArrayList<>();
            ArrayList<Integer> sze = new ArrayList<>();
            initialize(sze, n - 1, 0);
            for (int i = 0; i < n - 1; i++) {
                ArrayList<Integer> al = new ArrayList<>();
                initialize(al, n + 1, 0);
                present.add(al);
            }

            for (int i = 0; i < n - 1; i++) {
                int s = sc.nextInt();
                sze.set(i, s);
                while (s-- != 0) {
                    int x = sc.nextInt();
                    present.get(i).set(x, 1);
                }
            }

            first: for (int p1 = 1; p1 <= n; p1++) {
                ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    ArrayList<Integer> al = new ArrayList<>(present.get(i));
                    dp.add(al);
                }
                ArrayList<Integer> sz = new ArrayList<>(sze);

                ArrayList<Integer> arr = new ArrayList<>();
                initialize(arr, n + 1, 0);
                arr.set(1, p1);
                boolean valid = true;
                second: for (int i = 2; i <= n; i++) {
                    for (int seg = 0; seg < n - 1; seg++) {
                        if (dp.get(seg).get(arr.get(i - 1)) == 1) {
                            dp.get(seg).set(arr.get(i - 1), 0);
                            sz.set(seg, sz.get(seg) - 1);
                        }
                    }
                    ArrayList<Integer> szOne = new ArrayList<>();
                    for (int seg = 0; seg < n - 1; seg++) {
                        if (sz.get(seg) == 1) {
                            szOne.add(seg);
                        }
                    }
                    if (szOne.size() != 1) {
                        valid = false;
                        break second;
                    }
                    int id = szOne.get(0);
                    third: for (int x = 1; x <= n; x++) {
                        if (dp.get(id).get(x) == 1) {
                            arr.set(i, x);
                            break third;
                        }
                    }
                }
                if (valid == false) {
                    continue;
                }
                ArrayList<Integer> idval = new ArrayList<>();
                initialize(idval, n + 1, 0);

                Set<Integer> rvals = new HashSet<>();
                for (int i = 1; i <= n; i++) {
                    idval.set(arr.get(i), i);
                }

                check: for (int i = 0; i < n - 1; i++) {
                    ArrayList<Integer> idv = new ArrayList<>();
                    for (int x = 1; x <= n; x++) {
                        if (present.get(i).get(x) == 1) {
                            idv.add(idval.get(x));
                        }
                    }
                    Collections.sort(idv);
                    for (int id = 1; id < idv.size(); id++) {
                        if (idv.get(id) != idv.get(id - 1) + 1) {
                            valid = false;
                            break check;
                        }
                    }
                    if (idv.size() != 0)
                        rvals.add(idv.get(idv.size() - 1));
                }
                if (valid == false || rvals.size() != n - 1) {
                    continue;
                }
                for (int i = 1; i <= n; i++) {
                    // System.out.print(arr.get(i) + " ");
                    sb.append(arr.get(i) + " ");
                }
                // System.out.println();
                sb.append("\n");
                break first;
            }
        }
        System.out.print(sb);
    }
}