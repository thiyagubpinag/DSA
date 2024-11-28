package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyRow {
    public static String convert(String s, int numRows) {
        if(numRows==1 || numRows >=s.length())
        {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i=0;i<numRows;i++)
        {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);

            rows[currentRow].append(c);
            if(currentRow==0 ||currentRow==numRows-1)
            {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1:-1;

        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<rows.length;i++)
        {
            result.append(rows[i]);
        }
        return result.toString();



    }

    public static void main(String[] args) {
        String S = "beaninjacoder";
        int ROW = 4;
        convert(S,4);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int index = 1;
        while (index <= ROW) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(index);
            map.put(index, temp);
            index++;
        }
        while (index <= S.length()) {
            if ((index+1) % ROW == 0) {
                int k = index;
                int m = k + ROW;
                while (k < S.length() && k < m) {
                    ArrayList<Integer> kList = map.get(k % ROW);
                    kList.add(index);
                    map.put(k, kList);
                    k++;
                }
            }
            int i = index % ROW;
            int j = ROW - i;
            ArrayList<Integer> temp = map.get(j);
            temp.add(temp.getLast() + 2 * i);
            map.put(j, temp);
            index++;
        }

        System.out.println(map);

    }
}
