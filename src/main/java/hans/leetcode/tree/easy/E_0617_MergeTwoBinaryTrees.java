package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class E_0617_MergeTwoBinaryTrees {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1,2,3,null,5});
        TreeNode result = this.mergeTrees(treeNode, treeNode2);
        System.out.println("Tree 1:");
        treeNode.prettyPrint();
        System.out.println("Tree 2:");
        treeNode2.prettyPrint();
        System.out.println("Merge tree 1 and tree 2:");
        result.prettyPrint();
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null) {
            return null;
        }
        TreeNode node = new TreeNode();
        int newVal = root1!=null?root1.val:root2.val;
        if (root1!=null&&root2!=null) {
            newVal = root1.val+root2.val;
        }
        node.val = newVal;
        node.left = mergeTrees(root1==null?null:root1.left, root2==null?null:root2.left);
        node.right = mergeTrees(root1==null?null:root1.right, root2==null?null:root2.right);
        return node;
    }
}
