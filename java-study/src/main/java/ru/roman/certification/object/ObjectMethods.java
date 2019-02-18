/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.roman.certification.object;

/**
 * 1. Класс Object базовый для всех классов, его методы наследуют
 * абсолютно все объекты, включая массивы.
 *
 * 3. методы getClass(), wait, notify, ... нельзя переорпеделить они объявлены
 * как final
 *
 * 4. Методы clone и finalize объявлены как protected
 *
 * 5. getClass()
 * возвращает экземпляр Class<...> соответствующего класса,
 * монитор объекта Class лочится static synchronized методами данного класса.
 *
 * 6. hashCode() возвращает хеш-код таблицы, метод поддерживается для фич,
 * которые реализуются такими объектами как Hashtable. основные соглашения метода:
 * - сколько бы его не вызывали на объекте во время работы программы, должен
 * консистентно возвращать некоторое постоянное Integer, не используя переменные данные
 * объекта испольуемые в equals. Этот integer не должен сохраняться между
 * запусками программы.
 * - если два объекта удовлетворяют equals(Object), то вызов hashCode
 * на каждом из объектов должен возвращать одинаковый integer
 * - если два объекта не удовлетворяют equals(Object) это оне значит
 * что они должны иметь различные Integer при вызове hashCode
 * Понятно что можно повысить производительность hashtables генеря одинаковые
 * Integer для unequal объектов
 * hashCode method defined by class Object должен всегда возвращать разные
 * Integer для разных объектов, Это реализовано просто конвертирование внутреннего
 * адреса объекта в Integer. но такая реализация не обзательна для программирования
 * в Java
 *
 * 7. equals реализует механизм проверки эквивалетности на non-null ссылках
 * на объекты
 * - It is reflexive: для любой non-null ссылки на занчение x, x.equals(x) должен
 * вернуть true.
 * - It is symmetric: для любой non-null ссылки на занчение x и y
 * x.equals(y)  should return true только и только если y.equals(x) returns
 * true.
 * - It is transitive: for any non-null ссылки на занчение x, y, and z,
 * если x.equals(y) returns true and y.equals(z) returns true,
 * тогда  x.equals(z) должен return true.
 * - It is consistent: for any non-null ссылки на занчение x and y, множественный
 * вызов x.equals(y) консистентно return true или консистентно return false,
 * не обеспечивая информацией о сравнеии оюъекта при его изменении
 * - для любой не нулевой ссылки x.equals(null) должен return false
 * - equals реализует самый дескриминационный способ реализации и для любых
 * non-null х и y возвращает true только и только если эти оба объекта
 * ссылаются на один объект (тоесть x == y has the value true)
 * - строго рекомендуется всегда , даже если этот метод переопределен,
 * переопределять его соблюдая его основной контракт если обеъкты equals
 * то и их hashCode равны
 *
 *
 * 8. Clone - клонирует объект и обозначает, что
 * x.clone() != x  will be true,
 * x.clone().getClass() == x.getClass() will be true, но
 * это не строгое требование, объчно достаточно
 * x.clone().equals(x) will be true
 * это тоже не строгое требование
 *
 * - По соглашению объект должен быть получен методом super.clone
 * Если класс и все его суперклассы (except Object) следуют данному соглашению
 * это будет случай когда  x.clone().getClass() == x.getClass().
 * - Если объект имеет ссылки на примитивы или immutable объекты, то все хорошо,
 * но если там   mutable или данные с глубокой структурой, то нунжо в методе
 * также организовать копирование данных объектов у объекта возвращаемого
 * методом super.clone
 * - метод clone сначала проверяет реализован ли интерфейс Cloneable если нет
 * CloneNotSupportedException is thrown. в противном случае создает инстанс объекта
 * и назначает и определяет все его поля как будто бы они равны, теость
 * легкое коопирование , тобишь не глубокое, называется shallow copy
 * - Все массивы следуют реализации Cloneable
 * - Object не реализует Cloneable и Clone на нем вызовет CloneNotSupportedException
 * - классы которые не раелизуют Cloneable объчно переопределяют Clone и вызывают
 * в нем CloneNotSupportedException
 *
 *
 * 9.toString - возвращает строку которая текстово представляет строку .. .
 * - результат должен быть коротким и юзеропонятным
 * - рекомендуется всем его переопределять ..
 * - toString method для класса Object (тоесть для всех кто не переопределил его)
 * возвращает   getClass().getName() + '@' + Integer.toHexString(hashCode())
 * например   String@234F
 *
 * 10. finalize - метод вызывается гарбэдж коллектором когда, не обнаружено больше
 * ссылок на данный объект , подклассы переопределяют этот метод чтобы
 * высвободить ресурсы или сделать другую чистку ..
 * - вызывается когда JVM решает, что больше нет причин по которым данный объект
 * может быть использован какой либо ветвью которая еще не умерла, кроме как кроме
 * как в результате вызова финализации другого объекта который готов к финализации
 * - finalize может иметь любые действия в том числе и действия которые могут
 * сделать объект опять видимым. Объчно метод используется чтобы сделать чистку
 * перед удалением объекта, например разрыв I/O соединений
 * - finalize объекта Object ни чего не делает, а просто делает return
 * - Java не дает гарантий каким потоком будет вызван finalize
 * - Java дает гарантию, что эта ветвь не может быть блокирована пользовательской
 * блокировкой потока когда финализация запустится
 * - если исключение возникает в finalize, то оно игнорируется и метод прекращается..
 * метод игнорирует исключения типа Throwable
 * - метод никогда не вызывается дважды для какого-то объекта
 * - после выполнения метода finalize, ничего не делается пока машина не проверит
 * что , не обнаружено больше ссылок на данный объект для каких либо не мертвых
 * потоков , включая возможность действий объектов готовых к финализации . ..
 * после этого объект грохается.. .
 *
 *
 * 11. В классе Object нет статических методов
 *
 * @author churganov_r 22.03.2011
 */
class ObjectMethods extends Object implements Cloneable {

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /*
    @Override                                       //   final
    Class getClass() {
    return super.getClass();
    }
     */

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override                                           //   protected
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();            // в Java есть хардкод, если класс реализует маркер Cloneable
        // то данный метод сделает shallow copy
        // если не реализует, то метод бросит   CloneNotSupportedException
    }

    @Override                                          //   protected
    protected void finalize() throws Throwable {
        super.finalize();
    }


    public static void main(String args[]) throws CloneNotSupportedException {
        new ObjectMethods().clone();
    }
}
