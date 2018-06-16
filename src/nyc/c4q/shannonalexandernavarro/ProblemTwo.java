package nyc.c4q.shannonalexandernavarro;

import java.util.Stack;

/**
 * Created by shannonalexander-navarro on 6/16/18.
 */
public class ProblemTwo {

    public static String decodeString(String s) {
        Stack<Character> ltrStk = new Stack<Character>();
        Stack<Character> numStk = new Stack<Character>();
        Stack<Character> tempStk = new Stack<Character>();
        Stack<Character> rightBrackets = new Stack<Character>();
        StringBuilder decoded = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();
        boolean isPair = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);
            if (curr == ']') {
                rightBrackets.push(curr);
                isPair = false;
            } else if (curr == '[') {
                rightBrackets.pop();
                isPair = true;
            } else if (Character.isLetter(curr) && !isPair) {
                tempStk.push(curr);
            } else if (Character.isDigit(curr) && i == 0) {
                numStk.push(curr);
                for (int j = tempStr.length() - 1; j >= 0; j--) {
                    ltrStk.push(tempStr.charAt(j));
                }
                while (!tempStk.empty()) {
                    ltrStk.push(tempStk.pop());
                }
                decoded.append(strHelper(ltrStk, numStk));
            } else if (Character.isDigit(curr)) {
                numStk.push(curr);
            } else if (Character.isLetter(curr) && isPair && !numStk.empty()) {
                tempStr.append(strHelper(tempStk, numStk));
                tempStk.push(curr);
                isPair = false;
            }
        }
        return decoded.toString();
    }

    public static String strHelper(Stack ltrStk, Stack numStk) {
        StringBuilder intStr = new StringBuilder();
        StringBuilder decoded = new StringBuilder();
        StringBuilder strToAdd = new StringBuilder();

        while (!numStk.empty()) {
            intStr.append(numStk.pop());
        }
        int times = Integer.parseInt(intStr.toString());
        while (!ltrStk.empty()) {
            strToAdd.append(ltrStk.pop());
        }
        for (int j = 0; j < times; j++) {
            decoded.append(strToAdd);
        }
        return decoded.toString();
    }
}
