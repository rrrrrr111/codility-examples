/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.exception;

/**
 * 1. Компилятор отследит если есть какая-то строка после throw и не даст скомпилировать
 * но не сможет отследить простейшую проверку if (true)
 *
 КОМПИЛЯТОР ОТСЛЕЖИВАЕТ
 *
 * 2. если в методе нужно возвращать значение , то он может проверить .
 * что return есть во всех ветвлениях метода ...
 * 3. отслеживает инициализацию локальных переменных во всех ветвлениях ...
 * 4. бесполезный код после throw , return
 *
 * @author churganov_r 19.03.2011
 */
class ThrowIsLast {

    public static void main(String args[]) {
        try {
            getMe();
        } catch (ArithmeticException ae) {
            System.out.print(1);
        }
    }

    private static void getMe() throws ArithmeticException {
        if (true) {
            throw new NullPointerException();
        }
        throw new ArrayIndexOutOfBoundsException();
        //throw new ArrayIndexOutOfBoundsException();  // ошибка
    }
}
