package hans.leetcode.tree.bst.operate;

import hans.common.pojo.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

public class M_0450_DeleteNodeInABST {
    @Test
    public void test() {
        TreeNode integerTreeNode = TreeNode.buildSearchTree(new int[]{1,2,3,4,5,6,7,8});
        integerTreeNode.prettyPrint();
        TreeNode treeNode = this.deleteNode(integerTreeNode, 4);
        treeNode.prettyPrint();
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:38.9 MB, less than 54.43% of Java online submissions.
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) {
            return root;
        }
        if (root.val>key) {
            root.left = deleteNode(root.left, key);
        }else if (root.val<key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 叶子节点直接删除
            if (root.left==null&&root.right==null) {
                return null;
            } else if (root.right!=null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = precursor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     * 获取前驱，即比当前节点小的最大节点
     * @param root
     * @return
     */
    public int precursor(TreeNode root) {
        root = root.left;
        while (root.right!=null) root = root.right;
        return root.val;
    }

    /**
     * 获取后继，即比当前节点大的最小节点
     * @param root
     * @return
     */
    public int successor(TreeNode root) {
        root = root.right;
        while(root.left!=null) root = root.left;
        return root.val;
    }
}
