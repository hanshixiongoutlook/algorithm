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
 Given the root of a binary tree, return the bottom-up level order traversal of
 its nodes' values. (i.e., from left to right, level by level from leaf to root).



 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: [[15,7],[9,20],[3]]


 Example 2:


 Input: root = [1]
 Output: [[1]]


 Example 3:


 Input: root = []
 Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 2000].
 -1000 <= Node.val <= 1000

 Related Topics 树 广度优先搜索 二叉树 👍 547 👎 0

 */
public class M_0107_TreeLevelOrderTraversal2 {

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
