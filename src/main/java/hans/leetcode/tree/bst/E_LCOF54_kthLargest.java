package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。



 示例 1:


 输入: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
    2
 输出: 4

 示例 2:


 输入: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 输出: 4



 限制：


 1 ≤ k ≤ 二叉搜索树元素个数

 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 277 👎 0

 */
public class E_LCOF54_kthLargest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,1,4,null,2});
        treeNode.prettyPrint();
        int mode = this.kthLargest(treeNode, 1);
        Logger.log(mode);
    }
    int sort=0;
    int result = -1;
    public int kthLargest(TreeNode root, int k) {
        if (root==null) {
            return result;
        }
        kthLargest(root.right, k);
        sort++;
        if (sort==k) {
            result = root.val;
        }
        kthLargest(root.left, k);
        return result;
    }
}
