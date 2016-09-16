package com.yourtion.Pattern02;

import java.util.Comparator;

/**
 * Created by Yourtion on 9/8/16.
 */
public class ComposedComparator<T> implements Comparator<T> {

    private Comparator<T>[] comparators;

    public ComposedComparator(Comparator<T>... comparators) {
        this.comparators = comparators;
    }

    @Override
    public int compare(T o1, T o2) {
        for (Comparator<T> comparator : comparators) {
            int result = comparator.compare(o1, o2);
            if (result != 0)
                return result;
        }
        return 0;
    }

}
