package ru.almazvip.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParenthesesCheckTest {
    @Test
    public void parenthesesCheck_testEmptyString() {
        assertTrue(ParenthesesCheck.isValidParentheses(""), "Пустая строка должна быть валидной");
    }

    @Test
    public void parenthesesCheck_testSimpleValidPairs() {
        assertTrue(ParenthesesCheck.isValidParentheses("()"), "Обычные круглые скобки");
        assertTrue(ParenthesesCheck.isValidParentheses("[]"), "Обычные квадратные скобки");
        assertTrue(ParenthesesCheck.isValidParentheses("{}"), "Обычные фигурные скобки");
    }

    @Test
    public void parenthesesCheck_testSequentialValidPairs() {
        assertTrue(ParenthesesCheck.isValidParentheses("()[]{}"), "Последовательные валидные скобки");
    }

    @Test
    public void parenthesesCheck_testNestedValidPairs() {
        assertTrue(ParenthesesCheck.isValidParentheses("{[()]}"), "Правильно вложенные скобки");
        assertTrue(ParenthesesCheck.isValidParentheses("((()))"), "Множественная вложенность одного типа");
    }

    @Test
    public void parenthesesCheck_testMismatchedPairs() {
        assertFalse(ParenthesesCheck.isValidParentheses("(]"), "Несовпадающий тип скобок");
        assertFalse(ParenthesesCheck.isValidParentheses("([)]"), "Пересекающиеся скобки разного типа");
    }

    @Test
    public void parenthesesCheck_testMissingOpenBracket() {
        assertFalse(ParenthesesCheck.isValidParentheses("]"), "Только закрывающая скобка");
        assertFalse(ParenthesesCheck.isValidParentheses("())"), "Лишняя закрывающая скобка в конце");
        assertFalse(ParenthesesCheck.isValidParentheses("}[]()"), "Лишняя закрывающая скобка в начале");
    }

    @Test
    public void parenthesesCheck_testMissingCloseBracket() {
        assertFalse(ParenthesesCheck.isValidParentheses("["), "Только открывающая скобка");
        assertFalse(ParenthesesCheck.isValidParentheses("(()"), "Лишняя открывающая скобка");
        assertFalse(ParenthesesCheck.isValidParentheses("{[]()"), "Отсутствует закрывающая для первой скобки");
    }

    @Test
    public void parenthesesCheck_testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            ParenthesesCheck.isValidParentheses(null);
        }, "Передача null должна вызывать NullPointerException");
    }
}
