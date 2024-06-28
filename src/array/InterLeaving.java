package array;

public class InterLeaving {
    static void findInterLeaving(int index, int length, StringBuilder res) {
        if (index == length) {
            System.out.println(res.toString());
            return;
        }

        for (int i = index; i < res.length(); i++) {
            swapStr(i, index, res);
            findInterLeaving(index + 1, length, res);
            swapStr(index, i, res);
        }
    }

    private static void swapStr(int i, int j, StringBuilder res) {
        char c = res.charAt(j);
        res.setCharAt(j, res.charAt(i));
        res.setCharAt(i, c);
    }

    public static void main(String[] args) {
        String str1 = "AB", str2 = "CD";
        findInterLeaving(1, (str1 + str2).length(), new StringBuilder(str1 + str2));
    }
}
