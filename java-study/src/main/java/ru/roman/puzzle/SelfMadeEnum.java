package ru.roman.puzzle;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * //Написать аналог Enum (как если бы до Java 1.5) на примере какого-нибудь перечислимого списка, например списка валют.
 * Нужно:
 * 1. самое важное требование, которое следует удовлетворять в процессе всей реализации
 *   - расставить как можно меньшее количество граблей для разработчика, который в будущем будет добавлять новые значения
 * 2. иметь фиксированный список значений, задаваемый на этапе компиялции
 * 3. иметь строгую типизацию значений
 * 4. уметь безопасно сравнивать значения по ==
 * 5. получать все значения
 * 6. иметь неизменяемый ordinal (порядковый номер с 0 в порядке объявления значений)
 * 7. получать значения по ordinal
 * 8. иметь название значения, совпадающее с названием поля для значения
 * 9. искать по имени
 */
class SelfMadeEnum {


    static class Currency {

        private static int ordinalCounter = 0;
        private static final Map<String, Currency> values = new LinkedHashMap<>();   // if you shift this field bellow
        public static final Currency RUB = new Currency("RUB");               // the nullpointer will be thrown in constructor
        public static final Currency USD = new Currency("USD");
        public static final Currency EUR = new Currency("EUR");

        private final String name;
        private final int ordinal;

        private Currency(String name) {
            this.name = name;
            this.ordinal = ordinalCounter++;
            values.put(name, this);
        }

        public final String name() {
            return name;
        }

        public final int ordinal() {
            return ordinal;
        }

        public final boolean equals(Object other) {
            return this == other;
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public static Currency valueOf(String name) {
            Currency val = values.get(name);
            if (val == null) {
                throw new IllegalArgumentException();
            }
            return val;
        }

        public static Currency[] values() {
            return values.values().toArray(new Currency[values.size()]);
        }

        public String toString() {
            return name;
        }
    }
}
