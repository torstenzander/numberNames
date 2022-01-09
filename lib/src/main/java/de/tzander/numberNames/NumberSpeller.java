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

    public String spellNumber(int number) {
        int length = String.valueOf(number).length();
        if (isOneDigitNumber(length)) {
            return getNumberName(number);
        }
        if (isTensNumber(number, length)) {
            return getNumberName(number);
        }
        if (isTwoDigitNumberOverTwenty(number, length)) {
            return getTwoDigitNumber(number);
    }
        if (isThreeDigitNumber(length)) {
            return getThreeDigitNumber(number);
        }
        throw new IllegalArgumentException("Number can not be spelled");
    }

    private String getThreeDigitNumber(int number) {
        if (number % 100 == 0) {
            return getNumberName(number);
        }
        int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));
        int lastTwoDigits = Integer.parseInt(Integer.toString(number).substring(1, 3));
        return getNumberName(firstDigit * 100) + " and " + getTwoDigitNumber(lastTwoDigits);
    }

    private String getTwoDigitNumber(int number) {
        if (number % 10 == 0) {
            return getNumberName(number);
        } else {
            int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));
            int secondDigit = Integer.parseInt(Integer.toString(number).substring(1, 2));
            return getNumberName(firstDigit * 10) + " " + getNumberName(secondDigit);
        }
    }

    private String getNumberName(int number) {
        return numberNames.get(number);
    }

    private boolean isTwoDigitNumberOverTwenty(int number, int length) {
        return length == 2 && number >= 20;
    }

    private boolean isOneDigitNumber(int length) {
        return length == 1;
    }

    private boolean isThreeDigitNumber(int length) {
        return length == 3;
    }

    private boolean isTensNumber(int number, int length) {
        return length == 2 && number < 20;
    }
}
