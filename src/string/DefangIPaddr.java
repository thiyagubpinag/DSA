package string;

public class DefangIPaddr {
    public static String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char temp = address.charAt(i);
            if (temp == '.') {
                res.append("[.]");
            } else {
                res.append(address.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        String res = defangIPaddr(address);
        System.out.println(res);
        String[] a="an n".split(" ");
        System.out.println(a.length);

    }
}
