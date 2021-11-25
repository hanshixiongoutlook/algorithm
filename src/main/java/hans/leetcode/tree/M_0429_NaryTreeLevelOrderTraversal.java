package hans.leetcode.tree;


import hans.common.pojo.LinkedTreeNode;
import hans.common.pojo.NTreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class M_0429_NaryTreeLevelOrderTraversal {

    @Test
    public void test() {
//        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,5,5});
//        treeNode.prettyPrint();
//        int i = levelOrder(treeNode);
//        Logger.log(i);
    }

    /**
     * 			Runtime:3 ms, faster than 70.10% of Java online submissions.
     * 			Memory Usage:39.5 MB, less than 5.23% of Java online submissions.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(NTreeNode root) {
        if (root==null) {
            return new LinkedList<>();
        }
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> list = new LinkedList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i=0; i<size; i++) {
                NTreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.children!=null) {
                    for (NTreeNode n: node.children) {
                        queue.offer(n);
                    }
                }
            }
            list.add(levelList);
        }
        return list;
    }
}
