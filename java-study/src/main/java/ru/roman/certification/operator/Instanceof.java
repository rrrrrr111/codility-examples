package ru.roman.certification.operator;

import java.util.List;

/**
 *
 */
public class Instanceof {

    interface MyInterface {}

    public static void main(String[] args) {
        class Parent {}
        class Child extends Parent implements MyInterface {}

        Parent p = new Parent();
        Child c = new Child();
        Parent cp = c;

        boolean r0 = null instanceof Parent;         // false bottom type но не instance
        boolean r1 = p instanceof Parent;            // true  - бессмысленно, но не ругается
        boolean r2 = p instanceof Child;             // false - разрешает сравнивать родительский с дочерним,
        // т к там может быть инстанс потомка
        boolean r3 = p instanceof MyInterface;       // false - разшает сравнивать несовместимый интерфейс, может потомок реализует?
        boolean r4 = c instanceof Parent;            // true
        boolean r5 = c instanceof Child;             // true
        boolean r6 = c instanceof MyInterface;       // true
        boolean r7 = cp instanceof Parent;           // true - сравнивает тип объекта, а не ссылки
        boolean r8 = cp instanceof Child;            // true
        boolean r9 = cp instanceof MyInterface;      // true

        int[] a = new int[]{1, 2, 3};
        Object o = a;
        // Object[] oa = a;                          // illegal incompatible types
        // Integer[] oa = a;                         // illegal incompatible types
        boolean r10 = o instanceof int[];            // true
        boolean r11 = o instanceof byte[];           // false
        boolean r12 = o instanceof Object;           // true - all arrays are instances of Object
        //boolean r13 = a instanceof byte[];         // illegal int[] никак не byte[]

        Integer[] ii = new Integer[]{1, 2, 3};
        Object[] oa = ii;

        boolean r20 = ii instanceof Integer[];        // true
        //boolean r21 = ii instanceof Byte[];         // illegal
        boolean r22 = ii instanceof Object;           // true
        boolean r13 = oa instanceof Byte[];           // false
        //boolean r14 = oa instanceof byte[];         // illegal

        List<Integer> l = null;
        // boolean r15 = l instanceof List<Integer>; // illegal
        boolean r16 = l instanceof List<?>;          // false
        boolean r17 = l instanceof List;             // false
    }
}
