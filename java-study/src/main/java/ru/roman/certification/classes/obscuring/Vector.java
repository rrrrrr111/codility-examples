package ru.roman.certification.classes.obscuring;

import java.util.*;
import ru.roman.certification.classes.obscuring.PackageObscuring.ArrayList;

import java.util.Vector;
import ru.roman.certification.classes.obscuring.Vector.*;


class PackageObscuring {

    void foo() {

        new Vector();
    }
    class Vector{}
    class ArrayList{}
}

//class Vector{}  // illegal т к есть такой пакет
