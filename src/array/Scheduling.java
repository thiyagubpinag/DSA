package array;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Scheduling {

    @Getter
    static class Period {
        int startTime;
        int endTime;
        int profit;

        public Period(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }


    public static void main(String[] args) {
        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};

        List<Period> periodList = new ArrayList<>();

        for (int i = 0; i < startTime.length; i++) {
            periodList.add(new Period(startTime[i], endTime[i], profit[i]));
        }

        periodList.sort(Comparator.comparingInt(Period::getEndTime));

        List<Integer> sortPeriods = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        sortPeriods.add(0);
        map.put(0, 0);
        AtomicInteger maxRes = new AtomicInteger(Integer.MIN_VALUE);

        periodList.forEach(period -> {
            int index = findIndex(sortPeriods, period.startTime);
            int newProfitVal = map.get(sortPeriods.get(index)) + period.profit;
            maxRes.set(Math.max(newProfitVal, maxRes.get()));
            if (!map.containsKey(period.endTime)) {
                sortPeriods.add(period.endTime);
            }
            map.put(period.endTime, newProfitVal);

        });

        System.out.println(maxRes);


    }

    private static int findIndex(List<Integer> sortPeriods, int startTime) {
        int low = 0;
        int high = sortPeriods.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortPeriods.get(mid) == startTime) {
                return mid;
            } else if (sortPeriods.get(mid) > startTime) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low == 0 ? 0 : low - 1;
    }
}
