/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.task;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 * найти слова в большом файле
 *
 * @author churganov_r   01.2009
 */
class FindWords {

    private RandomAccessFile source;
    private byte[] byteWord;
    private int wordCounter;
    private long сounter;

    FindWords(String srcFile, String word) throws FileNotFoundException {
        source = new RandomAccessFile(srcFile, "r");
        byteWord = new String(word).getBytes();
    }

    void findStrings() throws IOException, InterruptedException {
        try {
            while (true) {
                if (сounter == 0 || Character.isWhitespace(read())) {
                    compare(0);
                }
                Thread.yield();
            }
        } catch (EOFException e) {
            System.out.println(wordCounter);
        }
    }

    void compare(int index) throws IOException {
        byte b = read();
        if (index < byteWord.length && b == byteWord[index]) {
            compare(++index);
        } else {
            if (сounter == -1 || Character.isWhitespace(b)) {
                if (index == byteWord.length) {
                    ++wordCounter;
                }
                compare(0);
            }
        }
    }

    byte read() throws IOException {
        ++сounter;
        if (сounter - 1 == source.length()) {
            сounter = -1;
            return 0;
        }
        return source.readByte();
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (args.length != 2) {
                System.out.println("usage:\njava FindWords <file> <word>");
            } else {
                new FindWords(args[0], args[1]).findStrings();
            }

        } catch (Exception e) {
            e.printStackTrace(new PrintWriter("log"));
        }
    }
}
