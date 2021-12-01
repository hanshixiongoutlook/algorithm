package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class M_1026_MaximumDifferenceBetweenNodeAndAncestor {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{8,3,10,1,6,null,14,null,null,4,7,13});
        treeNode1.prettyPrint();

        int i = maxAncestorDiff(treeNode1);

        Logger.log(i);

    }

    /**
     Runtime:85 ms, faster than 15.38% of Java online submissions.
     Memory Usage:126.6 MB, less than 5.13% of Java online submissions.
     */
    int max = -1;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,new ArrayList<>());
        return max;
    }
    public void dfs(TreeNode root, List<Integer> list) {
        if (root==null) {
            return;
        }
        List<Integer> list2 = new ArrayList<>(list.size()+1);
        list2.addAll(list);
        list2.add(root.val);
        if (root.left==null&&root.right==null) {
            for (int i=0; i<list2.size()-1; i++) {
                for (int j=(i+1);j<list2.size(); j++) {
                    int diff = Math.abs(list2.get(i)-list2.get(j));
                    max = Math.max(max, diff);
                }
            }
        }
        dfs(root.left, list2);
        dfs(root.right, list2);
    }
}
