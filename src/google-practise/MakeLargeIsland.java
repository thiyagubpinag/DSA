import java.util.Arrays;
import java.util.HashSet;

public class MakeLargeIsland {
    class Disjoint {
        int[] parent;
        int[] size;

        Disjoint(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(size, 1);
        }

        int findParent(int u) {
            if (parent[u] == -1) {
                return u;
            }
            return parent[u] = findParent(parent[u]);
        }

        void unionBySize(int u, int v) {
            int uParent = findParent(u);
            int vParent = findParent(v);

            if (uParent == vParent) {
                return;
            }

            int uSize = size[uParent];
            int vSize = size[vParent];

            if (uSize < vSize) {
                size[vParent] += uSize;
                parent[uParent] = vParent;
            } else {
                size[uParent] += vSize;
                parent[vParent] = uParent;
            }
        }

    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cell = (i * n) + j;
                if (grid[i][j] == 0) {
                    continue;
                }

                int[] x = { -1, 0, 0, 1 };
                int[] y = { 0, -1, 1, 0 };

                for (int k = 0; k < 4; k++) {
                    int newRow = i + x[k];
                    int newCol = j + y[k];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        int newCell = (newRow * n) + newCol;
                        ds.unionBySize(cell, newCell);
                    }

                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                int[] x = { -1, 0, 0, 1 };
                int[] y = { 0, -1, 1, 0 };
                int size = 1;
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int newRow = i + x[k];
                    int newCol = j + y[k];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                        int newCell = (newRow * n) + newCol;
                        int parentOfNewCell = ds.findParent(newCell);
                        if (!set.contains(parentOfNewCell)) {
                            size += ds.size[parentOfNewCell];
                            set.add(parentOfNewCell);
                        }

                    }

                }
                max = Math.max(size, max);
            }
        }
        return max == Integer.MIN_VALUE ? (n * n) : max;

    }

    public static void main(String[] args) {
        int[][] a = { { 1, 1 }, { 1, 0 } };
        MakeLargeIsland m = new MakeLargeIsland();
        System.out.println(m.largestIsland(a)); // Output: 4
    }
}
