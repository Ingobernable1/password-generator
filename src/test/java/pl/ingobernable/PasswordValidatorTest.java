package pl.ingobernable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    public PasswordValidator pv;

    @BeforeEach
    public void init(){
        pv = new PasswordValidator();
    }

    @Test
    public void test_buildRegularExpression_passwordShouldContainOnlyLowercaseCharacters(){

        //when
       String result = pv.buildRegularExpression(false, false, false);

        //then
        Assertions.assertThat(result).isEqualTo("^(?=.*[a-z])[a-z]{1,}$");
    }

    @Test
    public void test_buildRegularExpression_passwordShouldContainUppercaseAndLowercaseCharacters(){

        //when
        String result = pv.buildRegularExpression(true, false, false);

        //then
        Assertions.assertThat(result).isEqualTo("^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{1,}$");
    }

    @Test
    public void test_buildRegularExpression_passwordShouldContainUppercaseLowercaseAndDigitsCharacters(){

        //when
        String result = pv.buildRegularExpression(true, true, false);

        //then
        Assertions.assertThat(result).isEqualTo("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])[a-zA-Z\\d]{1,}$");
    }

    @Test
    public void test_buildRegularExpression_passwordShouldContainLowercaseAndDigitsCharacters(){

        //when
        String result = pv.buildRegularExpression(false, true, false);

        //then
        Assertions.assertThat(result).isEqualTo("^(?=.*[a-z])(?=.*[\\d])[a-z\\d]{1,}$");
    }

    @Test
    public void test_buildRegularExpression_passwordShouldContainAllKindsOfCharacters(){

        //when
        String result = pv.buildRegularExpression(true, true, true);

        //then
        Assertions.assertThat(result).isEqualTo("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{1,}$");
    }

    @Test
    public void test_isPasswordValid_valid_containOnlyLowercase(){

        //when
        boolean result = pv.isPasswordValid("asdffdgh", false, false, false);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_isPasswordValid_valid_containLowercaseDigitsAndSpecialSign(){

        //when
        boolean result = pv.isPasswordValid("dsfsdd&^%655", false, true, true);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_isPasswordValid_invalid_becauseContainUppercase(){

        //when
        boolean result = pv.isPasswordValid("asdASDffdgh", false, false, false);

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }

    @Test
    public void test_isPasswordValid_invalid_doesntContainDigitAndSpecialSign(){

        //when
        boolean result = pv.isPasswordValid("asdASDffdgh", false, true, true);

        //then
        Assertions.assertThat(result).isEqualTo(false);
    }
}