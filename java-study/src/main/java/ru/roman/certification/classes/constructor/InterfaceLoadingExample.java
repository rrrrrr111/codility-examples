package ru.roman.certification.classes.constructor;

public class InterfaceLoadingExample {

    public static void main(String[] args) {

        FarooBuuIntf gg = null;
        FarooBuuIntf d = new FarooBuu().foo1();
        FarooBuu.foo();

        //String sf = gg.sf;
    }
}

interface FarooBuuIntf {
    String sf = ZooHelper.print("FarooBuuIntf");

    FarooBuuIntf foo1();
}

class FarooBuu implements FarooBuuIntf {
    static String ss = ZooHelper.print("static-FarooBuu");
    String s = ZooHelper.print("non-static-FarooBuu");

    static void foo(){}
    @Override
    public FarooBuuIntf foo1(){
        return new FarooBuuIntf(){
            @Override
            public FarooBuuIntf foo1() {
                return null;
            }
        };
    }
}

class ZooHelper {
    static String print(String txt) {
        System.out.println(txt);
        return txt;
    }
}
