package string;

import java.util.*;

public class FrequencySort {
    static class MapCharacter {
        Character key;
        Integer value;

        public MapCharacter(Character key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    static class SortbyValue implements Comparator<MapCharacter> {

        public int compare(MapCharacter a, MapCharacter b) {

            return b.value - a.value;
        }
    }

    public static String frequencySort(String s) {
        ArrayList<MapCharacter> mapList = new ArrayList<>();
        for (int i = 0; i <= 122; i++) {
            MapCharacter mapCharacter = new MapCharacter((char) i, 0);
            mapList.add(mapCharacter);
        }
        for (int i = 0; i < s.length(); i++) {
            MapCharacter temp = mapList.get(s.charAt(i));
            temp.value++;
            mapList.set(s.charAt(i), temp);
        }
        Collections.sort(mapList, new SortbyValue());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < mapList.size(); i++) {
            if (mapList.get(i).value == 0) {
                break;
            }
            for (int j = 0; j < mapList.get(i).value; j++) {
                res.append(mapList.get(i).key);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(((int)'z'));
        String res = frequencySort("aabb");
        System.out.println(res);
        String a="aaab";
        int c=a.indexOf('b');
        HashSet<Character> tempSet=new HashSet();
        tempSet.add('a');tempSet.add('e');tempSet.add('i');tempSet.add('o');tempSet.add('u');
        tempSet.add('A');tempSet.add('E');tempSet.add('I');tempSet.add('O');tempSet.add('U');
    }
}
