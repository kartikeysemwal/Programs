import java.util.*;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> ll = new HashMap<>();

        for (int i = 0; i < 200000; i++) {
            al.add(i);
            ll.put(i, i);
        }
        double start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            al.get(i);
        }
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        // for (int i = 0; i < 200000; i++) {
        // ll.get(i);
        // }
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(set.remove(1) + " " + map.get(0) + " " + map.remove(0));

        System.out.println(System.currentTimeMillis() - start);
    }
}