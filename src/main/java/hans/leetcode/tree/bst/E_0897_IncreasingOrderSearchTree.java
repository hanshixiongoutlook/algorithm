package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节
 点。



 示例 1：


 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]


 示例 2：


 输入：root = [5,1,7]
 输出：[1,null,5,null,7]




 提示：


 树中节点数的取值范围是 [1, 100]
 0 <= Node.val <= 1000

 Related Topics 栈 树 深度优先搜索 二叉搜索树 二叉树 👍 270 👎 0

 */
public class E_0897_IncreasingOrderSearchTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,1,7});
        treeNode.prettyPrint();
        TreeNode mode = this.increasingBST(treeNode);
        mode.prettyPrint();
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        increasingBST(root, list);
        TreeNode rootNew = new TreeNode(list.get(0));
        TreeNode next = rootNew;
        for (int i = 1; i < list.size(); i++) {
            next.right = new TreeNode(list.get(i));
            next = next.right;
        }
        return rootNew;
    }
    public void increasingBST(TreeNode root, List<Integer> list) {
        if (root == null) return;
        increasingBST(root.left, list);
        list.add(root.val);
        increasingBST(root.right, list);
    }
}
