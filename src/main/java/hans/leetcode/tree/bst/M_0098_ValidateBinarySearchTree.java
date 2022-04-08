package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 * 同剑指056
 */
public class M_0098_ValidateBinarySearchTree {

    @Test
    public void test() {
        // true 5,3,6,2,4,null,7       9
        // false 5,3,6,2,4,null,7     28
        TreeNode treeNode = TreeNode.buildSearchTree(new int[]{5,3,6,2,4,7});
        treeNode.prettyPrint();
        boolean mode = this.isValidBST(treeNode);
        Logger.log(mode);
    }

    /**
        4
       / \
      /   \
     2     6
      \   / \
       3 5   7

     搜索二叉树合法性判断误区
     从概念看，
     BST，左子树<根<右子树，很容采用 root.left.val<root.val<root.right.val来判断是否合法
     这样并不全面
     因为定义中，是整个左子树都比根小，上述判断只是保证了左孩子比根小（右子树同理），并不能保证整颗左子树都比根小

     因此最稳妥的方式是针对每个节点都判断其左子树所有节点<根<右子树所有节点
     然而在实际操作中其实并不需要做太多遍历


     左子树所有节点<根<右子树所有节点，该公式的含义可以解释为
     根相对左子树是最大值，相对右子树是最小值
     因此，只需要将最值进行传递即可判断

     */
    public boolean isValidBST(TreeNode root) {
        if (root==null) {
            return false;
        }
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root==null) {
            return true;
        }
        if (min!=null&&root.val<=min.val) return false;
        if (max!=null&&root.val>=max.val) return false;
        return isValidBST(root.left, min, root)&&isValidBST(root.right, root, max);
    }

}
