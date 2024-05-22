package array;

public class CountArrangement {

    public static int countArrangement(int n) {
        // Create an array to store visited elements
        boolean[] visited = new boolean[n + 1];
        return countArrangementHelper(n, 1, visited);
    }

    public static void main(String[] args) {
        int count = countArrangement(3);
        System.out.println(count);
    }

    private static int countArrangementHelper(int n, int pos, boolean[] visited) {
        if (pos > n) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                count += countArrangementHelper(n, pos + 1, visited);
                visited[i] = false;
            }
        }

        return count;
    }
}


