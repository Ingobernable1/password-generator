package pl.ingobernable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordValidator {

    String buildRegularExpression(boolean uppercaseLetter, boolean digit, boolean specialSign){

        StringBuilder firstPart = new StringBuilder();
        StringBuilder secondPart = new StringBuilder();

        String allLowercaseLetters = "a-z";
        String allUppercaseLetters = "A-Z";
        String allDigits = "\\d";
        String allSpecialSigns = "!@#$%^&*";

        firstPart.append("^(?=.*[" + allLowercaseLetters + "])");
        secondPart.append("[" + allLowercaseLetters);

        if (uppercaseLetter){
            firstPart.append("(?=.*[" + allUppercaseLetters + "])");
            secondPart.append(allUppercaseLetters);
        }

        if (digit){
            firstPart.append("(?=.*[" + allDigits + "])");
            secondPart.append(allDigits);
        }

        if (specialSign){
            firstPart.append("(?=.*[" + allSpecialSigns + "])");
            secondPart.append(allSpecialSigns);
        }

        secondPart.append("]");
        firstPart.append(secondPart);
        firstPart.append("{1,}$");

        return firstPart.toString();
    }

    boolean isPasswordValid(String password, boolean uppercaseLetter, boolean digit, boolean specialSign){

        String regex = buildRegularExpression(uppercaseLetter, digit, specialSign);
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

}
