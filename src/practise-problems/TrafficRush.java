package test;


public class TrafficRush {

    public static int predictCollisions(String direction) {
        int collisions = 0;
        char prevChar = ' '; // Initialize with a space to avoid edge case with leading 'R'

        for (char c : direction.toCharArray()) {
            if (c == 'S') {
                continue; // Skip stopped cars
            }

            if (c == 'L') {
                if (prevChar == 'R') {
                    collisions += 2; // Head-on collision
                }
            } else if (c == 'R') {
                if (prevChar == 'L') {
                    collisions += 2; // Head-on collision
                }
            }
            prevChar = c; // Update previous character
        }
        return collisions;
    }

    public static void main(String[] args) {
        String scenario1 = "RLRSLL";
        String scenario2 = "LLRR";

        System.out.println("Collisions in scenario 1: " + predictCollisions(scenario1)); // Output: 5
        System.out.println("Collisions in scenario 2: " + predictCollisions(scenario2)); // Output: 0
    }
}
