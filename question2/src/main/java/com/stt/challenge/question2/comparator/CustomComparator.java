package com.stt.challenge.question2.comparator;

import java.util.Comparator;

public class CustomComparator implements Comparator<String> {
    private static final String SPACE = " ";

    @Override
    public int compare(String s1, String s2) {

        // Special cases:
        // 1) Spaces before letters
        if (s1.equals(SPACE) && !s2.equals(SPACE)) {
            return -1; // space (s1) before letter (s2)
        } else if (!s1.equals(SPACE) && s2.equals(SPACE)) {
            return 1; // space (s2) before letter (s1)
        }

        // 2) Upper case before lower case
        boolean isS1Upper = Character.isUpperCase(s1.charAt(0));
        boolean isS2Upper = Character.isUpperCase(s2.charAt(0));

        if (isS1Upper && !isS2Upper) {
            return -1; // upper (s1) before lower (s2)
        } else if (!isS1Upper && isS2Upper) {
            return 1; // upper (s2) before lower (s1)
        }
         // Else, just compare
        return s1.compareTo(s2);
    }
}