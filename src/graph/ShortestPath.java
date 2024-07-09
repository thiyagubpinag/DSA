package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
    static int[][] dist = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static class Pair {
        int start;
        int end;
        int count;

        Pair(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }

    public static int shortestDistance(int N, int M, int[][] A, int X, int Y) {
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> queue = new LinkedList<>();
        if(A[X][Y]==0){
            return -1;
        }
        queue.add(new Pair(0, 0, 0));

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- > 0) {
                Pair pair = queue.poll();
                if (isValid(pair, visited, N, M)) {
                    if (pair.start == X && pair.end == Y) {
                        return pair.count;
                    }
                    for (int i = 0; i < 4; i++) {
                        int start = pair.start + dist[i][0];
                        int end = pair.end + dist[i][1];
                        queue.add(new Pair(start, end, pair.count + 1));
                    }
                }
            }
        }
        return -1;

    }

    public static boolean isValid(Pair pair, boolean[][] visited, int N, int M) {
        return pair.start >= 0 && pair.start < N && pair.end >= 0 && pair.end < M && !visited[pair.start][pair.end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] arrStr = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(arrStr[j]);
            }
        }
        String[] arrStr2 = sc.nextLine().split(" ");
        int destx = Integer.parseInt(arrStr2[0]);
        int desty = Integer.parseInt(arrStr2[1]);

        System.out.println(shortestDistance(n, m, arr, destx, desty));
    }
}
