package de.tzander.numberNames;

import java.util.HashMap;

public class NumberSpeller {

    HashMap numberNames = new HashMap();

    public NumberSpeller() {
        createNumberMap();
    }

    private void createNumberMap() {
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
        if (length == 1) {
            return getNumberName(number);
        }
        if (isTensNumber(number, length)) {
            return getNumberName(number);
        }
        if (isTwoDigitNumberOverTwenty(number, length)) {
            return get2DigitNumber(number);
        }
        if (length == 3) {
            return get3DigitNumber(number);
        }
        return "unknown number";
    }

    private String get3DigitNumber(int number) {
        if (number % 100 == 0) {
            return getNumberName(number);
        }
        int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));
        int lastTwoDigits = Integer.parseInt(Integer.toString(number).substring(1, 3));
        return getNumberName(firstDigit * 100) + " " + get2DigitNumber(lastTwoDigits);
    }

    private String get2DigitNumber(int number) {
        if (number % 10 == 0) {
            return getNumberName(number);
        } else {
            int firstDigit = Integer.parseInt(Integer.toString(number).substring(0, 1));
            int secondDigit = Integer.parseInt(Integer.toString(number).substring(1, 2));
            return getNumberName(firstDigit * 10) + " " + getNumberName(secondDigit);
        }
    }

    private String getNumberName(int number) {
        return numberNames.get(number).toString();
    }

    private boolean isTwoDigitNumberOverTwenty(int number, int length) {
        return length == 2 && number >= 20;
    }

    private boolean isTensNumber(int number, int length) {
        return length == 2 && number < 20;
    }
}
