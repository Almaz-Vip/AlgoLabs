package ru.almazvip.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstSolutionTest {
    @Test
    public void firstSolution_testEmptyString() {
        assertTrue(FirstSolution.isValidParentheses(""), "Пустая строка должна быть валидной");
    }

    @Test
    public void firstSolution_testSimpleValidPairs() {
        assertTrue(FirstSolution.isValidParentheses("()"), "Обычные круглые скобки");
        assertTrue(FirstSolution.isValidParentheses("[]"), "Обычные квадратные скобки");
        assertTrue(FirstSolution.isValidParentheses("{}"), "Обычные фигурные скобки");
    }

    @Test
    public void firstSolution_testSequentialValidPairs() {
        assertTrue(FirstSolution.isValidParentheses("()[]{}"), "Последовательные валидные скобки");
    }

    @Test
    public void firstSolution_testNestedValidPairs() {
        assertTrue(FirstSolution.isValidParentheses("{[()]}"), "Правильно вложенные скобки");
        assertTrue(FirstSolution.isValidParentheses("((()))"), "Множественная вложенность одного типа");
    }

    @Test
    public void firstSolution_testMismatchedPairs() {
        assertFalse(FirstSolution.isValidParentheses("(]"), "Несовпадающий тип скобок");
        assertFalse(FirstSolution.isValidParentheses("([)]"), "Пересекающиеся скобки разного типа");
    }

    @Test
    public void firstSolution_testMissingOpenBracket() {
        assertFalse(FirstSolution.isValidParentheses("]"), "Только закрывающая скобка");
        assertFalse(FirstSolution.isValidParentheses("())"), "Лишняя закрывающая скобка в конце");
        assertFalse(FirstSolution.isValidParentheses("}[]()"), "Лишняя закрывающая скобка в начале");
    }

    @Test
    public void firstSolution_testMissingCloseBracket() {
        assertFalse(FirstSolution.isValidParentheses("["), "Только открывающая скобка");
        assertFalse(FirstSolution.isValidParentheses("(()"), "Лишняя открывающая скобка");
        assertFalse(FirstSolution.isValidParentheses("{[]()"), "Отсутствует закрывающая для первой скобки");
    }

    @Test
    public void firstSolution_testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            FirstSolution.isValidParentheses(null);
        }, "Передача null должна вызывать NullPointerException");
    }
}
