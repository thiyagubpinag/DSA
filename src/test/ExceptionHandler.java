package test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandler {
    public static void main(String[] args) {
        try {
            processA();
        } catch (Exception e) {
            System.err.println("MAIN");
            //se.printStackTrace();
        }
    }

    private static void processA() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate a potential exception
                if (0.4 < 0.5) {
                    throw new RuntimeException("Simulated exception");
                }
                return "Result";
            } catch (Exception e) {
                // Handle the exception within the supplier
                System.err.println("Exception in supplier: " + e.getMessage());
                throw e; // Rethrow the exception to be caught in the parent method
            }
        });

        //processB();
        int c = 10;
        System.out.println(c);

        future.get();
        int d = 10;
        System.out.println(d);

    }

    private static void processB() {
        String a = null;
        a.toLowerCase();
    }


}
