package de.tzander.numberNames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberSpellerTest {

    @Test
    void shouldSpellOutOneDigitNumber(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(3);

        assertEquals("three", spelledNumber);
    }

    @Test
    void shouldSpellOutTwoDigitNumberUnderTwenty(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(12);

        assertEquals("twelve", spelledNumber);
    }

    @Test
    void shouldSpellOutTwoDigitNumberOverTwentyTens(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(30);

        assertEquals("thirty", spelledNumber);
    }

    @Test
    void shouldSpellOutTwoDigitNumberOverTwenty(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(53);

        assertEquals("fifty three", spelledNumber);
    }

    @Test
    void shouldSpellOutSimpleThreeDdigitNumber(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(200);

        assertEquals("two hundred", spelledNumber);
    }

    @Test
    void shouldSpellOutThreeDigitNumber(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(250);

        assertEquals("two hundred and fifty", spelledNumber);
    }

    @Test
    void shouldSpellOutComplexThreeDigitNumber(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(324);

        assertEquals("three hundred and twenty four", spelledNumber);
    }

    @Test
    void shouldThrowExceptionIfNumberNotSpellable(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var speller = new NumberSpeller();
            speller.spellNumber(31232333);
        });

        Assertions.assertEquals("Number can not be spelled", thrown.getMessage());
    }

}
