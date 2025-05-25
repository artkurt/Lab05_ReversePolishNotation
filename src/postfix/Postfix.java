package postfix;

import stack.LinkedListStack;
import stack.Underflow;

public class Postfix {

    public double evaluate(String postfix) throws Underflow {
        LinkedListStack<Double> stack = new LinkedListStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // Leerzeichen überspringen
            if (Character.isWhitespace(c)) {
                continue;
            }

            // Wenn Operand (Zahl) dann pushen
            if (Character.isDigit(c)) {
                // Annahme: nur einstellig, sonst müsste man erweitern
                stack.push((double)(c - '0'));
            }
            // Operator
            else {
                // Mindestens zwei Operanden zum Ausführen nötig
                if (stack.isEmpty()) throw new Underflow();
                double right = stack.pop();

                if (c == '~') { 
                    // Beispiel für einfachen Operator, falls gewünscht (hier Negation)
                    stack.push(-right);
                    continue;
                }

                if (stack.isEmpty()) throw new Underflow();
                double left = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(left / right);
                        break;
                    case '^':
                        stack.push(Math.pow(left, right));
                        break;
                    default:
                        throw new IllegalArgumentException("Unbekannter Operator: " + c);
                }
            }
        }

        if (stack.isEmpty()) throw new Underflow();
        double result = stack.pop();

        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Ungültiger Ausdruck: Mehrere Werte auf Stack nach Auswertung");
        }

        return result;
    }
}
