package ru.almazvip.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstTaskTest {
    @Test
    public void firstTask_testEmptyString() {
        assertTrue(FirstTask.isValidParentheses(""), "Пустая строка должна быть валидной");
    }

    @Test
    public void firstTask_testSimpleValidPairs() {
        assertTrue(FirstTask.isValidParentheses("()"), "Обычные круглые скобки");
        assertTrue(FirstTask.isValidParentheses("[]"), "Обычные квадратные скобки");
        assertTrue(FirstTask.isValidParentheses("{}"), "Обычные фигурные скобки");
    }

    @Test
    public void firstTask_testSequentialValidPairs() {
        assertTrue(FirstTask.isValidParentheses("()[]{}"), "Последовательные валидные скобки");
    }

    @Test
    public void firstTask_testNestedValidPairs() {
        assertTrue(FirstTask.isValidParentheses("{[()]}"), "Правильно вложенные скобки");
        assertTrue(FirstTask.isValidParentheses("((()))"), "Множественная вложенность одного типа");
    }

    @Test
    public void firstTask_testMismatchedPairs() {
        assertFalse(FirstTask.isValidParentheses("(]"), "Несовпадающий тип скобок");
        assertFalse(FirstTask.isValidParentheses("([)]"), "Пересекающиеся скобки разного типа");
    }

    @Test
    public void firstTask_testMissingOpenBracket() {
        assertFalse(FirstTask.isValidParentheses("]"), "Только закрывающая скобка");
        assertFalse(FirstTask.isValidParentheses("())"), "Лишняя закрывающая скобка в конце");
        assertFalse(FirstTask.isValidParentheses("}[]()"), "Лишняя закрывающая скобка в начале");
    }

    @Test
    public void firstTask_testMissingCloseBracket() {
        assertFalse(FirstTask.isValidParentheses("["), "Только открывающая скобка");
        assertFalse(FirstTask.isValidParentheses("(()"), "Лишняя открывающая скобка");
        assertFalse(FirstTask.isValidParentheses("{[]()"), "Отсутствует закрывающая для первой скобки");
    }

    @Test
    public void firstTask_testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            FirstTask.isValidParentheses(null);
        }, "Передача null должна вызывать NullPointerException");
    }
}
