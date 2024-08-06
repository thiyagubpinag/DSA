package practice;

public class Partition {
    public static void main(String[] args) {
        int[] a={2,1};
        int i=-1;
        int low=0;
        int high=a.length;
        int j=low;
        for(j=low;j<high;j++){
            if(a[j]!=0){
                i++;
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp;
            }
        }
        if(i+1<a.length) {
            int temp = a[i + 1];
            a[i + 1] = a[high - 1];
            a[high - 1] = temp;
        }
        System.out.println(a);

    }
}
