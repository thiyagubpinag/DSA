package m2p;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Test2 {
    public static void main(String[] args) {
        //int[] a={3,5,9,8,-8,2,-10,9,7,4,3,1,8,10,-12};
        int[] a={1,-2,2};

        //product of 3 values
        //o(n)
        PriorityQueue<Integer> maxPq=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        Arrays.stream(a).forEach(i->{
            maxPq.add(i);
            pq.add(i);
        });

        System.out.println(maxPq);
        System.out.println(pq);

        int firstLeft=pq.poll();
        int secLeft=pq.poll();
        int leftRes=Integer.MIN_VALUE;
        if(firstLeft<0 && secLeft<0){
            leftRes=firstLeft*secLeft;
        }

        int firstRight=maxPq.poll();
        int secondRight=maxPq.poll();
        int thirdRight=maxPq.poll();
        int max=Integer.MIN_VALUE;
        if(leftRes!=Integer.MIN_VALUE){
            max= Math.max(leftRes*firstRight,firstRight*secondRight*thirdRight);
        }else{
            max= Math.max(max,firstRight*secondRight*thirdRight);
        }

        System.out.println(max);



    }
}


