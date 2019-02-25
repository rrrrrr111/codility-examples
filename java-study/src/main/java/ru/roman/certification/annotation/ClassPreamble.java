package ru.roman.certification.annotation;

import java.lang.annotation.Documented;

@Documented
@interface ClassPreamble {                   // тип аннотации по сути форма интерфейса
    String author();
    String date();
    int currentRevision() default 1;          // default значения опциональны
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();
}