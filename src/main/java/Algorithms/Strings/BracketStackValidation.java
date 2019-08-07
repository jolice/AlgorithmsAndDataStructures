package Algorithms.Strings;

import DataStructures.Stack;

public class BracketStackValidation {

    public boolean evaluate(String expression) {
        int length = expression.length();
        Stack<Character> stack = new Stack<>(length);

        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);

            switch (ch) {
                case '{':
                case '(':
                case '[':
                    // Открывающая скобка - не проверяем, заносим в стек
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        // вообще, тип - char, но стек - интовый
                        char opening = stack.pop();
                        // Если последняя открывающая скобка не соответсвтует текущей закрывающей скобок, выражение неверно
                        if (ch == '}' && opening != '{' || ch == ')' && opening != '(' || ch == ']' && opening != '[') {
                            return false;
                        }
                    } else {
                        // Преждевременная нехватка элементов. Закрывающая скобка - есть, а открывающей - нет
                        return false;
                    }
                    break;
                 default:
                     // рассматриваем только скобки
                     break;
            }
        }
        return true;
    }
}
