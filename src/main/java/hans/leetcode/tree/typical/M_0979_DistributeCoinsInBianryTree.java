package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 You are given the root of a binary tree with n nodes where each node in the
 tree has node.val coins. There are n coins in total throughout the whole tree.

 In one move, we may choose two adjacent nodes and move one coin from one node
 to another. A move may be from parent to child, or from child to parent.

 Return the minimum number of moves required to make every node have exactly
 one coin.


 Example 1:


 Input: root = [3,0,0]
 Output: 2
 Explanation: From the root of the tree, we move one coin to its left child, and
 one coin to its right child.


 Example 2:


 Input: root = [0,3,0]
 Output: 3
 Explanation: From the left child of the root, we move two coins to the root [
 taking two moves]. Then, we move one coin from the root of the tree to the right
 child.



 Constraints:


 The number of nodes in the tree is n.
 1 <= n <= 100
 0 <= Node.val <= n
 The sum of all Node.val is n.

 Related Topics 树 深度优先搜索 二叉树 👍 295 👎 0

 */
public class M_0979_DistributeCoinsInBianryTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{0,0,1,0,3,2});
        treeNode1.prettyPrint();

        Logger.log(distributeCoins(treeNode1));
    }

    int ans;

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.5 MB,击败了94.65% 的Java用户
     * @param root
     * @return
     */
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root) {
        /*
        动态规划求最值
          a         3
          b     0      1
          c   0   1  2   0

        节点可分为3类
        1.需要索取1个，如c[0] = 0-1 = -1 即需要索取1个，
            对c[0]来说成本最小的方式就是从其父节点b[0]索取一个，此时至少需要移动1步
        2.需要送出去n个，如c[2] = 3-1=2 即需要送出2个，
            对c[2]来说成本最小的方式就是把多余的2个给父节点b[1]，此时至少需要移动2步
        3.不需要动的，如c[1]=1 已经有一个了，不用动了

        因此节点的最小移动次数方程为
        f(root) = f(left) + f(right) +  (root.val-1)
        当root=null时，没有需求，因此最小移动次数为0

        每一个节点无论是给出去还是索取都要消耗移动次数
        因此总移动次数需要把每个节点的移动需求进行累加
        total = |f(left)| + |f(right)|

         */
        if (root==null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left)+Math.abs(right);
        return root.val-1+left+right;
    }
}
