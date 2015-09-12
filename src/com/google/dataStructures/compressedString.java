package com.google.dataStructures;

public class compressedString {
    public static String compressString(String input) {
        StringBuffer compressedString = new StringBuffer();

        char currentCharacter = input.charAt(0);
        int currentCharacterNumber = 1;

        for (int i = 1; i < input.length(); i ++) {
            if (input.charAt(i) == currentCharacter) {
                currentCharacterNumber++;
            } else {
                compressedString.append(currentCharacter);
                compressedString.append(currentCharacterNumber);

                currentCharacter = input.charAt(i);
                currentCharacterNumber = 1;
            }
        }

        if (input.length() >= compressedString.length()) {
            return input;
        }

        return compressedString.toString();
    }
}
