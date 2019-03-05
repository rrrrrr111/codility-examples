package ru.roman.certification.classes.constructor;

/**
 *
 */
class ForwardReferenceExample {

    //int k = i;       // illegal forward reference
    int k = i = 0;   // а так норм,

    ForwardReferenceExample() {
        k = i;         // 0 - i еще дефолтное
        i = 33;        // i было 0, стало 33
    }

    int i;
    int j = i;
    {g = 78;}          // ссылаемся на поле, это контект инициализации а не декларации,
                       // поле было декларировано в классе еще при компиляции (поля != локальные переменные)
    //int p = g;         // illegal forward reference
    final int g;
    final int f;
    //int h = f;       // illegal, variable might not have been initialised
    int h = f = 1;   // норма


    public static void main(String[] args) {
        ForwardReferenceExample e = new ForwardReferenceExample();

        System.out.println(e.k + " " + e.i + " " + e.j + " " + e.g);
    }
}
