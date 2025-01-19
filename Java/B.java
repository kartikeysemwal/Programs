import java.util.*;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Integer ab = null;
        String strAb = null;

        if (strAb == null) {

        }

        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);
        al1.add(2);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(1);
        al2.add(2);

        HashSet<ArrayList<Integer>> set1 = new HashSet<>();
        set1.add(al1);
        set1.add(al2);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        System.out.println(set1.size());

        HashSet<int[]> set2 = new HashSet<>();
        set2.add(new int[] { 1, 2 });
        set2.add(new int[] { 1, 2 });

        int arr[] = new int[0];

        System.out.println(set2.size());

        System.out.println('a' - 'a');
        System.out.println('e' - 'a');
        System.out.println('i' - 'a');
        System.out.println('o' - 'a');
        System.out.println('u' - 'a');

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

        }

        for (var entry : map.entrySet()) {
        }

        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        var iterator = tree.tailSet(0).iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        var test = tree.headSet(100000);
        System.out.println(test.size());

        tree.lower(1);
        tree.higher(1);

        tree.floor(1);
        tree.ceiling(1);

        Collections.binarySearch(al1, -1);

        // tree.first();
        // tree.last();
        // tree.pollFirst();
        // tree.pollLast();

        TreeMap<String, Integer> treeMap = new TreeMap<>((a, b) -> {
            return 0;
        });

        treeMap.subMap(strAb, strAb);

        treeMap.remove("1");

        // Map.Entry<Integer, Integer> entry = treeMap.pollFirstEntry();

        int a = 'A';
        int b = 'a';

        System.out.println('z' - 'A');

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        map1.put(2, 1);
        map1.put(3, 1);

        HashMap<Integer, Integer> map2 = new HashMap<>();

        TreeMap<Integer, Integer> map4 = new TreeMap<>();

        map2.put(1, 1);

        int abit = 6;

        System.out.println(abit << 1);
        System.out.println(abit << 1 + 1);

        System.out.println(Math.random());

        int arr1[] = new int[0];
        int arr2[] = new int[0];

        Arrays.copyOf(arr1, 0);

        System.out.println(Integer.MAX_VALUE);

        System.out.println(((double) (3) / 25));

        al1.clone();

        Collections.sort(al1, (x, y) -> {
            return 0;
        });

        // String ab = "ab";
        // String ba = "ba";
        // System.out.println(ab.compareTo(ba));

        int[] arr4 = al1.stream().mapToInt(i -> i).toArray();

        System.out.println(296 % 60 + " " + 296 / 60);

        System.out.println('w' - 'a');
        System.out.println((char) ('a' + 17));

        List<Integer> list2 = new ArrayList<>();

        int arrSet[] = new int[] { 0, 1, 2, 0 };

        TreeSet<Integer> treeSet2 = new TreeSet<>((x, y) -> {
            return arrSet[x] - arrSet[y];
        });

        treeSet2.add(0);
        treeSet2.add(1);
        treeSet2.add(2);
        treeSet2.add(3);

        for (int x : treeSet2) {
            System.out.println(x);
        }

        long steps = 0;
        int val = 0;
        val += steps;

        System.out.println(6 << 1);
        System.out.println(6 << 2);
        System.out.println((1 << 15) - 1);

        System.out.println(-2 % 2);

    }
}