package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Easy0872_LeafSimilarTrees {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1,3,2});

        treeNode.prettyPrint();
        treeNode2.prettyPrint();

        boolean result = this.leafSimilar(treeNode,treeNode2);
        // [3.00000,14.50000,11.00000]
        Logger.log(result);

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        preorderGetLeaves(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        preorderGetLeaves(root2, list2);

        if (list1.size()!=list2.size()) {
            return false;
        }
        for (int i=0; i<list1.size(); i++) {
            if (list1.get(i)!=list2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public void preorderGetLeaves(TreeNode root, List<Integer> list) {
        if (root==null) {
            return;
        }
        if (root.left==null&&root.right==null) {
            list.add(root.val);
        }
        preorderGetLeaves(root.left, list);
        preorderGetLeaves(root.right, list);
    }

}
