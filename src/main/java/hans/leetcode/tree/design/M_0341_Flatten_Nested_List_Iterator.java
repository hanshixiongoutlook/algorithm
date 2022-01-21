package hans.leetcode.tree.design;


import hans.leetcode.pojo.NestedInteger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class M_0341_Flatten_Nested_List_Iterator {

    @Test
    public void test() {

//        List<NestedInteger> list = new ArrayList<>();
//        List<NestedInteger> l1 = new ArrayList<>();
//        l1.add(new NestedInteger(1));
//        l1.add(new NestedInteger(1));
//        list.add(new NestedInteger(l1));
//        list.add(new NestedInteger(1));
//        List<NestedInteger> l2 = new ArrayList<>();
//        l2.add(new NestedInteger(1));
//        l2.add(new NestedInteger(1));
//        list.add(new NestedInteger(l2));

        // [[],[3]]
        List<NestedInteger> list = new ArrayList<>();
        List<NestedInteger> l1 = new ArrayList<>();
        l1.add(new NestedInteger(3));
        list.add(new NestedInteger(l1));

        List<NestedInteger> l2 = new ArrayList<>();
        l2.add(new NestedInteger(new ArrayList<>()));
        list.add(new NestedInteger(l2));

        NestedIterator iterator = new NestedIterator(list);

        while(iterator.hasNext()) {
            int n = iterator.next();
            System.out.print(n+",");
        }

    }


    public class NestedIterator implements Iterator<Integer> {
        List<NestedInteger> nestedList;
        private int pointer = 0;
        private NestedIterator nextIteator;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            if (nestedList==null||pointer>=nestedList.size()) {
                return null;
            }
            NestedInteger nestedInteger = nestedList.get(pointer);
            if (nestedInteger.isInteger()) {
                pointer++;
                return nestedInteger.getInteger();
            }
            List<NestedInteger> list = nestedInteger.getList();

            if (nextIteator==null) {
                nextIteator = new NestedIterator(list);
            }
            if (nextIteator.hasNext()) {
                int next = nextIteator.next();
                if (!nextIteator.hasNext()) {
                    pointer++;
                    nextIteator = null;
                }
                return next;
            }
            pointer++;
            nextIteator = null;

            return next();
        }

        private NestedIterator hasIterator;
        @Override
        public boolean hasNext() {
            if (nestedList==null||pointer>=nestedList.size()) {
                return false;
            }
            int count = 0;
            for (NestedInteger n: nestedList) {
                if (count<pointer) {
                    count++;
                    continue;
                }
                if (n.isInteger()) {
                    return true;
                }
                hasIterator = new NestedIterator(n.getList());
                if (hasIterator.hasNext()) {
                    return true;
                }
            }
            return false;
        }
    }
}
