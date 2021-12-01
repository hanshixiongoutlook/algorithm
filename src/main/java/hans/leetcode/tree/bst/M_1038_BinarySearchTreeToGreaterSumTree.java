package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 */
public class M_1038_BinarySearchTreeToGreaterSumTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        treeNode1.prettyPrint();

        TreeNode i = bstToGst(treeNode1);

        i.prettyPrint();

    }
    // left,parent
    Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.9 MB, less than 59.63% of Java online submissions.
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                int rightSum = dfs(node.right)+map.getOrDefault(node, 0)+node.val;
                node.val = rightSum;
                if (node.left!=null) {
                    queue.offer(node.left);
                    map.put(node.left, node.val);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                    map.put(node.right, map.getOrDefault(node,0));
                }

            }
        }
        return root;
    }

    public int dfs(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        return root.val+l+r;
    }

}
