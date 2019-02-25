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

            //lowerBound = unbounded;   // not legal
            //lowerBound = upperBound;  // not legal
        }

        {
            List<?> unbounded = null;
            List<? extends Number> upperBound = null;
            List<? super Number> lowerBound = null;

            unbounded = upperBound;
            unbounded = lowerBound;

            //upperBound = unbounded;   // not legal
            //upperBound = lowerBound;  // not legal

            //lowerBound = unbounded;   // not legal
            //lowerBound = upperBound;  // not legal
        }

        {

            List<?> unbounded = null;
            List<? extends Integer> upperBound = null;
            List<? super Integer> lowerBound = null;

            //unbounded.add(new Object());  // not legal
            unbounded.add(null);
            unbounded.get(0).hashCode(); // Object methods only

            //upperBound.add(new Integer(1));  // not legal
            upperBound.add(null);
            upperBound.get(0).intValue();

            lowerBound.add(Integer.valueOf(1));
            lowerBound.add(null);
            lowerBound.get(0).hashCode(); // Object methods only
        }
    }
}
