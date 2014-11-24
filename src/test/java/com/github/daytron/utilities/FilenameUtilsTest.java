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

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class for FilenameUtils class
 * @author Ryan Gilera ryangilera@gmail.com
 */
public class FilenameUtilsTest {

    public FilenameUtilsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isExtensionEqualsTo method, of class FilenameUtils.
     */
    @Test
    public void testIsExtensionEqualsTo_String_File() {
        System.out.println("Test: isExtensionEqualsTo(String, File)");
        
        // given:        
        String[] listOfExtensionsInput = new String[]{
            "deb", // 1
            "", // 2
            null, // 3
            "json", // 4
            "json", // 5
            "json", // 6
            "json", // 7
            "exe"}; // 8

        File[] listOfFilesInput = new File[]{
            new File("hello.deb"), // 1
            new File("hello.deb"), // 2
            new File("hello.deb"), // 3
            new File(""), // 4
            null, // 5
            new File("hello."), // 6
            new File("a.json"), // 7
            new File("package")};  // 8

        boolean[] listOfExpectedResults = {
            true, // 1
            false, // 2 
            false, // 3
            false, // 4
            false, // 5
            false, // 6
            true, // 7
            false}; // 8

        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when
            boolean result = FilenameUtils.isExtensionEqualsTo(
                    listOfExtensionsInput[i],
                    listOfFilesInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }

    }

    /**
     * Test of isExtensionEqualsTo method, of class FilenameUtils.
     */
    @Test
    public void testIsExtensionEqualsTo_String_String() {
        System.out.println("Test: isExtensionEqualsTo(String, String)");
        
        // given:
        String[] listOfExtensionsInput = new String[]{
            "deb", // 1
            "", // 2
            null, // 3
            "json", // 4
            "json", // 5
            "json", // 6
            "json", // 7
            "exe"}; // 8

        String[] listOfFilenamesInput = new String[]{
            "hello.deb", // 1
            "hello.deb", // 2
            "hello.deb", // 3
            "", // 4
            null, // 5
            "hello.", // 6
            "a.json", // 7
            "package"};  // 8

        boolean[] listOfExpectedResults = {
            true, // 1
            false, // 2 
            false, // 3
            false, // 4
            false, // 5
            false, // 6
            true, // 7
            false}; // 8

        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when
            boolean result = FilenameUtils.isExtensionEqualsTo(
                    listOfExtensionsInput[i],
                    listOfFilenamesInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }

    }

    /**
     * Test of isValidFileName method, of class FilenameUtils.
     */
    @Test
    public void testIsValidFileName_String() {
        System.out.println("Test: isValidFileName(String)");
        
        // given:
        String[] listOfFilenamesInput = new String[]{
            "hello.deb", // 1
            "", // 2
            null, // 3
            "hello.", // 4
            ".exe", // 5
            "hello", // 6
            ".he.", // 7
            "a.ai", // 8
            "b.c", // 9
            "   ", // 10
            "hello .test"}; // 11

        boolean[] listOfExpectedResults = {
            true, // 1
            false, // 2 
            false, // 3
            false, // 4
            false, // 5
            false, // 6
            false, // 7
            true, // 8
            false, // 9
            false, // 10
            false}; // 11

        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when:
            boolean result = FilenameUtils.isValidFileName(listOfFilenamesInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }

    }

    /**
     * Test of isValidFileName method, of class FilenameUtils.
     */
    @Test
    public void testIsValidFileName_File() {
        System.out.println("Test: isValidFileName(File)");
        
        // given:
        File[] listOfFilesInput = new File[]{
            new File("hello.deb"), // 1
            new File(".."), // 2
            new File("."), // 3
            new File(""), // 4
            null, // 5
            new File("hello."), // 6
            new File("a.j"), // 7
            new File("package"), // 8
            new File("img.ai")};  // 9
        
        boolean[] listOfExpectedResults = {
            true, // 1
            false, // 2 
            false, // 3
            false, // 4
            false, // 5
            false, // 6
            false, // 7
            false, // 8
            true}; // 9

        for (int i = 0; i < listOfExpectedResults.length; i++) {
            // when:
            boolean result = FilenameUtils.isValidFileName(listOfFilesInput[i]);

            // then:
            assertEquals(listOfExpectedResults[i], result);
            System.out.println("scenario: " + (i + 1) + ", result: " + result + ", expected: " + listOfExpectedResults[i]);
        }

    }


}
