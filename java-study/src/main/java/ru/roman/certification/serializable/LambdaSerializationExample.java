package ru.roman.certification.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class LambdaSerializationExample {

    public static void main(String[] args) throws Exception {


        var r = (Runnable & Serializable & Cloneable) () -> {};
        System.out.println(r.getClass());


        var filename = "serialization-example-2.txt";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {

            int v = Integer.MAX_VALUE;

            out.writeObject(
                    (Runnable & Serializable & Roo) () -> System.out.println(v + 1)
            );

            ((Roo) in.readObject()).run();
        }
    }
}

interface Roo {
    //R apply(T t);
    void run();
}