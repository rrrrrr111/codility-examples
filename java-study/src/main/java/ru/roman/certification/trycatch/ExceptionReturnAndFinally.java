/*
 *
 * 1. Если 2 одинаковых exeption , один в try , другой в finally, обработан
 * всегда будет тот что в finally., тот что в try проигнорируется .. .
 *
 * 2. В блоке catch можно перехватить exeption, который произошел в этом же
 * try , при этом далее отработает finally все равно ..
 *
 * 3. Если в finally указать return , исключение дернутое в try catch
 * тоже будет проигнорировано..
 *
 * 3.1 Смысл таков, метод возвращает return либо exeption, при этом
 * важнее то что было последним. Если произошел exeption в try или catch или там было return
 * то метод возвращает exeption или return, но если потом в finally return или exeption, то он важнее,
 * , и exeption или return из finally заменяет exeption из try или catch
 *
 * 3.2 finally выполняется всегда !!!!!!
 *
 * 3.3 Вложенные блоки finally выполняются последовательно начиная с внутренних,
 * и внешние перекрывают внутренние ..,
 *
 * 3.4 блоки finally выполняются после отрабоки всех остальных блоков, в том
 * числе и внутренние finally запускаются после отработки всех внешних не finally
 * блоков, поэтому обычный например return во внешнем блоке идущий после внутреннего
 * блока с finally   , не может перекрыть это внутренний  finally
 *
 *
 * 4. Компилятор отслеживает ветвление внутри блока , если после throw ....
 * стоит что либо выдает ошибку компиляции unrechable statement
 *
 *
 * 5. Если метод main делает проброс исключения и присходит exeption
 * программа возвращает errorсode = 1
 *
 * 6. обработка - отлов исключений делается  жавой в отдельном потоке . поэтому
 * данные стектрейсы выводимые на консоль могут идти в перемешку с остальными данными..
 * выводимыми программой далее после передачи исключения в стектрейс например ..
 *
 *
 *
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.trycatch;

/**
 * @author churganov_r 21.03.2011
 */
public class ExceptionReturnAndFinally {

    void foo1() {
        try {
            try {
                throw new Exception("exept from try");
            } finally {
                throw new Exception("exept from finally");   // только этот будет отловлен
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void foo2() {
        try {
            try {
                throw new Exception("exept from try");
            } catch (Exception e) {
                e.printStackTrace();               // если исключение отловлено до finally , то все нармуль оно обработается
            } finally {
                throw new Exception("exept from finally");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void foo3() throws Exception {
        try {
            try {
                throw new Exception("exept from try");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                throw new Exception("exept from finally");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    void foo4() throws Exception {

    try {
    throw new Exception("exept from try");
    int i = 0;                                                 //unrechable statement
    } catch (Exception e) {


    } finally {

    }

    }*/
    void foo4() throws Exception {
        try {
            try {
                throw new Exception("exept from try");
                //return;
            } catch (Exception e) {
                throw new Exception("exept from catch");
                //return;
            } finally {
                throw new Exception("exept from finally");   // только этот будет отловлен , Exception и return из блоков try catch будет проигнорирован
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void foo5() throws Exception {
        try {
            try {
                throw new Exception("exept from try");
            } catch (Exception e) {
                throw new Exception("exept from catch");
            } finally {
                return;                                      // исключения игнорируются ...
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String foo6() throws Exception {
        try {
            try {
                //throw new Exception("exept from try");
                return "returned by try";
            } catch (Exception e) {
                //throw new Exception("exept from catch");
                return "returned by catch";
            } finally {
                return "returned by finally inner";              // предыдущие return и Exception игнорируются и последующий return и Exception тоже
                // если он не в блоке finally верхнего уровня .. .
                //throw new Exception("exept from finally");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "returned by finally outer";
        }
        //return "returned in the end";                 //  игнорируются ...
        //throw new Exception("exept in the end");        //  игнорируются ...

    }

    public static void main(String[] args) throws Exception {

        System.out.println("===================================================1");
        new ExceptionReturnAndFinally().foo1();
        Thread.sleep(1000);
        System.out.println("===================================================2");
        new ExceptionReturnAndFinally().foo2();
        Thread.sleep(1000);
        System.out.println("===================================================3");
        new ExceptionReturnAndFinally().foo3();
        Thread.sleep(1000);
        System.out.println("===================================================4");
        new ExceptionReturnAndFinally().foo4();
        Thread.sleep(1000);
        System.out.println("===================================================5");
        new ExceptionReturnAndFinally().foo5();
        Thread.sleep(1000);
        System.out.println("===================================================6");
        System.out.println(new ExceptionReturnAndFinally().foo6());


    }
}
