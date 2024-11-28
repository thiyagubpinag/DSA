package com.design.pattern;

public class VolatileDesignPattern {
    static volatile int counter = 0;

    static class Threaad1 extends Thread {
        int localCounter = counter;

        @Override
        public void run() {
            while (localCounter < 10) {
                if (counter != localCounter) {
                    System.out.println("Thread 1 changes");
                    localCounter = counter;
                }
            }
        }
    }

    static class Threaad2 extends Thread {
        int localCounter = counter;

        @Override
        public void run() {
            while (localCounter<10) {
                System.out.println("Thread 2 changes" + counter);
                counter=++localCounter;

                try {
                    this.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Threaad1 threaad1 = new Threaad1();
        Threaad2 threaad2 = new Threaad2();
        threaad1.start();
        threaad2.start();
    }
}
