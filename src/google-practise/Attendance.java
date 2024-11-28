public class Attendance {

    public static void main(String[] args) {
        int n = 10101;

        int res = generateAttendance(0, 0, 0, 0, n);
        System.out.println(res);
    }

    private static int generateAttendance(int a, int l, int p, int pl, int n) {
        // TODO Auto-generated method stub
        if (a >= 2) {
            return 0;
        }
        if (l >= 3 && pl == 2) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        return generateAttendance(a + 1, l, p, l, n - 1) +
                generateAttendance(a, l + 1, p, l, n - 1) +
                generateAttendance(a, l, p + 1, l, n - 1);

    }
}