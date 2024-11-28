import java.util.Arrays;

public class SegmentTrees {

    private int[] seq;

    void formSegmentTree(int[] arr, int low, int high, int index) {
        if (low == high) {
            seq[index] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        formSegmentTree(arr, low, mid, 2 * index + 1);
        formSegmentTree(arr, mid + 1, high, 2 * index + 2);
        seq[index] = Math.min(seq[2 * index + 1], seq[2 * index + 2]);
    }

    private int query(int low, int high, int left, int right, int index) {

        if (right < low || high < left) {
            return Integer.MAX_VALUE;
        } else if (low >= left && high <= right) {
            return seq[index];
        } else {
            int mid = low + (high - low) / 2;
            return Math.min(query(low, mid, left, right, 2 * index + 1),
                    query(mid + 1, high, left, right, 2 * index + 2));
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 4, 7, 8 };

        int[][] queries = { { 0, 2 }, { 1, 3 }, { 2, 9 } };

        SegmentTrees st = new SegmentTrees();
        st.seq = new int[a.length * 4];
        Arrays.fill(st.seq, Integer.MAX_VALUE);
        st.formSegmentTree(a, 0, a.length - 1, 0);

        int res = st.query(0, a.length - 1, 0, 2, 0);
        System.out.println(res);

        // for (int i = 0; i < queries.length; i++) {
        // result[i] = st.query(queries[i][0], queries[i][1]);
        // }
    }

}
