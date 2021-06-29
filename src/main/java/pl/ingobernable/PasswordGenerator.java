package pl.ingobernable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class PasswordGenerator {

    private final Character[] lowerCaseChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final Character[] upperCaseChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final Character[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    private final Character[] specialSigns = {'!', '@', '#', '$', '%', '^', '&', '*'};

    String generatePassword(int currentValue, boolean upperCase, boolean digit, boolean specialSign){

        List<Character> listOfChars = new ArrayList<>(getListOfPossibleChars(upperCase, digit, specialSign));
        StringBuilder builder = new StringBuilder(currentValue);

        for (int i = 0; i < currentValue; i++){
            appendCharacter(listOfChars, builder, i, currentValue, upperCase, digit, specialSign);
        }
        return builder.toString();
    }

    private List<Character> getListOfPossibleChars(boolean upperCase, boolean digit, boolean specialSign){

        List<Character> possibleChars = new ArrayList<>(Arrays.asList(lowerCaseChars));

        if (upperCase)
            possibleChars.addAll(Arrays.asList(upperCaseChars));

        if (digit)
            possibleChars.addAll(Arrays.asList(digits));

        if (specialSign)
            possibleChars.addAll(Arrays.asList(specialSigns));

        return possibleChars;
    }

    private void appendCharacter(List<Character> listOfChars,StringBuilder builder, int loop, int currentValue, boolean upperCase, boolean digit, boolean specialSign){

        Random random = new Random();

        int upperCaseIndex = currentValue - 3;
        int digitIndex = currentValue - 2;
        int specialSignIndex = currentValue - 1;

        if (upperCase && loop == upperCaseIndex)
            builder.append(Arrays.asList(upperCaseChars).get(random.nextInt(upperCaseChars.length)));

        else if (digit && loop == digitIndex)
            builder.append(Arrays.asList(digits).get(random.nextInt(digits.length)));

        else if (specialSign && loop == specialSignIndex)
            builder.append(Arrays.asList(specialSigns).get(random.nextInt(specialSigns.length)));

        else
            builder.append(listOfChars.get(random.nextInt(listOfChars.size())));

    }
}
