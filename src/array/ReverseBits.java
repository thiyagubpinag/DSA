package array;

import java.util.Objects;

public class ReverseBits {
    public static int reverseBits(String n) {
        int len = 32;
        int number = 0;
        String[] arr = n.split("");
        for (int i = len - 1; i > 0; i--) {
            if (Objects.equals(arr[i], "1")) {
                number += (1 << len - i - 1);
            }
        }
        String a=convertIntegerToBinary(number);
        System.out.println(a);
        return number;
    }

    public static String convertIntegerToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder binaryNumber = new StringBuilder();
        while (n > 0) {
            int remainder = n % 2;
            binaryNumber.append(remainder);
            n /= 2;
        }
        binaryNumber = binaryNumber.reverse();
        return binaryNumber.toString();
    }

    public static void main(String[] args) {
        reverseBits("00000010100101000001111010011100");
        int number = 0;
        number += (1 << 0);
        number += (1 << 1);
        number += (1 << 2);
        System.out.println(number);
    }
}
