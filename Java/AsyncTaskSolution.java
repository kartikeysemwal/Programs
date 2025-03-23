// import java.util.*;
// import java.util.concurrent.*;

// class Task {
// Runnable work;
// Runnable callback;
// List<Task> dependencies;

// Task(Runnable work, Runnable callback) {
// this.work = work;
// this.callback = callback;
// this.dependencies = new ArrayList<>();
// }

// void addDependency(Task task) {
// dependencies.add(task);
// }

// void execute(ExecutorService service, Map<Task, Future<?>> taskResults) {
// List<Future<?>> depFutures = new ArrayList<>();

// for (Task dep : dependencies) {
// depFutures.add(taskResults.get(dep));
// }

// Future<?> future = service.submit(() -> {
// try {
// for (Future<?> f : depFutures) {
// f.get();
// }
// work.run();
// if (null != callback) {
// callback.run();
// }
// } catch (Exception ex) {
// }
// });

// taskResults.put(this, future);
// }
// }

// class TaskManager {
// ExecutorService service = Executors.newFixedThreadPool(5);
// List<Task> tasks = new ArrayList<>();
// Map<Task, Future<?>> taskResults = new ConcurrentHashMap<>();

// void addTask(Task task) {
// tasks.add(task);
// }

// void executeAll() {
// for (Task task : tasks) {
// task.execute(service, taskResults);
// }
// }

// void shutDown() {
// service.shutdown();
// }
// }

// public class AsyncTaskSolution {
// public static void main(String[] args) {
// TaskManager taskManager = new TaskManager();

// Task task1 = new Task(() -> System.out.println("Task for 1"), () ->
// System.out.println("Callback for 1"));
// Task task2 = new Task(() -> System.out.println("Task for 2"), () ->
// System.out.println("Callback for 2"));
// Task task3 = new Task(() -> System.out.println("Task for 3"), () ->
// System.out.println("Callback for 3"));

// task3.addDependency(task1);
// task3.addDependency(task2);

// taskManager.addTask(task3);
// taskManager.addTask(task2);
// taskManager.addTask(task1);

// taskManager.executeAll();
// taskManager.shutDown();
// }
// }

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Task {
    Runnable current;
    Runnable callback;
    List<Task> dependencies;

    Task(Runnable current, Runnable callback) {
        this.current = current;
        this.callback = callback;
        dependencies = new ArrayList<>();
    }

    void addDependency(Task dep) {
        this.dependencies.add(dep);
    }

    void execute(ExecutorService executorService, Map<Task, Future<?>> futureMap) {
        List<Future<?>> depFutures = new ArrayList<>();

        for (Task dep : dependencies) {
            depFutures.add(futureMap.get(dep));
        }

        var curFuture = executorService.submit(() -> {
            try {
                for (var future : depFutures) {
                    future.get();
                }

                current.run();
                if (callback != null) {
                    callback.run();
                }

            } catch (Exception ex) {

            }
        });

        futureMap.put(this, curFuture);
    }
}

class TaskManager {
    List<Task> allTasks;
    Map<Task, Future<?>> futureMap;
    ExecutorService executorService;

    TaskManager() {
        allTasks = new ArrayList<>();
        futureMap = new HashMap<>();
        executorService = Executors.newFixedThreadPool(6);
    }

    void addTask(Task task) {
        allTasks.add(task);
    }

    void executeAll() {
        for (Task task : allTasks) {
            task.execute(executorService, futureMap);
        }
    }

    void shutdown() {
        executorService.shutdown();
    }
}

public class AsyncTaskSolution {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task t1 = new Task(() -> System.out.println("Task 1 current"), () -> System.out.println("Task 1 callback"));
        Task t2 = new Task(() -> System.out.println("Task 2 current"), () -> System.out.println("Task 2 callback"));
        Task t3 = new Task(() -> System.out.println("Task 3 current"), () -> System.out.println("Task 3 callback"));
        Task t4 = new Task(() -> System.out.println("Task 4 current"), () -> System.out.println("Task 4 callback"));

        t4.addDependency(t3);
        t4.addDependency(t2);
        t2.addDependency(t1);

        taskManager.addTask(t1);
        taskManager.addTask(t2);
        taskManager.addTask(t3);
        taskManager.addTask(t4);

        taskManager.executeAll();

        taskManager.shutdown();
    }
}