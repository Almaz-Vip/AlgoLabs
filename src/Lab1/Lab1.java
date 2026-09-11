package Lab1;

import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;

public class Lab1 {
    // Функция первого задания
    public static boolean isValidParentheses(String data) {
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

    // Функция второго задания
    public static int removeElementInplace(List<Integer> arr, int val) {
        arr.removeIf(Predicate.isEqual(val));
        return arr.size();
    }
}
