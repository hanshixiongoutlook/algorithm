package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 Given the root of a Binary Search Tree (BST), return the minimum absolute
 difference between the values of any two different nodes in the tree.


 Example 1:


 Input: root = [4,2,6,1,3]
 Output: 1


 Example 2:


 Input: root = [1,0,48,null,null,12,49]
 Output: 1



 Constraints:


 The number of nodes in the tree is in the range [2, 10⁴].
 0 <= Node.val <= 10⁵



 Note: This question is the same as 783: https://leetcode.com/problems/minimum-
 distance-between-bst-nodes/
 Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 323 👎 0

 */
public class E_0530_MinimumAbsoluteDifferenceInBST {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{236,104,701,null,227,null,911});
        treeNode.prettyPrint();
        int mode = this.getMinimumDifference(treeNode);
        Logger.log(mode);
    }
    Integer pre;
    Integer minDiff = Integer.MAX_VALUE;

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:41.2 MB, less than 29.98% of Java online submissions.
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        /*
        思路：
        搜索二叉树的特性：中序遍历（左根右）结果有序
        利用这一性质，可以将搜索二叉树转化成一个有序数组
        差最小值一定会产生在相邻的两个元素之间
        例如这样一个有序数组：1,4,9,12,13,17
        此时出现俩个关键变量
        1.相邻两个元素的差值
        2.相邻元素

        先搭建中序遍历框架，关键操作就出现在code部分
        void dfs(root) {
            dfs(root.left)
            // code....
            dfs(root.right)
        }
        为了计算相邻元素的差值，需要用一个变量记录当前元素的前一个元素，即，pre
        为了获取最小差值，需要一个变量记录下当前最小的差值，即，diffMin
        寻找最小差值
        新的差值，newDiff=root-pre
        最小差值，diffMin=min(diffMin, newDiff)
        计算完成后pre向后移动一位，pre=root

        int pre;
        int diffMin;
        void dfs(root) {
            dfs(root.left)
            intnewDiff=root-pre;
            diffMin=min(diffMin, newDiff);
            dfs(root.right)
        }
        然后再处理初始值问题即可
         */
        if (root==null) {
            return minDiff;
        }
        getMinimumDifference(root.left);
        if (pre==null) {
            pre = root.val;
        } else {
            minDiff = Math.min(minDiff, root.val-pre);
            pre = root.val;
        }
        getMinimumDifference(root.right);
        return minDiff;
    }
}
