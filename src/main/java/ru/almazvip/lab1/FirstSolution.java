package ru.almazvip.lab1;

import java.util.Stack;

public class FirstSolution {
    public static boolean isValidParentheses(String data) {
        if (data == null) { throw new NullPointerException(); }

        var chars = new Stack<Character>();

        for (int i = 0; i < data.length(); i++) {
            char current = data.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                chars.push(current);
            } else {
                if (chars.isEmpty()) {
                    return false;
                }

                char top = chars.pop();
                if ((current == ')' && top != '(') ||
                        (current == ']' && top != '[') ||
                        (current == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return chars.isEmpty();
    }
}
