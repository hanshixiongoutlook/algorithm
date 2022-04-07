package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 我们可以为二叉树 T 定义一个 翻转操作 ，如下所示：选择任意节点，然后交换它的左子树和右子树。

 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转 等价 于二叉树 Y。

 这些树由根节点 root1 和 root2 给出。如果两个二叉树是否是翻转 等价 的函数，则返回 true ，否则返回 false 。



 示例 1：




 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,
 null,null,null,8,7]
 输出：true
 解释：我们翻转值为 1，3 以及 5 的三个节点。


 示例 2:


 输入: root1 = [], root2 = []
 输出: true


 示例 3:


 输入: root1 = [], root2 = [1]
 输出: false




 提示：


 每棵树节点数在 [0, 100] 范围内
 每棵树中的每个值都是唯一的、在 [0, 99] 范围内的整数

 Related Topics 树 深度优先搜索 二叉树 👍 123 👎 0

 */
public class M_0951_FilpEquivalentBinaryTrees {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,null,null,null,7,8});
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1,3,2,null,6,4,5,null,null,null,null,8,7});
        treeNode1.prettyPrint();
        treeNode2.prettyPrint();

        Logger.log(flipEquiv(treeNode1, treeNode2));
    }

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.2 MB,击败了21.72% 的Java用户
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if ((root1==null&&root2!=null)||(root1!=null&&root2==null)||(root1!=null&&root2!=null&&root1.val!=root2.val)) {
            return false;
        }
        if (root1==null&&root2==root1) {
            return true;
        }
        boolean isLeft = false;
        boolean isRight = false;
        if (((root1.left==null&&root2.left==null)
                ||(root1.left!=null&&root2.left!=null&&root1.left.val==root2.left.val))
        &&((root1.right==null&&root2.right==null)
                ||(root1.right!=null&&root2.right!=null&&root1.right.val==root2.right.val))) {
            isLeft = flipEquiv(root1.left, root2.left);
            isRight = flipEquiv(root1.right, root2.right);
        } else {
            TreeNode tmp = root1.left;
            root1.left = root1.right;
            root1.right = tmp;
            isLeft = flipEquiv(root1.left, root2.left);
            isRight = flipEquiv(root1.right, root2.right);
        }
        return isLeft&&isRight;
    }

}
