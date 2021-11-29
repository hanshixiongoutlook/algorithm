package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class M_0958_CheckCompletenessOfaBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1,2,3});
        treeNode1.prettyPrint();

        Logger.log(isCompleteTree(treeNode1));
    }

    /**
     * 			执行耗时:1 ms,击败了82.89% 的Java用户
     * 			内存消耗:37.8 MB,击败了52.21% 的Java用户
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        int size;
        boolean findNull = false;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null) {
                    if (findNull) {
                        return false;
                    }
                    queue.offer(poll.left);
                } else {
                    findNull = true;
                }
                if (poll.right!=null) {
                    if (findNull) {
                        return false;
                    }
                    queue.offer(poll.right);
                } else {
                    findNull = true;
                }
            }

            if (!queue.isEmpty()&&size<levelSize) {
                return false;
            }
            levelSize*=2;
        }
        return true;
    }

}
