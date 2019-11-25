package com.lugowoy.tasks.encodeAndDecodeTwoCharactersInSuitableIntegerVariable;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.ReadingConsole;

/**
 * Encode and decode the two characters into a suitable integer variable.
 * <p>
 * Created by Konstantin Lugowoy on 08.11.2017.
 */

public class Main {

    private static final Reader READER = Reader.getReader(new ReadingConsole());

    public static void main(String[] args) {

        System.out.println("Enter the first character : ");
        char firstCharacterBeforeEncoding = READER.readChar();

        System.out.println("Enter the second character : ");
        char secondCharacterBeforeEncoding = READER.readChar();

        int numberOfTwoCharacter = encode(firstCharacterBeforeEncoding, secondCharacterBeforeEncoding);

        System.out.println("Code number : " + numberOfTwoCharacter);

        char decodingFirstCharacter = decodeFirstCharacter(numberOfTwoCharacter);
        char decodingSecondCharacter = decodeSecondCharacter(numberOfTwoCharacter, decodingFirstCharacter);

        System.out.println();
        System.out.println("Decoding.");
        System.out.println("First character : " + decodingFirstCharacter);
        System.out.println("Second character : " + decodingSecondCharacter);

    }

    private static int encode(char firstCharacter, char secondCharacter) {
        return (((int) firstCharacter << 16)) + ((int) secondCharacter);
    }

    private static char decodeSecondCharacter(int number, char character) {
        return (char) (number ^ ((int) character << 16));
    }

    private static char decodeFirstCharacter(int number) {
        return (char) (number >>> 16);
    }

}
