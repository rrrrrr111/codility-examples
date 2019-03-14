package ru.roman.certification.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

class CollectionExample {
}

class SerialKiller {
    public static void main(String[] args) throws Exception {
        Serial serial = new Serial(666);
        serial.checkInvariant();

        Serial copy = (Serial) deepCopy(serial);
        copy.checkInvariant();
    }

    static Object deepCopy(Object obj) throws Exception {
        ByteArrayOutputStream bos;
        try (var out = new ObjectOutputStream(bos = new ByteArrayOutputStream())) {

            out.writeObject(obj);
            try (ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray())) {
                return new ObjectInputStream(bin).readObject();
            }
        }
    }
}

class Serial implements Serializable {
    final Set<Serial> set = new HashSet<>();
    private int id;

    Serial(int id) {
        this.id = id;
        set.add(this);
    }

    void checkInvariant() {
        if (!set.contains(this))
            throw new AssertionError("invariant violated");
    }

    public int hashCode() {
        return id;
    }

    public boolean equals(Object o) {
        return id == ((Serial) o).id;
    }
}