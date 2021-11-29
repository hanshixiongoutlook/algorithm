package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 */
public class M_0865_SmallestSubtreeWithAllTheDeepestNodes {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{0,3,1,4,null,2,null,null,6,null,5});
        treeNode.prettyPrint();
        treeNode = subtreeWithAllDeepest(treeNode);
        treeNode.prettyPrint();

    }

    /**
     * 			Runtime:1 ms, faster than 33.17% of Java online submissions.
     * 			Memory Usage:37.8 MB, less than 21.79% of Java online submissions.
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root==null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        Map<TreeNode,TreeNode> map = new HashMap<>();
        Deque<TreeNode> maxNodes = new LinkedList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) {
                    queue.offer(node.left);
                    map.put(node.left, node);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                    map.put(node.right, node);
                }
                maxNodes.add(node);
            }
            if (!queue.isEmpty()) {
                maxNodes.clear();
            }
        }
        while(maxNodes.size()>1) {
            TreeNode node = maxNodes.removeFirst();
            TreeNode parent = map.get(node);
            if (!maxNodes.contains(parent)&&parent!=null) {
                maxNodes.offer(parent);
            }
        }
        return maxNodes.poll();
    }

}
