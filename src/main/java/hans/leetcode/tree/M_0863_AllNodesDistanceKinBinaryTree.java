package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * TODO 未解答
 */
public class M_0863_AllNodesDistanceKinBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7});
        treeNode.prettyPrint();
        treeNode.preoderPrint();

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }
        findParent(root, null);
        findAns(target, null, 0, k);
        return ans;
    }

    List<Integer> ans = new LinkedList<>();

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (map.get(node.val) != from) {
            findAns(map.get(node.val), node, depth + 1, k);
        }
    }

    Map<Integer, TreeNode> map = new HashMap<>();

    public void findParent(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.put(root.val, parent);
        findParent(root.left, root);
        findParent(root.right, root);
    }
}
