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

/**
 * Utility static class for Filename string.
 * @author Ryan Gilera ryangilera@gmail.com
 */
public class FilenameUtils {

    /**
     * Verifies if the given extension string is equal to extension of the given
     * file object.
     * @param extension The extension string to compare with.
     * @param file The file to compare to.
     * @return <code>true</code> if the extension matches the file, otherwise,
     * <code>false</code>.
     */
    public static boolean isExtensionEqualsTo(String extension, File file) {
        if (file == null) {
            return false;
        }
        return isExtensionEqualsTo(extension, file.getName());
    }

    /**
     * Verifies if the given extension string is equal to extension of the given
     * filename string.
     * @param extension The extension string to compare with.
     * @param filename The filename string to compare to.
     * @return <code>true</code> if the extension matches the file, otherwise,
     * <code>false</code>.
     */
    public static boolean isExtensionEqualsTo(String extension, String filename) {
        if (extension == null || filename == null) {
            return false;
        }

        extension = extension.toLowerCase();
        filename = filename.toLowerCase();

        if (extension.isEmpty() || filename.isEmpty()) {
            return false;
        }

        if (isValidFileName(filename)) {
            String ext = filename.substring(filename.lastIndexOf(".") + 1);
            return extension.equals(ext);
        } else {
            return false;
        }

    }

    /**
     * Verifies if the given filename string is valid in a sense that it is not null,
     * not empty, has at least a length of 4, contains dot character within its 
     * proper place.
     * @param filename The filename string to verify.
     * @return <code>true</code> if the filename is valid, otherwise,
     * <code>false</code>.
     */
    public static boolean isValidFileName(String filename) {
        if (filename == null || filename.isEmpty()) {
            return false;
        }
        
        if (filename.contains(" ")) {
            return false;
        }

        if (filename.length() < 4) {
            return false;
        }

        filename = filename.toLowerCase();

        if (filename.isEmpty()) {
            return false;
        }

        if (!filename.contains(".")
                || TextUtils.countHowManyOccurrenceOf(".", filename) > 1) {
            return false;
        }

        if (filename.startsWith(".")) {
            return false;
        }
        
        if (filename.endsWith(".")) {
            return false;
        }

        if (filename.indexOf(".") >= filename.length() - 2) {
            return false;
        }

        return true;
    }

    /**
     * Verifies if the given File object's filename is valid in a sense 
     * that it is not null, not empty, has at least a length of 4, 
     * contains dot character within its proper place.
     * @param file The File object to verify.
     * @return <code>true</code> if the filename is valid, otherwise,
     * <code>false</code>.
     */
    public static boolean isValidFileName(File file) {
        if (file == null) {
            return false;
        }
        return isValidFileName(file.getName());
    }
}
