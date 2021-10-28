package hans.leetcode.tree.binary;

import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class Medium0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,null,null,7});
        treeNode.prettyPrint();
        treeNode.preoderPrint();
        treeNode.inoderPrint();
        TreeNode treeNode1 = this.buildTree(new int[]{1, 2, 4, 5, 3, 7}, new int[]{4, 2, 5, 1, 3, 7});
        treeNode1.prettyPrint();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int inIndex = findIndex(inorder, preorder[0]);
        int[] inorderSub = Arrays.copyOfRange(inorder, 0, inIndex);
        int[] preorderSub = Arrays.copyOfRange(preorder, 1, inIndex+1);

        int[] rightinorderSub = Arrays.copyOfRange(inorder, inIndex+1, inorder.length);
        int[] rightpreorderSub = Arrays.copyOfRange(preorder, inIndex+1, inorder.length);

        node.left = buildTree(preorderSub, inorderSub);
        node.right = buildTree(rightpreorderSub, rightinorderSub);
        return node;
    }
    public int findIndex(int[] arr, int val) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==val) {
                return i;
            }
        }
        return -1;
    }


}
