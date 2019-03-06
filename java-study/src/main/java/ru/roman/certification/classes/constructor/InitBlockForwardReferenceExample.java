package ru.roman.certification.classes.constructor;

/**
 *
 */
class InitBlockForwardReferenceExample {

    //int k = i;       // illegal forward reference
    int k = i = 0;   // а так норм,

    InitBlockForwardReferenceExample() {
        k = i;         // 0 - i еще дефолтное
        i = 33;        // i было 0, стало 33
    }

    int i;
    int j = i;

    {
        g = 78;

        //int v = g;    // ссылаемся на поле, это контект инициализации а не декларации,
    }                 // поле было декларировано в классе еще при компиляции (поля != локальные переменные)
    //int p = g;         // illegal forward reference
    final int g;
    final int f;
    //int h = f;       // illegal, variable might not have been initialised
    int h = f = 1;   // норма
    int d = f;       // нор

    final int y = foo();      // норма
    final int m = foo1();
    int foo() { return m + u + y + 1;}  // y читается как 0 но потом становитя = 1
    int foo1() { return y + 1;}         // m = 2
    int u;


    public static void main(String[] args) {
        InitBlockForwardReferenceExample e = new InitBlockForwardReferenceExample();
        System.out.println(e.k + " " + e.i + " " + e.j + " " + e.g + " " + e.y + " " + e.m);

        int z3, y2, x1 = x1 = z3 = 3, p = z3 = y2 = x1;

    }
}
