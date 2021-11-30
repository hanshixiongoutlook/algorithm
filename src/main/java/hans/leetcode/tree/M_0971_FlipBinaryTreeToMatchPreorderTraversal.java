package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 */
public class M_0971_FlipBinaryTreeToMatchPreorderTraversal {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1,2,3});
        treeNode1.preoderPrint();
        treeNode1.prettyPrint();

        flipMatchVoyage(treeNode1, new int[]{1,3,2});
        treeNode1.prettyPrint();

        Logger.log(list);
    }

    List<Integer> list = new LinkedList<>();
    int idx = 0;

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.4 MB,击败了65.58% 的Java用户
     * @param root
     * @param voyage
     * @return
     */
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root, voyage);
        return list;
    }
    public void dfs(TreeNode root, int[] voyage) {
        if (root==null||list.contains(-1)) {
            return;
        }
        if (root.val!=voyage[idx]) {
            list.clear();
            list.add(-1);
            return;
        }
        if (root.left!=null) {
            idx++;
            if (root.left.val!=voyage[idx]) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                list.add(root.val);
            }
            if (root.left!=null) {
                flipMatchVoyage(root.left, voyage);
            } else {
                idx--;
            }
        }

        if (root.right!=null) {
            idx++;
            flipMatchVoyage(root.right, voyage);
        }
    }
}
