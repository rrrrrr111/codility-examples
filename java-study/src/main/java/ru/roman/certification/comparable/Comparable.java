/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.roman.certification.comparable;

/**
 * 1. Comparable входит в Java Collection Framework и используется в TreeMap
 * и TreeSet для сортировки..., либо для сортировки нужно задать Comparator.
 * Lists (and arrays) объектров удовлетворяющих интерфейсу могут быть
 * автоматически упорядочены методами Collections.sort (and Arrays.sort)
 * Без указания comparator
 *
 * 2. Comparable налагает полное упорядоивание на объеты всех классов которые
 * реализуют его ...
 *
 * 3. Говорят что упорядочивание консистентно с equals если
 * (e1.compareTo((Object)e2) == 0) имеет такое же boolean значение как
 * (e1.equals((Object)e2))
 *
 * 4. Здесь нужно учесть что null не является объектом класса и e.compareTo(null)
 * should throw a NullPointerException even though e.equals(null)  returns false
 *
 * 5. Строго рекомендуется чтобы натуральное упорядочивание было консистентно
 * с equals , но не требуется. Если оно не консистентно , то например , для сетов
 * и мэпов нарушается их основное свойство содержать уникальные элементы. Рекомендуется
 * в таком случае явно пометить класс "Note: this class has a natural ordering
 * that is inconsistent with equals."
 *
 * 6. Виртуально все java классы реализующий comparable имеют консистентность с
 * equals. Одно исключение BigDecimal,
 * его натуральный порядок приравнивает BigDecimal объекты с одинаковыми
 * значениями но разной точностью (such as 4.0 and 4.00).
 *
 * 7. Метод compareTo сравнивает объекты, тоесть задает порядок , возвращает 0,
 * -1 или 1.
 *
 * 8. при реализации метода нужно убедиться что
 * sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) для всех x и y .
 * Это также значит, что если x.compareTo(y) должен throw an exception
 * если y.compareTo(x) throws an exception
 *
 * 9. Реализующий также должен убедиться , что выражение
 * - является переходным
 * (x.compareTo(y)>0 && y.compareTo(z)>0) влечет x.compareTo(z)>0.
 * - а также если x.compareTo(y)==0 влечет
 * sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z.
 *
 *
 * 10. Метод должен вызвать ClassCastException - if the specified object's
 * type prevents it from being compared to this Object.
 *
 * @author churganov_r 17.03.2011
 */
public class Comparable implements java.lang.Comparable {

    private Integer a, b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof java.lang.Comparable)) return false;

        Comparable that =
                (Comparable) o;

        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (b != null ? !b.equals(that.b) : that.b != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException();
    }
}
