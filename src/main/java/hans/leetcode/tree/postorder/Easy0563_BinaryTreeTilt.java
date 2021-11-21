package hans.leetcode.tree.postorder;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class Easy0563_BinaryTreeTilt {

    /**
     * TODO Time Complexity can be more optimized
     */
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3});

        treeNode.prettyPrint();
        System.out.println(this.findTilt(treeNode));
    }
    int sum=0;
    public int findTilt(TreeNode root) {
        if (root==null) {
            return 0;
        }
        sum(root);
        return sum;
    }

    public int sum(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        sum+=Math.abs(left-right);
        return root.val+left+right;
    }

}
