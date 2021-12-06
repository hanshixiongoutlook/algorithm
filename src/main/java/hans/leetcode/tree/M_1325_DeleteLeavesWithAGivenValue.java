package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 */
public class M_1325_DeleteLeavesWithAGivenValue {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,5,2,7,null,null,null,null,2});
        treeNode.overrideToString = false;
        treeNode.prettyPrint();
        TreeNode treeNodes = removeLeafNodes(treeNode, 2);

        treeNodes.prettyPrint();
    }

    /**
     * 			Runtime:1 ms, faster than 6.14% of Java online submissions.
     * 			Memory Usage:37.6 MB, less than 97.66% of Java online submissions.
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, target);
        if (root.left==null&&root.right==null&&root.val==target) {
            return null;
        }
        return root;
    }
    Map<TreeNode, TreeNode> lmap = new HashMap<>();
    Map<TreeNode, TreeNode> rmap = new HashMap<>();
    public void dfs(TreeNode root, int target) {
        if (root==null) {
            return;
        }
        if (root.val == target&&root.left==null&&root.right==null) {
            TreeNode parent = lmap.get(root);
            if (parent!=null) {
                parent.left=null;
            } else {
                parent = rmap.get(root);
                if (parent!=null) {
                    parent.right=null;
                }
            }
            while (parent!=null) {
                if (parent.left==null&&parent.right==null&&parent.val==target) {
                    TreeNode gparent = lmap.get(parent);
                    if (gparent!=null) {
                        gparent.left=null;
                    } else {
                        gparent = rmap.get(parent);
                        if (gparent!=null) {
                            gparent.right=null;
                        }
                    }
                    parent = gparent;
                } else {
                    break;
                }
            }
        }

        if (root.left!=null) {
            lmap.put(root.left, root);
        }
        if (root.right!=null) {
            rmap.put(root.right, root);
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }

}
