package ru.roman.certification.jcl.swing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author MAbernethy 02.03.2008
 */
class DataHandler {
    private static List records;

    public static List getCities()   // метод возвращающий массив строк
    {
        List l = new ArrayList();
        l.add("AUS");
        l.add("ORD");
        l.add("IAH");
        l.add("SFO");
        l.add("DTW");
        l.add("DFW");
        l.add("PHL");
        l.add("ORL");
        l.add("LAS");
        return l;
    }

    public static List searchRecords(String depart, String dest)  // метод поиска занчений
    {
        if (records == null)
            initRecords();                           // заполнить массимвесли он пуст
        List l = new ArrayList();
        Flight f = new Flight();
        f.setDestination(dest);
        f.setDeparture(depart);
        for (Iterator i = records.iterator(); i.hasNext(); ) {
            Flight flight = (Flight) i.next();
            if (flight.getDeparture().equals(f.getDeparture())
                    && flight.getDestination().equals(f.getDestination()))
                l.add(flight);         // если условия выполняются добавлем в массив строку
        }
        return l;    // возвращаем двумерный массив с записями
    }

    public static void updateRecords(Object o, int tixx) throws Exception {
        if (records == null)
            initRecords();
        Flight f = (Flight) o;             //    метод обновляет згачения, уменьшает кол-во оставшихс билетов
        for (int i = 0; i < records.size(); i++) {
            Flight flight = (Flight) records.get(i);
            if (flight.equals(f)) {
                if (tixx > flight.getRemainingTixx())
                    throw new Exception("Not enough tickets available");
                flight.setRemainingTixx(flight.getRemainingTixx() - tixx);
                records.set(i, flight);
                return;
            }
        }
    }

    private static void initRecords()            // наполнить массив
    {
        records = new ArrayList();           // новы массив
        List l = getCities();            // массив городов
        for (int i = 0; i < 100; i++)                 // цикл от 1 до 100
        {
            Flight f = new Flight();              // новы йобект флайт, наполняем таблицу с полетами произвольными значениями
            f.setDeparture(l.get((int) (Math.random() * l.size())).toString());
            f.setDestination(l.get((int) (Math.random() * l.size())).toString());
            f.setRemainingTixx((int) (Math.random() * 50));
            f.setFlightNum((int) (Math.random() * 9999));
            records.add(f);
        }
    }
}
