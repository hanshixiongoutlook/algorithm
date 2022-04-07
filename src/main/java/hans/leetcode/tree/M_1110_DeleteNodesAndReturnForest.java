package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 给出二叉树的根节点 root，树上每个节点都有一个不同的值。

 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。

 返回森林中的每棵树。你可以按任意顺序组织答案。



 示例 1：




 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 输出：[[1,2,null,4],[6],[7]]


 示例 2：


 输入：root = [1,2,4,null,3], to_delete = [3]
 输出：[[1,2,4]]




 提示：


 树中的节点数最大为 1000。
 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 to_delete.length <= 1000
 to_delete 包含一些从 1 到 1000、各不相同的值。

 Related Topics 树 深度优先搜索 二叉树 👍 170 👎 0

 */
public class M_1110_DeleteNodesAndReturnForest {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,null,4});
        treeNode.prettyPrint();
        List<TreeNode> treeNodes = delNodes(treeNode, new int[]{2,1});
        for (TreeNode node: treeNodes) {
            node.arrayPrint();
        }

    }
    Set<Integer> toDel = new HashSet<>();
    List<TreeNode> list = new LinkedList<>();

    /**
     Runtime:1 ms, faster than 99.01% of Java online submissions.
     Memory Usage:41.9 MB, less than 39.11% of Java online submissions.

     这个是简化版的实现
         1
        / \
       /   \
      2     3
             \
              4
     输入：1,2
     输出：[3,null,4]
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (to_delete.length==0) {
            list.add(root);
            return list;
        }
        // 为了方便判断元素是否存在，将数组转成set
        for (int i=0; i<to_delete.length; i++) {
            toDel.add(to_delete[i]);
        }
        // 先判断根是否在删除列表里，没有的话需要先加到返回列表里
        if (!toDel.contains(root.val)) {
            list.add(root);
        }
        // 递归删除节点，并将剩余子树加入返回列表
        dfs(root, null);
        return list;
    }
    public void dfs(TreeNode root, TreeNode parent) {
        if (root==null) return;
        // 匹配到待删除节点
        if (toDel.contains(root.val)) {
            // 此时，该节点的左右子树变成了独立的树，需要加入返回列表
            // 但是还需要判断下左右子节点是不是也在删除列表里，如果在就不能加进去了
            if (root.left!=null&&!toDel.contains(root.left.val)) list.add(root.left);
            if (root.right!=null&&!toDel.contains(root.right.val)) list.add(root.right);
            // 删除当前节点
            if (parent!=null&&parent.left==root) parent.left=null;
            if (parent!=null&&parent.right==root) parent.right=null;
        }
        // 继续对子树进行递归
        dfs(root.left, root);
        dfs(root.right, root);
    }
    class Solution {
        /**
         * 			Runtime:1 ms, faster than 93.16% of Java online submissions.
         * 			Memory Usage:39.1 MB, less than 27.13% of Java online submissions.
         * @param root
         * @param to_delete
         * @return
         */
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            set = new HashSet<>();
            list = new LinkedList<>();
            for (int i: to_delete) {
                set.add(i);
            }
            dfs(root);
            if (set.contains(root.val)) {
                if (root.left!=null&&!set.contains(root.left.val)) {
                    list.add(root.left);
                }
                if (root.right!=null&&!set.contains(root.right.val)) {
                    list.add(root.right);
                }
            } else {
                list.add(root);
            }
            return list;
        }
        List<TreeNode> list;
        Set<Integer> set;
        public void dfs(TreeNode root) {
            if (root==null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (root.left!=null && set.contains(root.left.val)) {
                if (root.left.left!=null&&!set.contains(root.left.left.val)) {
                    list.add(root.left.left);
                }
                if (root.left.right!=null&&!set.contains(root.left.right.val)) {
                    list.add(root.left.right);
                }
                root.left = null;
            }
            if (root.right!=null && set.contains(root.right.val)) {
                if (root.right.left!=null&&!set.contains(root.right.left.val)) {
                    list.add(root.right.left);
                }
                if (root.right.right!=null&&!set.contains(root.right.right.val)) {
                    list.add(root.right.right);
                }
                root.right = null;
            }
            dfs(left);
            dfs(right);
        }
    }

}
