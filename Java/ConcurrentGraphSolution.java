import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Graph {
    HashMap<Integer, HashSet<Integer>> graph;
    HashMap<Integer, ReentrantLock> lockMap;
    ReentrantLock globalLock;

    Graph() {
        graph = new HashMap<>();
        lockMap = new HashMap<>();
        globalLock = new ReentrantLock();
    }

    ReentrantLock getLock(int node) {
        if (lockMap.containsKey(node)) {
            return lockMap.get(node);
        }

        globalLock.lock();
        lockMap.put(node, new ReentrantLock());
        globalLock.unlock();

        return lockMap.get(node);
    }

    void add(int start, int end) {
        if (!graph.containsKey(start)) {
            graph.put(start, new HashSet<>());
        }

        ReentrantLock nodeLock = getLock(start);
        nodeLock.lock();
        graph.get(start).add(end);
        nodeLock.unlock();
    }
}

public class ConcurrentGraphSolution {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 5);
        graph.add(2, 6);
    }
}
