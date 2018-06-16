package nyc.c4q.shannonalexandernavarro;

import java.util.HashMap;

public class ProblemOne {

    public static void main(String[] args) {
	// write your code here
    }

    public static String sortByString(String s, String t) {
        StringBuilder sortedStrBldr = new StringBuilder();
        HashMap<Character, Integer> ltrMap = new HashMap<Character, Integer>();
        char ltrToCheck;
        int iterations = 0;

        for (char c : s.toCharArray()) {
            if (ltrMap.containsKey(c)) {
                ltrMap.put(c, ltrMap.get(c) + 1);
            } else {
                ltrMap.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            ltrToCheck = t.charAt(i);
            if (ltrMap.containsKey(ltrToCheck)) {
                int value = ltrMap.get(ltrToCheck);
                while (iterations < value) {
                    sortedStrBldr.append(ltrToCheck);
                    iterations++;
                }
                iterations = 0;
            }
        }
        return sortedStrBldr.toString();
    }
}
