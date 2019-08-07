package Algorithms.Strings;

import DataStructures.Stack;

public class StringStackReverse {

    public String reverse(String str) {
        Stack<Character> stack = new Stack<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            sb.append(c);
        }
        return sb.toString();
    }
}
