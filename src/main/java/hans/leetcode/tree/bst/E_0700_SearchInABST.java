package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。

 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。



 示例 1:




 输入：root = [4,2,7,1,3], val = 2
 输出：[2,1,3]


 Example 2:


 输入：root = [4,2,7,1,3], val = 5
 输出：[]




 提示：


 数中节点数在 [1, 5000] 范围内
 1 <= Node.val <= 10⁷
 root 是二叉搜索树
 1 <= val <= 10⁷

 Related Topics 树 二叉搜索树 二叉树 👍 261 👎 0

 */
public class E_0700_SearchInABST {

    @Test
    public void test() {
        // true 5,3,6,2,4,null,7       9
        // false 5,3,6,2,4,null,7     28
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4,2,7,1,3});
        treeNode.prettyPrint();
        TreeNode mode = this.searchBST(treeNode, 11);
        mode.prettyPrint();
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) {
            return null;
        }
        if (root.val==val) {
            return root;
        }
        if (root.val>val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }


}
