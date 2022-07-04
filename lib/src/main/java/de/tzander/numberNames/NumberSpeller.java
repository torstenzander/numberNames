package de.tzander.numberNames;

import java.util.HashMap;
import java.util.Map;

public class NumberSpeller {

    private static final Map<Integer, String> numberNames = new HashMap<>();

    static {
        numberNames.put(0, "zero");
        numberNames.put(1, "one");
        numberNames.put(2, "two");
        numberNames.put(3, "three");
        numberNames.put(4, "four");
        numberNames.put(5, "five");
        numberNames.put(6, "six");
        numberNames.put(10, "ten");
        numberNames.put(11, "eleven");
        numberNames.put(12, "twelve");
        numberNames.put(13, "thirteen");
        numberNames.put(20, "twenty");
        numberNames.put(30, "thirty");
        numberNames.put(40, "forty");
        numberNames.put(50, "fifty");
        numberNames.put(100, "one hundred");
        numberNames.put(200, "two hundred");
        numberNames.put(300, "three hundred");
    }

    public String spellNumber(int number) throws IllegalArgumentException {
        int length = String.valueOf(number).length();

        if (isOneDigitNumber(length)) return getNumberName(number);
        if (isTennerNumber(number, length)) return getNumberName(number);
        if (isTennerOverTwenty(number, length)) return getTennerNumber(number);
        if (isHundredsNumber(length)) return getHundredNumber(number);

        throw new IllegalArgumentException("Number can not be spelled");
    }

    private String getHundredNumber(int number) {
        if (number % 100 == 0) {
            return getNumberName(number);
        }
        int lastTwoDigits = parseForSubstring(number, 1, 3);
        return getNumberName(getFirstDigitFromNumber(number) * 100)
                + " and " + getTennerNumber(lastTwoDigits);
    }

    private int parseForSubstring(int number, int beginIndex, int endIndex) {
        return Integer.parseInt(Integer.toString(number).substring(beginIndex, endIndex));
    }

    private String getTennerNumber(int number) {
        if (number % 10 == 0) {
            return getNumberName(number);
        } else {
            int secondDigit = parseForSubstring(number, 1, 2);
            return getNumberName(getFirstDigitFromNumber(number) * 10)
                    + " " + getNumberName(secondDigit);
        }
    }

    private int getFirstDigitFromNumber(int number) {
        return parseForSubstring(number, 0, 1);
    }

    private String getNumberName(int number) {
        return numberNames.get(number);
    }

    private boolean isTennerOverTwenty(int number, int length) {
        return length == 2 && number >= 20;
    }

    private boolean isOneDigitNumber(int length) {
        return length == 1;
    }

    private boolean isHundredsNumber(int length) {
        return length == 3;
    }

    private boolean isTennerNumber(int number, int length) {
        return length == 2 && number < 20;
    }
}
