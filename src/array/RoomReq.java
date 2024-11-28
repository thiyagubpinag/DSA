package array;

import java.util.*;

public class RoomReq {

    static int solve(ArrayList<ArrayList<Long>> timings, int N) {
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
            if (occupiedRooms.isEmpty() || occupiedRooms.peek()[0] > arrivalTime) {
                // If there are no rooms or all the rooms are occupied,
                // then increment the total number of rooms needed and allocate the room to the current customer
                roomCnt += 1;
                occupiedRooms.add(new long[] { departureTime, roomCnt });
                ans.set((int) idx, roomCnt);
            } else {
                // If there is a vacant room, then assign that vacant room to the current customer
                long[] vacantRoom = occupiedRooms.poll();
                vacantRoom[0] = departureTime;
                occupiedRooms.add(vacantRoom);
                ans.set((int) idx, (int) vacantRoom[1]);
            }
        }

        return roomCnt;
    }

    public static void main(String[] args) {
        RoomReq roomReq = new RoomReq();
        int[] arr = {1, 2, 4};
        int[] dep = {2, 4, 4};
        int res = roomReq.roomsReq(arr, dep, 3);
        System.out.println(res);
    }

    private int roomsReq(int[] arr, int[] dep, int n) {
        ArrayList<ArrayList<Long>> timings =new ArrayList<>();
        for(int i=0;i<n;i++){
            timings.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            timings.get(i).add( (long) arr[i]);
            timings.get(i).add( (long) dep[i]);
        }

        return solve(timings,n);
    }
}
