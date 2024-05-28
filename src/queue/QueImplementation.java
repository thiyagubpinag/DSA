package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class QueImplementation {
    public static Queue<Integer> solve(Vector<Integer> v, int k) {
        //Write your code here
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < v.size(); i++) {
            queue.add(v.get(i));
        }

        queue.remove();
        System.out.println(queue.peek());

        AtomicBoolean flag = new AtomicBoolean(false);
        queue.forEach(i -> {
            if(i==k){
                flag.set(true);
            }
        });

        if(flag.get()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


        return queue;

    }

    public static void main(String[] args) {
        Vector v = new Vector<>();
        v.add(1);
        v.add(9);
        v.add(11);
        v.add(3);
        v.add(2);
        Queue<Integer> res=solve(v, 4);
        for (Integer re : res) {
            System.out.print(re+" ");
        }

        int[] a=new int[]{1,2};
    }
}
