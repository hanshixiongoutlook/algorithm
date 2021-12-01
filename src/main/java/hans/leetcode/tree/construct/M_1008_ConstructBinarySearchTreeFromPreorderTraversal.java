package hans.leetcode.tree.construct;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Arrays;

/**
 */
public class M_1008_ConstructBinarySearchTreeFromPreorderTraversal {

    @Test
    public void test() {
        TreeNode treeNode = bstFromPreorder(new int[]{4,2});
        treeNode.prettyPrint();
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.7 MB,击败了9.73% 的Java用户
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder==null||preorder.length==0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int splitIdx = findSplitIdx(preorder, node.val);
        if (splitIdx>0) {
            node.left = bstFromPreorder(Arrays.copyOfRange(preorder,1, splitIdx));
            node.right = bstFromPreorder(Arrays.copyOfRange(preorder,splitIdx, preorder.length));
        }
        return node;
    }
    public int findSplitIdx(int[] preorder, int root) {
        for(int i=0;i<preorder.length; i++) {
            if (preorder[i]>root) {
                return i;
            }
        }
        return preorder.length;
    }
}
