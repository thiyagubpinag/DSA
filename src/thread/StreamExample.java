package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> input= new ArrayList<>(List.of("1","2","3","4","5","6"));

        String output=input.stream().map(i->getWord(i)).collect(Collectors.joining(","));
        System.out.println(output);


    }

    public static String getWord(String a){
        return switch (a) {
            case "1" -> "ONE";
            case "2" -> "TWO";
            case "3" -> "THREE";
            case "4" -> "FOUR";
            case "5" -> "FIVE";
            case "6" -> "SIX";
            default -> "None";
        };
    }
}
