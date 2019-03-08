package ru.roman.certification.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

class TryCatchFinallyExample {

    void foo() {

        try {

            System.exit(0);      // finally не будет выполнен
            Thread.sleep(1_000); // finally может быть не выполнен если тред прерван, аналогично если прервано в catch
            throw new FileNotFoundException();
            // statement completes normally
        } catch (final InterruptedException e) {    // statement completes abruptly
            // exception handler подбираются по порядку сверху вниз, если исключение словлено, остальные
        } catch (FileNotFoundException e) {   // блоки catch игнорятся

        } catch (IOException e) {      // ловит IOException и всего наследники, legal, но Java 7+ компилятор даст варнинг, т к
            // все IOException которые могут быть брошеы в try уже перехвачены ранее
            // если кэтчатся классы екзепшенов из одной иерархии, то сначала должен ловиться более
            // специфичный класс, иначе ошибка компиляции
        } finally {            // предназначен для чистки т к всегда выполняется, предотвращение утечки ресурсов
        }
    }
}
