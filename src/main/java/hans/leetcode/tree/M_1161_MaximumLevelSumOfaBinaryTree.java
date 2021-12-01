package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class M_1161_MaximumLevelSumOfaBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,7,0,7,-8,null,null});
        treeNode.prettyPrint();
        Logger.log(maxLevelSum(treeNode));

    }

    /**
     * 			Runtime:9 ms, faster than 33.56% of Java online submissions.
     * 			Memory Usage:41.3 MB, less than 44.98% of Java online submissions.
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=1,maxSum=Integer.MIN_VALUE,maxSumLevel=-1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int sum=0;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            if (sum>maxSum) {
                maxSum = sum;
                maxSumLevel=level;
            }
            level++;
        }
        return maxSumLevel;
    }
}
