package hans.leetcode.tree.design;


import hans.algorithm.sorts.HeapSort;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 */
public class E_0703_KthLargestElementInaStream {

    @Test
    public void test() {
        KthLargest k = new KthLargest(2, new int[]{0});

        Logger.log(k.add(-1));
        Logger.log(k.add(1));
        Logger.log(k.add(-2));
        Logger.log(k.add(-4));
        Logger.log(k.add(3));
    }

    class KthLargest {
        int k;
        List<Integer> list;
        public KthLargest(int k, int[] nums) {
            list = new ArrayList<>(nums.length*2);
            for (int i=0; i<nums.length; i++) {
                list.add(nums[i]);
            }
            list.sort((o1, o2) -> o2-o1);
            this.k = k-1;
        }
        public int add(int val) {
            if (list.isEmpty()) {
                list.add(val);
            } else {
                for (int i=0; i<list.size(); i++) {
                    if (val>=list.get(i)) {
                        list.add(i, val);
                        break;
                    }
                }
            }
            if (k<list.size()) {
                return list.get(k);
            }
            return 0;
        }
    }
}
