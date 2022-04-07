package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：


 选择二叉树中 任意 节点和一个方向（左或者右）。
 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 改变前进方向：左变右或者右变左。
 重复第二步和第三步，直到你在树中无法继续移动。


 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。

 请你返回给定树中最长 交错路径 的长度。



 示例 1：



 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 输出：3
 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。


 示例 2：



 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 输出：4
 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。


 示例 3：

 输入：root = [1]
 输出：0




 提示：


 每棵树最多有 50000 个节点。
 每个节点的值在 [1, 100] 之间。

 Related Topics 树 深度优先搜索 动态规划 二叉树 👍 71 👎 0

 */
public class M_1372_LongestZigZagPathInABinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1});
        int i = longestZigZag(treeNode);
        treeNode.prettyPrint();
        Logger.log(i);
    }
    int max=0;
    Map<TreeNode, Integer> lmap = new HashMap<>();
    Map<TreeNode, Integer> rmap = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        if (root==null) {
            return max-1;
        }
        max = Math.max(dfs(root, true), max);
        max = Math.max(dfs(root, false), max);
        longestZigZag(root.left);
        longestZigZag(root.right);
        return max-1;
    }
    public int dfs(TreeNode root, boolean isLeft) {
        if (root==null) {
            return 0;
        }
        if (isLeft) {
            Integer dist = lmap.get(root);
            dist = dist==null?dfs(root.left, !isLeft)+1:dist;
            lmap.put(root, dist);
            return dist;
        }
        Integer dist = rmap.get(root);
        dist = dist==null?dfs(root.right, !isLeft)+1:dist;
        rmap.put(root, dist);
        return dist;
    }
    class Solution {
        int max=0;

        /**
         * 			Runtime:50 ms, faster than 8.54% of Java online submissions.
         * 			Memory Usage:52.4 MB, less than 7.83% of Java online submissions.
         * @param root
         * @return
         */
        public int longestZigZag(TreeNode root) {
            dfs(root);
            return max;
        }
        public void dfs(TreeNode root) {
            if (root==null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            int left = zigZag(root, true);
            int right = zigZag(root, false);
            int nodeMax = Math.max(left, right);
            lmap.put(root, left);
            rmap.put(root, right);
            max = Math.max(max, nodeMax);
        }
        Map<TreeNode, Integer> lmap = new HashMap<>();
        Map<TreeNode, Integer> rmap = new HashMap<>();

        public int zigZag(TreeNode root, boolean isLeft) {
            int count = 0;
            TreeNode next = root;
            boolean curLeft = isLeft;
            while (next!=null) {

                if (curLeft) {
                    if (lmap.containsKey(next)) {
                        return lmap.get(next)+count;
                    }
                    if (next.left!=null) {
                        count++;
                        curLeft = false;
                    }
                    next = next.left;
                } else {
                    if (rmap.containsKey(next)) {
                        return rmap.get(next)+count;
                    }
                    if (next.right!=null) {
                        count++;
                        curLeft = true;
                    }
                    next = next.right;
                }
            }
            return count;
        }
    }


}
