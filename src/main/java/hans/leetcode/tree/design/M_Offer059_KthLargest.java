package hans.leetcode.tree.design;


import hans.leetcode.pojo.NestedInteger;
import org.junit.Test;

import java.util.*;

/**
 *
 */
public class M_Offer059_KthLargest {

    @Test
    public void test() {


    }
    class KthLargest {
        int _k;
        List<Integer> list = new LinkedList<>();
        public KthLargest(int k, int[] nums) {
            _k = k;
            for (int i: nums) {
                list.add(i);
            }
            list.sort(Comparator.reverseOrder());
        }

        public int add(int val) {
            int idx = 0;
            for (Integer i: list) {
                if (val>i) {
                    break;
                }
                idx++;
            }
            list.add(idx, val);
            if (_k>list.size()) {
                return -1;
            }
            return list.get(_k-1);
        }
    }

}
