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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class for TextUtils class
 * @author Ryan Gilera ryangilera@gmail.com
 */
public class TextUtilsTest {
    
    public TextUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countHowManyOccurrenceOf method, of class TextUtils.
     */
    @Test
    public void testCountHowManyOccurenceOf_String_String() {
        System.out.println("Test: countHowManyOccurenceOf(String, String)");
        
        // given:        
        String[] listOfPatternsInput = new String[]{
            "l", // 1
            "en", // 2
            "foo", // 3
            "o", // 4
            "foo", // 5
            "foo", // 6
            "bar", // 7
            " ", // 8
            "O"}; // 9
               
        String[] listOfWordsInput = new String[]{
            "hello", // 1
            "This is a sentence.", // 2
            "foo bar foofoofoo", // 3
            "foo bar foofoofoo", // 4
            "This is a sentence.", // 5
            "", // 6
            null, // 7
            "         hello     ", // 8
            "eeeeeeeeeeoeeeeoeee"}; // 9
        
        int[] listOfExpectedResults = {
            2, // 1
            2, // 2
            4, // 3
            8, // 4
            0, // 5
            0, // 6
            0, // 7
            14, // 8
            0}; // 9
        
        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when
            int result = TextUtils.countHowManyOccurrenceOf(
                    listOfPatternsInput[i],
                    listOfWordsInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }
        
    }

    /**
     * Test of capitalizeFirstLetterWord method, of class TextUtils.
     */
    @Test
    public void testCapitalizeFirstLetterWord() {
        System.out.println("Test: capitalizeFirstLetterWord(String)");
        
        // given:        
        String[] listOfStringsInput = new String[]{
            "hello", // 1
            "HELLO", // 2
            "hELLO", // 3
            " hello", // 4
            " h e l l o", // 5
            "", // 6
            null, // 7
            "         hello     ", // 8
            "h"}; // 9
        
        String[] listOfExpectedResults = new String[]{
            "Hello", // 1
            "HELLO", // 2
            "HELLO", // 3
            "Hello", // 4
            "H e l l o", // 5
            "", // 6
            null, // 7
            "Hello", // 8
            "H"}; // 9
        
        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when
            String result = TextUtils.capitalizeFirstLetterWord(
                    listOfStringsInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }
    }

    /**
     * Test of capitalizeFirstLetterEachWord method, of class TextUtils.
     */
    @Test
    public void testCapitalizeFirstLetterEachWord_String() {
        System.out.println("Test: capitalizeFirstLetterEachWord(String)");
        
        // given:        
        String[] listOfStringsInput = new String[]{
            "hello World", // 1
            "HELLO THERE!", // 2
            "hELLO wORLD", // 3
            " hello   world.", // 4
            " h e l l o        ", // 5
            "", // 6
            null, // 7
            "h"}; // 8
        
        String[] listOfExpectedResults = new String[]{
            "Hello World", // 1
            "HELLO THERE!", // 2
            "HELLO WORLD", // 3
            "Hello   World.", // 4
            "H E L L O", // 5
            "", // 6
            null, // 7
            "H"}; // 8
        
        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when
            String result = TextUtils.capitalizeFirstLetterEachWord(
                    listOfStringsInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }
        
    }

    /**
     * Test of findAndReplace method, of class TextUtils.
     */
    @Test
    public void testFindAndReplace_String_String_String() {
        System.out.println("Test: findAndReplace(String, String, String)");
        
        // given:
        String[] listOfTextInput = new String[]{
            "avocado", // 1 Single character to replace
            "Hello World", // 2 Multiple pattern pattern (one char) to replace
            "This is a sentence.", // 3 Multiple pattern (two chars) to replace
            "", // 4 Empty text
            "Hello World.", // 5 Empty pattern to find
            "Hello World.", // 6 Empty pattern to replace
            null, // 7 Null text
            "Hello World.", // 8 Null pattern to find
            "Hello World."}; // 9 Null pattern to replace
        
        String[] listOfPatternsToFindInput = new String[]{
            "v", // 1
            "o", // 2
            "en", // 3
            "hello there", // 4
            "", // 5
            "World", // 6
            "Hello", // 7
            null, // 8
            "Hello"}; // 9
        
        String[] listOfPatternToReplaceInput = new String[]{
            "b", // 1
            "a", // 2
            "xx", // 3
            "Yo!", // 4
            "Hey!!!!!", // 5
            "", // 6
            "Hey", // 7
            "Hey", // 8
            null}; // 9
        
        String[] listOfExpectedResults = new String[]{
            "abocado", // 1
            "Hella Warld", // 2
            "This is a sxxtxxce.", // 3
            "", // 4
            "Hello World.", // 5
            "Hello World.", // 6
            null, // 7
            "Hello World.", // 8
            "Hello World."}; // 9
        
        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when
            String result = TextUtils.findAndReplace(
                    listOfTextInput[i],
                    listOfPatternsToFindInput[i],
                    listOfPatternToReplaceInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }
    }
    
}
