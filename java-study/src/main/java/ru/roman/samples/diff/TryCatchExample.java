package ru.roman.samples.diff;

public class TryCatchExample {

    public void foo() throws Throwable {
        try {
            try {

                System.out.println("Exception throwed");
                throw new Exception("my exept 1");

            } catch (Exception e) {

                System.out.println("Exception catched");
                throw new RuntimeException("my runexept 2", e);

            } finally {
                System.out.println("finally called!");
                // Если указать return в выражении finally, то исключение
                // произошедешее внутри этого try Catch не будет перехвачено
                // return;

                // throw new RuntimeException("my runexept 2");
                // если внутри finally дернуть исключение , то исключение
                // произошедешее внутри этого try Catch также не будет перехвачено далее, но будет перехвачено исключение из finally

            }

        } catch (RuntimeException e) {

            System.out.println("RuntimeException catched");

            // пример вывода стектрейса при обертке одного исключения в другое ...
            //e.printStackTrace();
            throw new Throwable("my Throw 3", e);

        }

    }

    public static void main(String[] args) {

        try {

            new ru.roman.samples.diff.TryCatchExample().foo();

        } catch (Throwable e) {
            System.out.println("RuntimeException called in main");
            e.printStackTrace();
        }

    }

}
