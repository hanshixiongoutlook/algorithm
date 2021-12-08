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
public class M_Offer32_LeverOrder {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,6,7});
        treeNode.prettyPrint();
        Logger.log(levelOrder(treeNode));
    }
    public int[] levelOrder(TreeNode root) {
        if (root==null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left!=null) {
                queue.add(node.left);
            }
            if (node.right!=null) {
                queue.add(node.right);
            }
        }
        int[] arr = new int[list.size()];
        int idx = 0;
        for (Integer i: list) {
            arr[idx++]=i;
        }
        return arr;
    }
}
