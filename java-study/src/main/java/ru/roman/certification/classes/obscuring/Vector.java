package ru.roman.certification.classes.obscuring;

import java.util.*;
import ru.roman.certification.classes.obscuring.PackageObscuring.ArrayList;

import java.util.Vector;
import ru.roman.certification.classes.obscuring.Vector.*;


//import static ru.roman.certification.classes.obscuring.Vector.rool.baboo; // приоритетнее
//import static ru.roman.certification.classes.obscuring.Vector.rool.*;
import ru.roman.certification.classes.obscuring.Vector.rool.baboo;
import ru.roman.certification.classes.obscuring.Vector.rool.*;



class PackageObscuring {

    void foo() {

        new Vector();
    }
    class Vector{}
    class ArrayList{}


    void babol(){
        var i = ru.roman.certification.classes.obscuring.Vector.rool.baboo;
        baboo.valueOf(1);
    }
}

//class Vector{}  // illegal т к есть такой пакет
