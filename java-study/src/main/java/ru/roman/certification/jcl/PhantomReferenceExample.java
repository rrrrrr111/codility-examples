package ru.roman.certification.jcl;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
class PhantomReferenceExample {

    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue rq = new ReferenceQueue();

        SoftReference sf = new SoftReference(new Foo("soft"), rq);
        WeakReference wf = new WeakReference(new Foo("weak"), rq);
        PhantomReference pf = new PhantomReference(new Foo("phantom"), rq);

        gc(3_000);
        Reference reference;
        while ((reference = rq.poll()) != null) {

            System.out.println("Polled " + reference + " with " + reference.get()+ "   restored: " + list);
            gc(1_000);
        }
    }

    private static void gc(int i) throws InterruptedException {

        System.out.println("Executing GC and sleep...");
        Runtime.getRuntime().gc();
        Thread.sleep(i);
    }
}

class Foo {
    private final String name;

    Foo(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        PhantomReferenceExample.list.add(this);
        System.out.println(name + " finalized");
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                '}';
    }
}
