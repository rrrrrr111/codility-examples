/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.serializable;

/**
 * @author дтоь 12.01.2008
 */



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class SerializableDemo {

    public static void main(String args[]) {

//--- 1. Создадим ArrayList из 20 элементов Demom
        ArrayList list = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Demom obj = new Demom(r.nextInt() % 1000);
            list.add(obj);
        }
//--- 2. Добавим еще один элемент в 10-ю позицию списка
        list.add(10, new Demom(1111));
//--- 3. Распечатаем результат
        print("Исходный список", list);
//--- 4. Сохраним это в файле
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("Demo.ser")));
            out.writeObject(list);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (out != null)
                try {
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
//--- 5. Восстановим все из файла
        Demom.dropCounter();     // сброс счетчика объектов
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream("Demo.ser")));
            list = (ArrayList) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
//--- 6. Отпечатаем результат
        print("Восстановленный список", list);
    }

    static void print(String title, List list) {
        System.out.println(title);
        Iterator iter = list.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            System.out.println("N " + i + "=" + iter.next());
        }
    }
}
   