import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class CompletableFutureSolution {
    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println("This is completable future");
        });

        CompletableFuture retFuture = CompletableFuture.supplyAsync(() -> {
            return 10;
        }).thenApply(n -> n * 2)
                .thenApply(n -> n * 2).thenRun(() -> System.out.println("Computation is done"));

        System.out.println(future.join());
        System.out.println(retFuture.join());
    }
}
