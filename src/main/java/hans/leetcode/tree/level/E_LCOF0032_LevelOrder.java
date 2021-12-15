package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 同102
 */
public class E_LCOF0032_LevelOrder {

    @Test
    public void test() {
//        1,2,2,3,3,null,null,4,4
        // 3,9,20,null,null,15,7
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7});
        treeNode.prettyPrint();

        List<List<Integer>> result = this.levelOrder(treeNode);
        Logger.log(result);
    }

    /**
     * 			Runtime:1 ms, faster than 93.80% of Java online submissions.
     * 			Memory Usage:38.8 MB, less than 5.65% of Java online submissions.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root==null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.remove();
                levelList.add(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            list.add(levelList);
        }
        return list;
    }
}
