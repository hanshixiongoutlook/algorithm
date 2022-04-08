package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。



 示例 1：


 输入：root = [1,3,null,null,2]
 输出：[3,1,null,null,2]
 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。


 示例 2：


 输入：root = [3,1,4,null,null,2]
 输出：[2,1,4,null,null,3]
 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。



 提示：


 树上节点的数目在范围 [2, 1000] 内
 -2³¹ <= Node.val <= 2³¹ - 1




 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 694 👎 0

 */
public class M_0099_RecoverBinarySearchTree {

    @Test
    public void test() {
        TreeNode build = TreeNode.buildTree(new Integer[]{2,3,1});
        build.prettyPrint();
        build.inoderPrint();
        this.recoverTree(build);
        build.prettyPrint();
        build.inoderPrint();
    }

    /**
     * 1 3 2 4 5
     * 1 4 3 2 5
     * 5 2 3 4 1
     * @param root
     */
    TreeNode err1;
    TreeNode err2;
    TreeNode pre;
    /*
     1 3 2 4 5
     1 4 3 2 5
     5 2 3 4 1

     只要找出两个放错的节点即可
     核心原理：利用BST中序遍历是升序队列的特性
     在一个升序队列中，找打两个交换过的元素相对较容易，这两个元素的特点：
     第一个元素，一定是比其后继大的
     第二个元素，一定是比其前驱和后继都小
     第一个很好找，找到第一个比后继大的即可
     第二个其实比较好找，就是最后一个比前驱小的
    		Runtime:1 ms, faster than 100.00% of Java online submissions.
			Memory Usage:41.3 MB, less than 52.88% of Java online submissions.
     */
    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = err1.val;
        err1.val = err2.val;
        err2.val = tmp;
    }
    public void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        dfs(root.left);
        if (pre==null) {
            pre = root;
        }
        if (pre.val>root.val) {
            if (err1==null) {
                err1=pre;
            }
            err2=root;
        }
        pre = root;
        dfs(root.right);
    }
}
