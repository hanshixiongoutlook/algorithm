package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
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
