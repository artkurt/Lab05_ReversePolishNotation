package postfix;

import stack.LinkedListStack;

public class Infix {

    public String toPostfix(String infix) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // Ignoriere Leerzeichen
            if (Character.isWhitespace(c)) {
                continue;
            }

            // Wenn Operand (Zahl oder Buchstabe), direkt an postfix anhängen
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // Wenn '(' dann auf Stack pushen
            else if (c == '(') {
                stack.push(c);
            }
            // Wenn ')' dann pop bis '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.top() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.top() == '(') {
                    stack.pop(); // '(' entfernen
                }
            }
            // Operator
            else {
                while (!stack.isEmpty() && precedence(stack.top()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // holt restliche Operatoren vom Stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private int precedence(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}
