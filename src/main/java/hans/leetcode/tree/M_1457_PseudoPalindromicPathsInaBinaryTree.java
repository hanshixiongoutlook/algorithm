package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。

 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。



 示例 1：




 输入：root = [2,3,1,3,1,null,1]
 输出：2
 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列
 [1,2,1] 。


 示例 2：




 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 输出：1
 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。


 示例 3：


 输入：root = [9]
 输出：1




 提示：


 给定二叉树的节点数目在范围 [1, 10⁵] 内
 1 <= Node.val <= 9

 Related Topics 位运算 树 深度优先搜索 广度优先搜索 二叉树 👍 43 👎 0

 */
public class M_1457_PseudoPalindromicPathsInaBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,1,1,1,3,null,null,null,null,null,1});
        Logger.log(pseudoPalindromicPaths(treeNode));
    }
    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new HashMap<>(),0);
        return count;
    }
    int count =0 ;
    public void dfs(TreeNode root, Map<Integer, Integer> map, int pathLen) {
        if (root==null) {
            return;
        }
        pathLen++;
        Map<Integer, Integer> tMap = new HashMap<>(map);
        tMap.put(root.val, tMap.getOrDefault(root.val, 0)+1);
        if (root.left==null&&root.right==null) {
            if (isPalindrome(tMap, pathLen)) {
                count++;
            }
        }
        dfs(root.left, tMap, pathLen);
        dfs(root.right, tMap, pathLen);
    }

    public boolean isPalindrome(Map<Integer, Integer> map, int pathLen) {
        // 统计出现奇数次的数字个数
        long oddCount=map.values().stream().filter(ele->ele%2==1).count();
        // 组成回文数，要求，如果list有奇数个，则有且只能有一个数字出现奇数次
        // 如果list有偶数个，则不能有数字出现奇数次
        return (pathLen%2==1&&oddCount==1) || (pathLen%2==0&&oddCount==0);
    }
}
