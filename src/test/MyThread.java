package test;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }


    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.run();
        // Calling run() directly will not create a new thread
        // t.run(); // This will execute in the main thread

        // Calling start() creates a new thread and starts its execution
        t.start();
    }
}


