package ru.roman.certification.classes.nested;

class AnonymousClassExample {

    public static void main(String[] args) {

        new Forra("DAG").foo();
    }
}

class Forra {
    private final String f;
    Forra(String f) { this.f = f; }

    private void print(){ System.out.println(f);}

    void foo() {
        new Forra("MAG") {
            @Override
            void foo() {
                print();
            }
        }.foo();
    }
}