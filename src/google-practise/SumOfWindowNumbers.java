import java.util.*;

class SumOfWindowNumbers {

    static class Num {
        int a;
        int b;

        public Num(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

    }

    public static int[] findSumOfWindow(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Num> queue = new PriorityQueue<>(Comparator.comparingInt(Num::getA));

        queue.add(new Num(1, 2));

        return result;
    }

    public static void main(String[] args) {

    }
}