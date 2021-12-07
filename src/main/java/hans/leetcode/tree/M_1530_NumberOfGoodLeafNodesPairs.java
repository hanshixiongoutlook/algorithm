package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class M_1530_NumberOfGoodLeafNodesPairs {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1,1,1});
        treeNode1.prettyPrint();
        int i = countPairs(treeNode1, 2);
        Logger.log(i);
    }
    public int countPairs(TreeNode root, int distance) {
        dfs(root);
        int count = 0;
        for (int i=0; i<leaves.size()-1; i++) {
            for (int j=i+1; j<leaves.size(); j++) {
                int dist = calcDistance(leaves.get(i), leaves.get(j));
                if (dist<=distance) {
                    count++;
                }
            }
        }
        return count;
    }
    public int calcDistance(TreeNode leaf1, TreeNode leaf2) {
        Map<TreeNode, Integer> pDistanceMap = new HashMap<>();
        TreeNode l1Parent = pmap.get(leaf1);
        pDistanceMap.put(l1Parent, 1);
        while (l1Parent!=null) {
            Integer dist = pDistanceMap.get(l1Parent);
            l1Parent = pmap.get(l1Parent);
            if (l1Parent!=null) {
                pDistanceMap.put(l1Parent, dist+1);
            }
        }
        TreeNode l2Parent = pmap.get(leaf2);
        int l2Distance = 1;
        while (l2Parent!=null) {
            if (pDistanceMap.containsKey(l2Parent)) {
                return l2Distance+pDistanceMap.get(l2Parent);
            }
            l2Parent = pmap.get(l2Parent);
            l2Distance++;
        }
        return 0;
    }
    // node parent
    Map<TreeNode, TreeNode> pmap = new HashMap<>();
    List<TreeNode> leaves = new ArrayList<>();
    public void dfs(TreeNode root) {
        if (root==null) {
            return;
        }
        if (root.left!=null) {
            pmap.put(root.left, root);
        }
        if (root.right!=null) {
            pmap.put(root.right, root);
        }
        if (root.left==null&&root.right==null) {
            leaves.add(root);
        }
        dfs(root.left);
        dfs(root.right);
    }

}
