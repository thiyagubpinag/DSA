package com.cses;

import java.util.Stack;

public class Collide {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty()) {
                int temp = asteroids[i];
                if (isCollide(temp, stack.peek())) {
                    while (!stack.isEmpty() && isCollide(temp, stack.peek())) {
                        int stackValue = stack.pop();
                        temp = collideAndMerge(stackValue, temp);
                        if (temp == Integer.MIN_VALUE) {
                            break;
                        }
                    }
                    if (temp != Integer.MIN_VALUE) {
                        stack.push(temp);
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            } else {
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        int index = 0;
        for (int i = 0; i < stack.size(); i++) {
            res[index++] = stack.get(i);
        }
        return res;
    }

    int collideAndMerge(int stackValue, int tempValue) {
        int a = Math.abs(stackValue);
        int b = Math.abs(tempValue);

        if (a == b) {
            return Integer.MIN_VALUE;
        }
        int max = Math.max(a, b);
        if (max == stackValue || max == tempValue) {
            return max;
        }
        return -max;
    }


    boolean isCollide(int number1, int number2) {
        boolean negFlag = false;
        boolean posFlag = false;
        if (number1 < 0 || number2 < 0) {
            negFlag = true;
        }
        if (number1 < 0 || number2 < 0) {
            posFlag = true;
        }
        return negFlag && posFlag;
    }

    public static void main(String[] args) {
        int[] asteroids = {2,8, -8};
        Collide a = new Collide();
        a.asteroidCollision(asteroids);
    }
}
