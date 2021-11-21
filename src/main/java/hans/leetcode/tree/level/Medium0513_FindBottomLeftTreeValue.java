package hans.leetcode.tree.level;


import com.alibaba.fastjson.JSONObject;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 同 103
 *
 */
public class Medium0513_FindBottomLeftTreeValue {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,6,7});
        treeNode.prettyPrint();
        Logger.log(findBottomLeftValue(treeNode));
    }

    /**
     * 			执行耗时:1 ms,击败了68.95% 的Java用户
     * 			内存消耗:38 MB,击败了62.33% 的Java用户
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root==null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left=-1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size;i++) {
                TreeNode node = queue.poll();
                if (i==0) {
                    left = node.val;
                }
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
        }
        return left;
    }
}
