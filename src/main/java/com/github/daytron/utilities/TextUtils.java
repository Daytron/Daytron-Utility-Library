/* 
 * The MIT License
 *
 * Copyright 2014 Ryan Gilera ryangilera@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.daytron.utilities;

/**
 * Utility static class for String objects.
 * @author Ryan Gilera ryangilera@gmail.com
 */
public class TextUtils {

    /**
     * Counts how many occurrence of certain string pattern in a given
     * string text.
     * @param pattern The pattern string to compare with.
     * @param word The text to compare to.
     * @return returns the number of occurrences for each matching pattern.
     */
    public static int countHowManyOccurrenceOf(String pattern, String word) {
        if (word == null || pattern == null) {
            return 0;
        }
        
        if (word.isEmpty() || pattern.isEmpty()) {
            return 0;
        }
        
        return (word.length() - word.replace(pattern, "").length()) / pattern.length();
    }

    /**
     * Capitalize only the first letter of a given string.
     * @param word The string text to capitalize.
     * @return A formatted string with the first letter capitalise.
     */
    public static String capitalizeFirstLetterWord(String word) {
        if (word == null) {
            return null;
        }
        
        if (word.isEmpty()) {
            return word;
        }
        
        if (word.length() == 1) {
            return word.toUpperCase();
        }
        
        String newWord = word.trim();
        
        return newWord.substring(0, 1).toUpperCase() + newWord.substring(1);
    }

    /**
     * Capitalize the first letter of each word in a series of words 
     * separated by a space character.
     * @param sentence The text to capitalize.
     * @return A formatted text with each first letter of each word is capitalized.
     */
    public static String capitalizeFirstLetterEachWord(String sentence) {
        if (sentence == null) {
            return null;
        }
        
        if (sentence.isEmpty()) {
            return sentence;
        }
        
        sentence = sentence.trim();
        
        if (sentence.length() == 1) {
            return sentence.toUpperCase();
        }
        
        // Capitalize first word first
        String firstLetterWordFormatted = capitalizeFirstLetterWord(sentence);

        // Converts all first letter of words separated by space to uppercase
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                firstLetterWordFormatted = firstLetterWordFormatted.substring(0, i + 1)
                        + firstLetterWordFormatted.substring(i + 1, i + 2).toUpperCase()
                        + firstLetterWordFormatted.substring(i + 2);
            }
        }

        // Get back the output string reference
        return firstLetterWordFormatted;
    }

    /**
     * Find a string pattern and replace it with a new string pattern of 
     * a string text.
     * @param text The text to find and replace the pattern.
     * @param patternToFind The pattern string to find.
     * @param patternToReplace The pattern string to replace with.
     * @return A formatted text with replaced pattern string.
     */
    public static String findAndReplace(String text, String patternToFind,
            String patternToReplace) {
        if (text == null) {
            return null;
        }

        if (patternToFind == null || patternToReplace == null) {
            return text;
        }

        if (text.isEmpty() || patternToFind.isEmpty() || patternToReplace.isEmpty()) {
            return text;
        }

        if (!text.contains(patternToFind)) {
            return text;
        }

        String newStr = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == patternToFind.charAt(0)) {
                // Verify the next letters is the same as the pattern
                boolean isTheSamePattern = true;
                // Check also if the remaining text is the same length
                // as the pattern to find
                if (text.substring(i).length() >= patternToFind.length()) {
                    for (int j = 0; j < patternToFind.length(); j++) {
                        if (text.charAt(i + j) != patternToFind.charAt(j)) {
                            isTheSamePattern = false;
                            break;
                        }
                    }
                } else {
                    isTheSamePattern = false;
                }

                if (isTheSamePattern) {
                    // Add new pattern
                    newStr = newStr + patternToReplace;
                    
                    // Skips the index to the letter after the pattern.
                    // Minus 1 because the other plus one triggers from the
                    // FOR loop
                    i = i + patternToFind.length() - 1;
                    
                    // Skip the remaining lines and continue looping
                    continue;
                }
            }

            // Regroup back a character to its new string
            newStr = newStr + text.charAt(i);

        }

        return newStr;

    }
}
