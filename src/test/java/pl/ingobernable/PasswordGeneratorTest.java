package pl.ingobernable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordGeneratorTest {

    private PasswordGenerator pg;

    @BeforeEach void init(){
        pg = new PasswordGenerator();
    }

    @Test
    public void test_generatePassword_shouldReturnPassword8LettersLong (){
        //when
        String ps = pg.generatePassword(8,false, false, false);

        //then
        Assertions.assertThat(ps.length()).isEqualTo(8);
    }

    @Test
    public void test_generatePassword_shouldReturnPassword16LettersLong (){
        //when
        String ps = pg.generatePassword(16,false, false, false);

        //then
        Assertions.assertThat(ps.length()).isEqualTo(16);
    }

    @Test
    public void test_generatePassword_shouldReturnPasswordWithMin1UpperCaseLetter(){
        //when
        String ps = pg.generatePassword(16,true, false, false);

        //then
        Assertions.assertThat(new StringBuffer(ps).charAt(13)).isUpperCase();
    }

    @Test
    public void test_generatePassword_shouldReturnPasswordWithMin1Digit(){
        //when
        String ps = pg.generatePassword(16,false, true, false);

        //then
        Assertions.assertThat(new StringBuffer(ps).charAt(14)).isBetween('0', '9');
    }

}