package string;

import java.util.HashSet;

public class HalvesAreAlike {
    public static boolean halvesAreAlike(String s) {
        HashSet<Character> tempSet = new HashSet();
        int low = 0;
        int n = s.length();
        int high = n;
        int mid = (low + high) / 2;
        if (countVowels(s.substring(low, mid)) == countVowels(s.substring(mid))) {
            return true;
        }
        return false;
    }

    public static int countVowels(String s) {
        System.out.println(s);
        int count = 0;
        HashSet<Character> tempSet = new HashSet();
        tempSet.add('a');
        tempSet.add('e');
        tempSet.add('i');
        tempSet.add('o');
        tempSet.add('u');
        tempSet.add('A');
        tempSet.add('E');
        tempSet.add('I');
        tempSet.add('O');
        tempSet.add('U');
        int low = 0;
        int n = s.length();
        int high = n - 1;
        while (low <= high) {
            if (tempSet.contains(s.charAt(low))) {
                count++;
            }
            if (low!=high && tempSet.contains(s.charAt(high))) {
                count++;
            }
            low++;
            high--;
        }

        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        String s = "vicLNiPhieoGZPAuujviJmaEVxUeuciIfilirTvQYXUnfPgrkJGdiiugUWeaixWVaRoobIAkNShIKUeueEIREipewpUaTkXUBkaupUesSOQeAuZgyYmWiteeLkbdXPaxAmRrNUIsIOAzaOEVTkGUApZhFRgSkBgtttvghZAeaqkaNZUpEUkiuhyIOoRUDEeZOruSAkyAbpuIeSUPXlEAeUTKOaaQaSkQFkcOvpOiqJKJdacgvqJEEFqauJjIljOiEhYVUYaHNINgmCRdWbcKVQUIUpouxIVUOvayOsEmwVUAixtLCZaiVAZDeUyoenABIIuPuuTInKUcQcaiIQxPrpooaxaSdeElWvUUukkGEsymozPhEZmueAJyFv";
        boolean flag = halvesAreAlike(s);
        System.out.println(flag);
    }
}
