/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.puzzle;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 1. System.out ничего не выведет, поскольку его вывод перехвачен
 *
 * 2. Блок статической инициалицации выполняется при загрузке класса
 *
 * 3. System.console() - возвращает ссылку на консоль из под
 * виртуальной машины
 *
 * 4. Из под IDE пример не отрабатывает поскольку IDE перехватывает
 * ввод\вывод
 *
 * @author churganov_r 19.03.2011
 */
public class Puzzle3SystemOut {

    public static void main(String[] args) {
        System.out.println("Hello world");

    }

    static {
        System.setOut(new PrintStream(new OutputStream() {

            @Override
            public void write(int b) throws IOException {
            }
        }));
//        System.console().writer().println("Hello world");
    }
}
