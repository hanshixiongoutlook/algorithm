package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class M_1080_InsufficientNodesInRootToLeafPaths {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, -3, -5, null, 4, null});
        treeNode.prettyPrint();
        TreeNode treeNode1 = sufficientSubset(treeNode, -1);
        treeNode1.prettyPrint();


    }

    private Boolean dfs(TreeNode node, int s, int limit) {
        if (node.left == null && node.right == null) {
            return s + node.val < limit;
        }
        // 注意：如果 dfs 的返回值的意义是这个结点是否被删除，它们的默认值应该设置为 true
        boolean lTreeDeleted = true;
        boolean rTreeDeleted = true;
        // 如果有左子树，就先递归处理左子树
        if (node.left != null) {
            lTreeDeleted = dfs(node.left, s + node.val, limit);
        }
        // 如果有右子树，就先递归处理右子树
        if (node.right != null) {
            rTreeDeleted = dfs(node.right, s + node.val, limit);
        }
        // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
        if (lTreeDeleted) {
            node.left = null;
        }
        if (rTreeDeleted) {
            node.right = null;
        }
        // 只有左右子树都被删除了，自己才没有必要保留
        return lTreeDeleted && rTreeDeleted;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootDeleted = dfs(root, 0, limit);
        if (rootDeleted) {
            return null;
        }
        return root;
    }
//    public TreeNode sufficientSubset(TreeNode root, int limit) {
//        dfs(root,limit,0);
//        return root;
//    }
//
//    // node,parent
//    Map<TreeNode, TreeNode> lmap = new HashMap<>();
//    Map<TreeNode, TreeNode> rmap = new HashMap<>();
//    Map<TreeNode, Integer> sumMap = new HashMap<>();
//    public void dfs(TreeNode root, int limit, int sum) {
//        if (root==null) {
//            return;
//        }
//        sum = sum+root.val;
//        sumMap.put(root, sum);
//        if (root.left==null&&root.right==null&&sum<limit) {
//            TreeNode parent = lmap.get(root);
//            if (parent!=null) {
//                parent.left=null;
//            } else {
//                parent = rmap.get(root);
//                if (parent!=null) {
//                    parent.right=null;
//                }
//            }
//            while (parent!=null) {
//                if (parent.left==null&&parent.right==null&&sumMap.get(parent)<limit) {
//                    TreeNode lparent = lmap.get(parent);
//                    if (lparent!=null) {
//                        lparent.left=null;
//                        parent = lparent;
//                    } else {
//                        parent = rmap.get(parent);
//                        if (parent!=null) {
//                            parent.right=null;
//                        }
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//        if (root.left!=null) {
//            lmap.put(root.left, root);
//            dfs(root.left, limit, sum);
//        }
//        if (root.right!=null) {
//            rmap.put(root.right, root);
//            dfs(root.right,limit, sum);
//        }
//    }
}
