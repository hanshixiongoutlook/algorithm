package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 同 103
 *
 */
public class M_Offer32_3_LeverOrder {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7});
        treeNode.prettyPrint();
        Logger.log(levelOrder(treeNode));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root==null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> lList = new LinkedList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if (reverse) {
                    lList.add(0, node.val);
                } else {
                    lList.add(node.val);
                }
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            reverse=!reverse;
            list.add(lList);
        }
        return list;
    }
}
