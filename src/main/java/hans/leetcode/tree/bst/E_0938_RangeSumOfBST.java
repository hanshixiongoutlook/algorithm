package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;


/**
 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。



 示例 1：


 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 输出：32


 示例 2：


 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 输出：23




 提示：


 树中节点数目在范围 [1, 2 * 10⁴] 内
 1 <= Node.val <= 10⁵
 1 <= low <= high <= 10⁵
 所有 Node.val 互不相同

 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 284 👎 0

 */
public class E_0938_RangeSumOfBST {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{10,5,15,3,7,null,18});
        treeNode.prettyPrint();
        int mode = this.rangeSumBST(treeNode, 7,15);
        Logger.log(mode);
    }

    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null) {
            return sum;
        }
        if (root.val>=low && root.val<=high) {
            sum+=root.val;
        }
        if (root.val<=low) {
            rangeSumBST(root.right, low, high);
        } else if (root.val>=high) {
            rangeSumBST(root.left, low, high);
        } else {
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
