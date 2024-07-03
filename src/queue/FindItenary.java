package queue;

import java.util.*;

public class FindItenary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> pq = map.getOrDefault(from, new PriorityQueue());
            pq.add(to);
            map.put(from, pq);
        }

        List<String> resultList = new ArrayList();
        Queue<String> queue = new LinkedList();

        queue.add("MUM");

        while (!queue.isEmpty()) {
            String result = queue.poll();
            resultList.add(result);

            PriorityQueue<String> pq = map.getOrDefault(result, new PriorityQueue());
            if (!pq.isEmpty()) {
                queue.add(pq.poll());
            }
        }

        return resultList;

    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>(List.of(List.of("MUC", "LHR"), List.of("MUM", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"), List.of("MUM", "SFO"), List.of("LUC", "MUM")));
        List<String> result = findItinerary(tickets);
        System.out.println(result);
    }
}

//MUM SFO MUC LHR SFO SJC