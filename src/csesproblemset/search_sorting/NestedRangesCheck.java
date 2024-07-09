package csesproblemset.search_sorting;

import java.util.*;

public class NestedRangesCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] arrinput = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(arrinput[0]);
            arr[i][1] = Integer.parseInt(arrinput[1]);
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[][] result = new int[2][n];
        Arrays.fill(result[1], 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i][0] <= arr[j][0] && arr[i][1] >= arr[j][1]) {
                    List<Integer> temp = map.getOrDefault(i, new ArrayList<>());
                    temp.add(j);
                    map.put(i, temp);
                }
            }
            if (map.get(i) != null) {
                result[0][i] = 1;
            }
        }

        map.values().forEach(values -> {
            values.forEach(value -> {
                result[1][value] = 1;
            });
        });

        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
