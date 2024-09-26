package thread;

import java.util.concurrent.*;

public class BlockingQueueExample {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // Create a bounded queue with capacity 5

        // Producer thread
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("Producer produced: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int consumed = queue.take();
                    System.out.println("Consumer consumed: " + consumed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}