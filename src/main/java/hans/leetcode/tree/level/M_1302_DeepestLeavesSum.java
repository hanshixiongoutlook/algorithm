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
public class M_1302_DeepestLeavesSum {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,null,6,7,null,null,null,null,8});
        treeNode.prettyPrint();
        Logger.log(JSONObject.toJSONString(this.deepestLeavesSum(treeNode)));
    }

    /**
     * 			Runtime:8 ms, faster than 7.56% of Java online submissions.
     * 			Memory Usage:39.8 MB, less than 60.59% of Java online submissions.
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            if (!queue.isEmpty()) {
                sum = 0;
            }
        }
        return sum;
    }
}
