package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：


 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）


 如果不存在祖父节点值为偶数的节点，那么返回 0 。



 示例：



 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 输出：18
 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。




 提示：


 树中节点的数目在 1 到 10^4 之间。
 每个节点的值在 1 到 100 之间。

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 69 👎 0

 */

public class M_1315_SumOfNodesWithEvenValuedGrandparent {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5});
        treeNode.prettyPrint();
        Logger.log(sumEvenGrandparent(treeNode));

    }

    int sum = 0;

    /**
     * 			Runtime:1 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:40.4 MB, less than 33.46% of Java online submissions.
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        if (root==null) {
            return sum;
        }
        dfs(root, null, null);
        return sum;
    }

    public void dfs(TreeNode root, TreeNode parent, TreeNode grand) {
        if (root==null) {
            return;
        }
        if (grand!=null&&grand.val%2==0) {
            sum = sum + root.val;
        }
        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }


}
