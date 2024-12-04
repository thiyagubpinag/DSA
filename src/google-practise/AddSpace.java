public class AddSpace {
    public String addSpace(String s, int n, int[] spaces, int prev) {
        if (n >= spaces.length) {
            return s;
        }
        int index = spaces[n] - prev;
        return s.substring(0, index) + " " + addSpace(s.substring(index), n + 1, spaces, spaces[n]);
    }

    public String addSpaces(String s, int[] spaces) {
        return addSpace(s, 0, spaces, 0);
    }

    public static void main(String[] args) {
        AddSpace addSpace = new AddSpace();
        String res = addSpace.addSpaces("LeetcodeHelpsMeLearn", new int[] { 8, 13, 15 });
        System.out.println(res);
    }
}
