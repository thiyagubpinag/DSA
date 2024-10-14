package thread;

import lombok.SneakyThrows;

public class SimpleThreadProgram {
    static class Q {
        int data;
        boolean flag = false;

        synchronized void put(int data) {
            if(flag){
                try{wait();}catch (Exception e){}
            }
            this.data=data;
            System.out.println("PUT:" + data);
            flag=true;
            notify();
        }

        synchronized void get() {
            if(!flag){
                try{wait();}catch (Exception e){}
            }
            System.out.println("GET:" + data);
            flag=false;
            notify();
        }
    }

    static class Consumer extends Thread {

        Q q;

        public Consumer(Q q) {
            this.q = q;
            Thread t1 = new Thread(this, "Consumer");
            t1.start();
        }

        public void run() {
            int i = 0;
            while (true) {
                q.put(i++);
                try{sleep(1000);}catch (Exception e){}
            }
        }

    }

    static class Producer extends Thread {

        Q q;

        public Producer(Q q) {
            this.q = q;
            Thread t1 = new Thread(this, "Producer");
            t1.start();
        }

        public void run() {
            while (true) {
                q.get();
                try{sleep(1000);}catch (Exception e){}
            }
        }

    }

    public static void main(String[] args) {

        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }


}
