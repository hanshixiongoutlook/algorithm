package hans.leetcode.tree.construct;

import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class M_0889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7});
        treeNode.prettyPrint();
        treeNode.preoderPrint();
        treeNode.postoderPrint();
        TreeNode treeNode1 = constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
        treeNode1.prettyPrint();
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (postorder.length==0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length==1) {
            return root;
        }
        int postorderIdx = getIndexOfPostorder(postorder, preorder[1]);

        int[] preorderLeft = Arrays.copyOfRange(preorder,1, postorderIdx+2);
        int[] preorderRight = Arrays.copyOfRange(preorder,postorderIdx+2, preorder.length);

        int[] postorderLeft = Arrays.copyOfRange(postorder,0, postorderIdx+1);
        int[] postorderRight = Arrays.copyOfRange(postorder,postorderIdx+1, preorder.length-1);

        root.left = constructFromPrePost(preorderLeft, postorderLeft);
        root.right = constructFromPrePost(preorderRight, postorderRight);
        return root;
    }

    public int getIndexOfPostorder(int[] postorder, int val) {
        for (int i=0; i<postorder.length; i++) {
            if (postorder[i]==val) {
                return i;
            }
        }
        return -1;
    }

}
