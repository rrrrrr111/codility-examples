package ru.roman.certification.classes.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.util.List;

@Documented
@interface AnnotationExample {                   // тип аннотации по сути форма интерфейса
    String author();
    String date();
    int currentRevision() default 1;          // default значения опциональны
    String value() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();

    Foo fa();
    Foo[] ff();

    Class<List>[] jjj() default List.class;  // массим из одного элемента можно убрать скобки
    //Class<List<? extends Comparable<?>>>[] jgjgjg() default new Class<?>[0]; // illegal, attribute value must be constant
    Class<List<? extends Comparable<?>>>[] jgjggjg() default {};

    Object[] CONST = new Object[0];
    //{   var b = "";}                // illegal

    static class Jububu{}
    static enum  Kakoo{}
    static interface Mamou{}
}


@interface MyAnn {
    String value() default "N/A";
}

enum Foo implements MyAnn{
    GG;

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return Foo.class;
    }
}
class Bazz {
    void foo() {
        Class[] dd =  {List.class};
    }
}

