package hans.leetcode.tree.binary;


import com.alibaba.fastjson.JSONObject;
import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
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
public class Medium0107_TreeLevelOrderTraversal2 {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,6,7});
        treeNode.prettyPrint();
        Logger.log(JSONObject.toJSONString(this.levelOrderBottom(treeNode)));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double count = 1;
        List<List<Integer>> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> levelList = new LinkedList<>();
            double countNext = 2*count;
            for (int i=0;i<count;i++) {
                TreeNode node = queue.remove();
                levelList.add(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                } else {
                    countNext--;
                }
                if (node.right!=null) {
                    queue.add(node.right);
                } else {
                    countNext--;
                }
            }
            count = countNext;
            if (levelList.size()>0) {
                result.add(0, levelList);
            }
        }
        return result;
    }
}
