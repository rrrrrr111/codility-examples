package ru.roman.certification.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.StringJoiner;

class SerializationExample {

    public static void main(String[] args) throws Exception {

        var filename = "serialization-example-1.txt";

        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(filename));
             ObjectInputStream in = new ObjectInputStream(
                     new FileInputStream(filename))) {

            var objBefore = new Demo(777);

            System.out.println("Before >>> " + objBefore);
            out.writeObject(objBefore);
            var objAfter = (Demo) in.readObject();

            System.out.println("After >>> " + objAfter);

        }
    }
}

class Demo implements Serializable {
    private static final long serialVersionUID = 88888888L;

    transient int i1 = 1231231;
    int i2 = 0xffff;

    final int i3;

    Demo(int i3) {
        this.i3 = i3;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("write >>> ");
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("read >>> ");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Demo.class.getSimpleName() + "[", "]")
                .add("i1=" + i1)
                .add("i2=" + i2)
                .add("i3=" + i3)
                .toString();
    }
}