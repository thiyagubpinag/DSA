package csesproblemset.search_sorting;

import java.util.*;

public class RoomAllocation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] arrinput = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(arrinput[0]);
            arr[i][1] = Integer.parseInt(arrinput[1]);
            arr[i][2] = i;
        }
        ArrayList<ArrayList<Long>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Long> temp = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                temp.add(Long.valueOf(arr[i][j]));
            }
            list.add(temp);
        }
        solve(list, n);

        System.out.println();
        Arrays.sort(arr, Comparator.comparing(i -> i[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] output = new int[n];
        pq.add(arr[0][1]);
        output[arr[0][2]] = 1;
        int roomCount = 1;
        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty()) {
                int temp = pq.peek();
                if (temp < arr[i][0]) {
                    pq.poll();
                    roomCount--;
                } else {
                    break;
                }
            }
            roomCount += 1;
            pq.add(arr[i][1]);
            output[arr[i][2]] = roomCount;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(output[i] + " ");
        }
    }

    // Function to find the minimum number of rooms and the rooms allocated to each customer
    static void solve(ArrayList<ArrayList<Long>> timings, int N) {
        // ArrayList to store the {arrival, departure, index} of all customers
        ArrayList<ArrayList<Long>> vec = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            vec.add(new ArrayList<>(Arrays.asList(timings.get(i).get(0), timings.get(i).get(1), (long) i)));
        }

        // Sort the ArrayList according to the arrival time of customers
        Collections.sort(vec, Comparator.comparingLong(a -> a.get(0)));

        // Min heap to store {departure, room number} to fetch the room which gets vacant the earliest
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        // Variable to store the total number of rooms needed
        int roomCnt = 0;

        // ArrayList to store the room allotted to each customer
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(N, 0));

        for (int i = 0; i < N; i++) {
            long arrivalTime = vec.get(i).get(0);
            long departureTime = vec.get(i).get(1);
            long idx = vec.get(i).get(2);

            // Check if there are no rooms available or all the rooms are occupied
            if (occupiedRooms.isEmpty() || occupiedRooms.peek()[0] >= arrivalTime) {
                // If there are no rooms or all the rooms are occupied,
                // then increment the total number of rooms needed and allocate the room to the current customer
                roomCnt += 1;
                occupiedRooms.add(new long[]{departureTime, roomCnt});
                ans.set((int) idx, roomCnt);
            } else {
                // If there is a vacant room, then assign that vacant room to the current customer
                long[] vacantRoom = occupiedRooms.poll();
                vacantRoom[0] = departureTime;
                occupiedRooms.add(vacantRoom);
                ans.set((int) idx, (int) vacantRoom[1]);
            }
        }

        // Print the total rooms needed along with the room allocated to each customer
        System.out.println(roomCnt);
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i) + " ");
    }
}
