package ru.roman.certification.classes.generic;

import java.util.List;

/**
 *
 */
public class Wildcards {

    public static void main(String[] args) {

        {
            List<?> unbounded = null;
            List<? extends Object> upperBound = null;
            List<? super Object> lowerBound = null;

            unbounded = upperBound;
            unbounded = lowerBound;

            upperBound = unbounded;
            upperBound = lowerBound;

            //lowerBound = unbounded;   // illegal
            //lowerBound = upperBound;  // illegal
        }

        {
            List<?> unbounded = null;
            List<? extends Number> upperBound = null;
            List<? super Number> lowerBound = null;

            unbounded = upperBound;
            unbounded = lowerBound;

            //upperBound = unbounded;   // illegal
            //upperBound = lowerBound;  // illegal

            //lowerBound = unbounded;   // illegal
            //lowerBound = upperBound;  // illegal
        }

        {

            List<?> unbounded = null;
            List<? extends Integer> upperBound = null;
            List<? super Integer> lowerBound = null;

            //unbounded.add(new Object());  // illegal
            unbounded.add(null);
            unbounded.get(0).hashCode(); // Object methods only

            //upperBound.add(new Integer(1));  // illegal
            upperBound.add(null);
            upperBound.get(0).intValue();

            lowerBound.add(Integer.valueOf(1));
            lowerBound.add(null);
            lowerBound.get(0).hashCode(); // Object methods only
        }
    }
}
