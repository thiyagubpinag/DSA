package array;

public class MaxOperations {
    public static int maxOperations(String s) {
        String[] strArr = s.split("");
        int n = s.length() - 1;
        int right = n;
        if (right - 1 <= 0) {
            return 0;
        }
        int count = 0;

        while (right >= 0) {
            String rightStr = strArr[right];
            if (!rightStr.equalsIgnoreCase("1")) {
                int temp = right;
                while (temp >= 0 && !strArr[temp].equalsIgnoreCase("1")) {
                    temp--;
                }
                if (temp >= 0) {
                    swap(strArr, temp, right);
                    count++;
                }
            }
            right--;
        }
        return count;

    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int res = maxOperations("1001101");
        System.out.println(res);
    }
}
