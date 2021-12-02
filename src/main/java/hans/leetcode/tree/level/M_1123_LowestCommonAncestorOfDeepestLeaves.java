package hans.leetcode.tree.level;


import com.alibaba.fastjson.JSONObject;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 *
 * 同 103
 *
 */
public class M_1123_LowestCommonAncestorOfDeepestLeaves {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,null,3,4,null,6,null,5});
        treeNode.prettyPrint();
        TreeNode treeNode1 = lcaDeepestLeaves(treeNode);
        treeNode1.prettyPrint();
    }

    /**
     * 			Runtime:5 ms, faster than 5.07% of Java online submissions.
     * 			Memory Usage:38.8 MB, less than 5.07% of Java online submissions.
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root==null) {
            return null;
        }
        // child, parent
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<TreeNode> leaves = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                leaves.add(node);
                if (node.left!=null) {
                    map.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    map.put(node.right, node);
                    queue.offer(node.right);
                }
            }
            if (!queue.isEmpty()) {
                leaves.clear();
            }
        }
        if (leaves.size()==1) {
            return leaves.get(0);
        }
        Set<TreeNode> ancestor = new HashSet<>();
        while (ancestor.size()>1||ancestor.size()==0) {
            for (TreeNode n: leaves) {
                ancestor.add(map.get(n));
            }
            if (ancestor.size()==1) {
                return ancestor.iterator().next();
            }
            leaves.clear();
            leaves.addAll(ancestor);
            ancestor.clear();
        }
        return root;
    }
}
