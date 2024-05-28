package queue;

public class PetrolSolution {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    static int solve(PetrolPump[] p, int n) {
        //Write your code here
        int deficit=0, start=0,cal=0;
        for(int i=0;i<p.length;i++){
            cal+=p[i].petrol-p[i].distance;
            if(cal<0){
                start=i+1;
                deficit+=cal;
                cal=0;
            }

        }
        return (cal+deficit)>=0 ? start :-1;

    }

    public static void main(String[] args) {
        int[] a = {6, 3, 7};

        int[] b = {4, 6, 3};

        PetrolPump[] p=new PetrolPump[a.length];
        for(int i=0;i<a.length;i++){
            PetrolPump p1=new PetrolPump(a[i],b[i]);
            p[i]=p1;
        }

        int res=solve(p,3);
        System.out.println(res);
    }
}
