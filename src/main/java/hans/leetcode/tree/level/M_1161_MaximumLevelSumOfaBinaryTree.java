package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。

 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。



 示例 1：




 输入：root = [1,7,0,7,-8,null,null]
 输出：2
 解释：
 第 1 层各元素之和为 1，
 第 2 层各元素之和为 7 + 0 = 7，
 第 3 层各元素之和为 7 + -8 = -1，
 所以我们返回第 2 层的层号，它的层内元素之和最大。


 示例 2：


 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 输出：2




 提示：


 树中的节点数在 [1, 10⁴]范围内
 -10⁵ <= Node.val <= 10⁵

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 51 👎 0

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
