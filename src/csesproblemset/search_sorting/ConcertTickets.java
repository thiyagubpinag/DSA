package csesproblemset.search_sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConcertTickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr1 = sc.nextLine().split(" ");
        String[] arrStr2 = sc.nextLine().split(" ");
        String[] arrStr3 = sc.nextLine().split(" ");
        int n = Integer.parseInt(arrStr1[0]);
        int m = Integer.parseInt(arrStr1[1]);
        int[] priceOfTickets = new int[n];
        int[] customerPrice = new int[m];
        for (int i = 0; i < n; i++) {
            priceOfTickets[i] = (Integer.parseInt(arrStr2[i]));
        }
        for (int i = 0; i < m; i++) {
            customerPrice[i] = (Integer.parseInt(arrStr3[i]));
        }

        solve(priceOfTickets,customerPrice,n,m);
        /*Arrays.sort(priceOfTickets);
        int[] output = new int[m];
        Arrays.fill(output, -1);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            int index = Arrays.binarySearch(priceOfTickets, customerPrice[i]);
            int startIndex = -(index) - 1;
            startIndex--;
            int temp = index >= 0 ? index : startIndex;
            int j=0;
            while (j<=temp) {
                if (!visited[temp]) {
                    output[i] = priceOfTickets[temp];
                    priceOfTickets[temp] = -1;
                    visited[temp] = true;
                    break;
                }
                j++;
            }
        }*/

    }

    public static void solve(int[] tickets, int[] customer, int N, int M) {
        Map<Integer, Integer> pendingTickets = new HashMap<>();
        for (int i = 0; i < N; i++) {
            pendingTickets.put(tickets[i], pendingTickets.getOrDefault(tickets[i], 0) + 1);
        }

        for (int i = 0; i < M; i++) {
            int currentCustomer = customer[i];
            Map.Entry<Integer, Integer> entry = null;
            for (Map.Entry<Integer, Integer> ticket : pendingTickets.entrySet()) {
                if (ticket.getKey() <= currentCustomer) {
                    entry = ticket;
                } else {
                    break;
                }
            }
            if (entry == null) {
                System.out.println(-1);
            } else {
                System.out.println(entry.getKey());
                int count = entry.getValue() - 1;
                if (count == 0) {
                    pendingTickets.remove(entry.getKey());
                } else {
                    pendingTickets.put(entry.getKey(), count);
                }
            }
        }
    }
}
