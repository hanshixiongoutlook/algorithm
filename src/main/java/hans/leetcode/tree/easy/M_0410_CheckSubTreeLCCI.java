package hans.leetcode.tree.easy;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;


/**
 T1 and T2 are two very large binary trees. Create an algorithm to determine if
 T2 is a subtree of T1.

 A tree T2 is a subtree of T1 if there exists a node n in T1 such that the
 subtree of n is identical to T2. That is, if you cut off the tree at node n, the two
 trees would be identical.

 Note: This problem is slightly different from the original problem.

 Example1:


 Input: t1 = [1, 2, 3], t2 = [2]
 Output: true


 Example2:


 Input: t1 = [1, null, 2, 4], t2 = [3, 2]
 Output: false


 Note:


 The node numbers of both tree are in [0, 20000].

 Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 54 👎 0

 */
public class M_0410_CheckSubTreeLCCI {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 0, 1, -4, -3});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1,-4});

        boolean b = checkSubTree(treeNode, treeNode2);
        Logger.log(b);
    }
    /**
     Runtime:1 ms, faster than 83.25% of Java online submissions.
     Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1==null) {
            return false;
        }
        boolean same = isSame(t1, t2);
        if (same) {
            return true;
        }
        return checkSubTree(t1.left, t2)||checkSubTree(t1.right, t2);
    }

    public boolean isSame(TreeNode t1, TreeNode t2) {
        if (t2==null) {
            return true;
        }
        if (t1==null&&t2!=null) {
            return false;
        }
        if (t1.val!=t2.val) {
            return false;
        }
        return isSame(t1.left, t2.left)&&isSame(t1.right, t2.right);
    }

}
