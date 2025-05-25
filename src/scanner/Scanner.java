package scanner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Scanner {

    String input;

    public Scanner(String input) {
        this.input = input;
    }

    public String[] getToken() {
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }

                if (c == ' ') {
                    continue;
                } else {
                    tokens.add(Character.toString(c));
                }
            }
        }

        if (number.length() > 0) {
            tokens.add(number.toString());
        }

        return tokens.toArray(new String[0]);
    }
}
