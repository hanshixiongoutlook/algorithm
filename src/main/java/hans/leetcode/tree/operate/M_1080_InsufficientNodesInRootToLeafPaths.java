package hans.leetcode.tree.operate;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）

 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。

 请你删除所有不足节点，并返回生成的二叉树的根。



 示例 1：


 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1

 输出：[1,2,3,4,null,null,7,8,9,null,14]


 示例 2：


 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22

 输出：[5,4,8,11,null,17,4,7,null,null,null,5]

 示例 3：


 输入：root = [5,-6,-6], limit = 0
 输出：[]



 提示：


 给定的树有 1 到 5000 个节点
 -10^5 <= node.val <= 10^5
 -10^9 <= limit <= 10^9



 Related Topics 树 深度优先搜索 二叉树 👍 55 👎 0

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
