package de.tzander.numberNames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberSpellerTest {

    @Test
    void spell_out_one_digit_number(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(3);

        assertEquals("three", spelledNumber);
    }

    @Test
    void spell_out_two_digit_number_under_twenty(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(12);

        assertEquals("twelve", spelledNumber);
    }

    @Test
    void spell_out_two_digit_number_over_twenty_tens(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(30);

        assertEquals("thirty", spelledNumber);
    }

    @Test
    void spell_out_two_digit_number_over_twenty(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(53);

        assertEquals("fifty three", spelledNumber);
    }

    @Test
    void spell_out_simple_three_digit_number(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(200);

        assertEquals("two hundred", spelledNumber);
    }

    @Test
    void spell_out_three_digit_number(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(250);

        assertEquals("two hundred and fifty", spelledNumber);
    }

    @Test
    void spell_out_complex_three_digit_number(){
        var speller = new NumberSpeller();
        String spelledNumber = speller.spellNumber(324);

        assertEquals("three hundred and twenty four", spelledNumber);
    }

    @Test
    void throw_exception_if_number_not_spellable(){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var speller = new NumberSpeller();
            String spelledNumber = speller.spellNumber(31232333);
        });

        Assertions.assertEquals("Number can not be spelled", thrown.getMessage());
    }

}
