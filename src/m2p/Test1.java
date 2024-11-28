package m2p;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        char[] a={'e','b','a','b','q','l','t'};
        char[] b={'c','d','f','a','s','z','w','t','g','i','d'};

        Arrays.sort(a);
        Arrays.sort(b);

        char[] c=new char[a.length+b.length];

        int i=0;
        int j=0;
        int index=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                c[index++]=a[i++];
            }else{
                c[index++]=b[j++];
            }
        }
        while(i<a.length){
            c[index++]=a[i++];
        }
        while(j<b.length){
            c[index++]=b[j++];
        }

        for(int k=0;k<index;k++){
            System.out.print(c[k]+",");
        }


    }
}

