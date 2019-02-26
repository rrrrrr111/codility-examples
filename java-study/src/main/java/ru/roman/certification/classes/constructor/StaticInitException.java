package ru.roman.certification.classes.constructor;

class StaticInitException {
    static {
        //throw new RuntimeException();             // illegal

        if (true) try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (true) throw new RuntimeException();
    }

    public static void main(String[] args) {
    }
}
