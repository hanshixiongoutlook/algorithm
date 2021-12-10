package hans.leetcode.tree.typical;

import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class M_0508_MostFrequentSubtreeSum {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{98,97,null,88,null,84,null,79,87,64,null,null,null,63,69,62,null,null,null,30,null,27,59,9,null,null,null,3,null,0,null,-4,null,-16,null,-18,-7,-19,null,null,null,-23,null,-34,null,-42,null,-59,null,-63,null,-64,null,-69,null,-75,null,-81});
        treeNode.prettyPrint();

        Logger.log(findFrequentTreeSum(treeNode));
        Logger.log("max={},count={}", max);
    }


    /**
     * 			执行耗时:4 ms,击败了80.43% 的Java用户
     * 			内存消耗:38.5 MB,击败了88.85% 的Java用户
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        Set<Integer> result = new HashSet<>();
        fmap.forEach((s,c)->{
            if (c.equals(max)) {
                result.add(s);
            }
        });

        int[] arr = new int[result.size()];
        int i=0;
        for (Integer n: result) {
            arr[i] = n;
            i++;
        }
        return arr;
    }

    Map<Integer, Integer> fmap = new HashMap<>();
    int max=1;
    public int sum(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int l = sum(root.left);
        int r = sum(root.right);
        int sum = l+r+root.val;
        fmap.put(sum, fmap.getOrDefault(sum, 0)+1);
        max = Math.max(max, fmap.get(sum));

        return sum;
    }
}
