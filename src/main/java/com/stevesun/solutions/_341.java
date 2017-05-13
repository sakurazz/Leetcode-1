package com.stevesun.solutions;

import com.stevesun.common.classes.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 341. Flatten Nested List Iterator
 *
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class _341 {

    public static class NestedIterator implements Iterator<Integer> {

        private Queue<Integer> flattenedList;
        private Iterator<Integer> iterator;
        public NestedIterator(List<NestedInteger> nestedList) {
            flattenedList = new LinkedList<>();
            constructList(nestedList);
            iterator = flattenedList.iterator();
        }

        private void constructList(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    flattenedList.add(nestedInteger.getInteger());
                } else {
                    constructList(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

}