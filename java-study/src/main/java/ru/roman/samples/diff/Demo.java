package ru.roman.samples.diff;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


/**
 * @author дтоь 12.01.2008
 */
public class Demo implements Serializable {

    private static int counter = 0;

    private transient int cnt = 0;
    private String number;

    Demo(int numb) {
        cnt = counter++;
        number = String.valueOf(numb);
    }

    public Demo() {
        number = null;
    }

    @Override
    public String toString() {
        return " " + cnt + ": " + number;
    }

    static void dropCounter() {
        counter = 0;
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        cnt = counter++;
    }
}

