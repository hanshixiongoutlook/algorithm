package hans.leetcode.tree.typical;


import hans.common.pojo.ListNode;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 */
public class M_1448_CountGoodNodesInBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1});
        treeNode1.prettyPrint();
        goodNodes(treeNode1);
        Logger.log(count);
    }

    public int goodNodes(TreeNode root) {
        dfs(root, new ArrayList<>());
        return count;
    }
    int count=1;
    public void dfs(TreeNode root, List<Integer> path) {
        if (root==null) {
            return;
        }
        List<Integer> tPath = new ArrayList<>(path.size()+1);
        tPath.addAll(path);
        Optional<Integer> max = tPath.stream().max(Integer::compareTo);
        if (max.isPresent()&&max.get()<=root.val) {
            count++;
        }
        tPath.add(root.val);
        dfs(root.left, tPath);
        dfs(root.right, tPath);
    }
}
