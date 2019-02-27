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
package ru.roman.certification.exception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author churganov_r 21.03.2011
 */
class ExceptionReturnAndFinally {

    void foo1() throws Exception {
        try {
            throw new Exception("exept from try");
        } finally {
            throw new Exception("exept from finally");   // этот будет проброшен
        }
    }

    void foo2() throws Exception {
        try {
            throw new Exception("exept from try");
        } catch (Exception e) {
            e.printStackTrace();      // если исключение отловлено до finally , то все нарм оно обработается
        } finally {
            throw new Exception("exept from finally");  // но далее прокидывается это
        }
    }

    void foo3() throws Exception {

        try {
            throw new Exception("exept from try");
            //int i = 0;                             // illegal, unrechable statement
        } finally {
            // finally тут не припятствует
        }
    }

    void foo4() throws Exception {
        try {
            throw new Exception("exept from try");
        } catch (Exception e) {
            throw new Exception("exept from catch");
        } finally {
            // этот будет отловлен , Exception или return из блоков try и catch будет проигнорирован
            throw new Exception("exept from finally");
        }
    }

    void foo5() throws Exception {
        try {
            throw new Exception("exept from try");
        } catch (Exception e) {
            throw new Exception("exept from catch");
        } finally {
            return;                // исключения игнорятся несмотря на то что метод ничего не возвращает
            //int i;               // illegal, unrechable statement
        }

        //return;                                       // illegal, unrechable statement
        //throw new Exception("exept in the end");      // illegal, unrechable statement
    }

    String foo6() throws Exception {
        try {
            try {
                return "returned by try";
            } catch (Exception e) {
                return "returned by catch";
            } finally {
                return "returned by finally inner";
                // блок finally выполняется, но return игнорится т к есть оборачивающий finally
                // аналогично было бы с Exception
                //throw new Exception("exept from finally");
            }
        } finally {
            return "returned by finally outer";         // вернется этот
        }
    }

    String foo7() throws Exception {
        try {
            try {
                return "returned by try";
            } finally {
                throw new Exception("exept from finally"); // игнорится, как и если бы return
            }
        } finally {
            throw new Exception("exept from outer finally");  // прокидывается в итоге внешний
        }
    }

    public static void main(String[] args) throws Exception {

        ExceptionReturnAndFinally o = new ExceptionReturnAndFinally();
        ExecutorService e = Executors.newFixedThreadPool(1);

        e.submit(wrap(o::foo1)).get();
        e.submit(wrap(o::foo2)).get();
        e.submit(wrap(o::foo3)).get();
        e.submit(wrap(o::foo4)).get();
        e.submit(wrap(o::foo5)).get();
        e.submit(wrap(o::foo6)).get();
        e.submit(wrap(o::foo7)).get();

        e.shutdown();
    }

    private static Callable<Void> wrap(Call c) {
        return () -> {
            try {
                c.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        };
    }

    private static Callable<Void> wrap(CallAndPrint c) {
        return () -> {
            try {
                System.out.println(c.run());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        };
    }

    @FunctionalInterface
    private interface Call {
        void run() throws Exception;
    }

    @FunctionalInterface
    private interface CallAndPrint {
        Object run() throws Exception;
    }
}
