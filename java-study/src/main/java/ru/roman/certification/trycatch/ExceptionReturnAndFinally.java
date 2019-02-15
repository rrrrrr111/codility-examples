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
                throw new Exception("exept from finally");   // только этот будет проброшен
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
                e.printStackTrace();               // если исключение отловлено до finally , то все нарм оно обработается
            } finally {
                throw new Exception("exept from finally");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void foo3() throws Exception {

        try {
            throw new Exception("exept from try");
            //int i = 0;                                                 //unrechable statement
        } catch (Exception e) {
        } finally {
        }
    }

    void foo4() throws Exception {
        try {
            try {
                throw new Exception("exept from try");
                //return;
            } catch (Exception e) {
                throw new Exception("exept from catch");
                //return;
            } finally {
                throw new Exception("exept from finally");   // только этот будет отловлен , Exception или return из блоков try catch будет проигнорирован
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
                return;                // исключения игнорятся несмотря на то что метод ничего не возвращает
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
                return "returned by finally inner";  // блок finally выполняется, но return игнорится т к есть оборачивающий finally
                // если он не в блоке finally верхнего уровня .. .
                //throw new Exception("exept from finally");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "returned by finally outer";         // вернется этот
        }
        //return "returned in the end";                 //  игнорируются ...
        //throw new Exception("exept in the end");      //  игнорируются ...

    }

    public static void main(String[] args) throws Exception {

        ExceptionReturnAndFinally o = new ExceptionReturnAndFinally();

        System.out.println("===================================================1");
        o.foo1();
        Thread.sleep(1000);
        System.out.println("===================================================2");
        o.foo2();
        Thread.sleep(1000);
        System.out.println("===================================================3");
        o.foo3();
        Thread.sleep(1000);
        System.out.println("===================================================4");
        o.foo4();
        Thread.sleep(1000);
        System.out.println("===================================================5");
        o.foo5();
        Thread.sleep(1000);
        System.out.println("===================================================6");
        System.out.println(o.foo6());
    }
}
