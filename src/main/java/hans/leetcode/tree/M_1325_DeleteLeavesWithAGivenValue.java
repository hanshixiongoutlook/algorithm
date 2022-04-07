package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。

 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。

 也就是说，你需要重复此过程直到不能继续删除。



 示例 1：



 输入：root = [1,2,3,2,null,2,4], target = 2
 输出：[1,null,3,null,4]
 解释：
 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。


 示例 2：



 输入：root = [1,3,3,3,2], target = 3
 输出：[1,3,null,null,2]


 示例 3：



 输入：root = [1,2,null,2,null,2], target = 2
 输出：[1]
 解释：每一步都删除一个绿色的叶子节点（值为 2）。

 示例 4：

 输入：root = [1,1,1], target = 1
 输出：[]


 示例 5：

 输入：root = [1,2,3], target = 1
 输出：[1,2,3]




 提示：


 1 <= target <= 1000
 每一棵树最多有 3000 个节点。
 每一个节点值的范围是 [1, 1000] 。

 Related Topics 树 深度优先搜索 二叉树 👍 79 👎 0

 */
public class M_1325_DeleteLeavesWithAGivenValue {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2});
        treeNode.prettyPrint();
        TreeNode treeNodes = removeLeafNodes(treeNode, 2);
        if (treeNodes!=null) {
            treeNodes.prettyPrint();
        }
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:40.9 MB, less than 38.46% of Java online submissions.
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, null, target);
        return root.left==null&&root.right==null&&root.val==target?null:root;
    }
    public void dfs(TreeNode root, TreeNode parent, int target) {
        if (root==null) {
            return;
        }
        dfs(root.left, root, target);
        dfs(root.right, root, target);
        if (root.left==null&&root.right==null&&root.val==target) {
            if (parent!=null&&parent.left==root) parent.left=null;
            if (parent!=null&&parent.right==root) parent.right=null;
        }
    }
    class Solution {
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


}
