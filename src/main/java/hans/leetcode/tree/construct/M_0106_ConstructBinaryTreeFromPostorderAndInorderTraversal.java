package hans.leetcode.tree.construct;

import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class M_0106_ConstructBinaryTreeFromPostorderAndInorderTraversal {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7});
        treeNode.prettyPrint();
        treeNode.postoderPrint();
        treeNode.inoderPrint();
        TreeNode treeNode1 = this.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        treeNode1.prettyPrint();
    }

    /*

     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length==0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
        int inIndex = findIndex(inorder, postorder[postorder.length-1]);
        int[] leftinorderSub = Arrays.copyOfRange(inorder, 0, inIndex);
        int[] rightinorderSub = Arrays.copyOfRange(inorder, inIndex+1, inorder.length);

        int[] leftpostorderSub = Arrays.copyOfRange(postorder, 0, inIndex);
        int[] rightpostorderSub = Arrays.copyOfRange(postorder, inIndex, inorder.length-1);

        node.left = buildTree(leftinorderSub, leftpostorderSub);
        node.right = buildTree(rightinorderSub, rightpostorderSub);
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
