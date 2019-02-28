package ru.roman.certification.serializable;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

class LambdaSerializationExample {

    public static void main(String[] args) throws Exception {

        var r = (Runnable & Serializable & Cloneable) () -> {};
        System.out.println(r.getClass());

        Path dir = Path.of("build");
        if (Files.notExists(dir)) Files.createDirectory(dir);

        Path p = Path.of("build", "serialization-example-2.txt");

        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(p));
             ObjectInputStream in = new ObjectInputStream(Files.newInputStream(p))) {

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