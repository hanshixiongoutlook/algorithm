package hans.leetcode.tree.path;


import com.alibaba.fastjson.JSONObject;
import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 Given the root of a binary tree and an integer targetSum, return all root-to-
 leaf paths where the sum of the node values in the path equals targetSum. Each
 path should be returned as a list of the node values, not node references.

 A root-to-leaf path is a path starting from the root and ending at any leaf
 node. A leaf is a node with no children.


 Example 1:


 Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 Output: [[5,4,11,2],[5,8,4,5]]
 Explanation: There are two paths whose sum equals targetSum:
 5 + 4 + 11 + 2 = 22
 5 + 8 + 4 + 5 = 22


 Example 2:


 Input: root = [1,2,3], targetSum = 5
 Output: []


 Example 3:


 Input: root = [1,2], targetSum = 0
 Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 5000].
 -1000 <= Node.val <= 1000
 -1000 <= targetSum <= 1000

 Related Topics 树 深度优先搜索 回溯 二叉树 👍 710 👎 0

 */
public class M_0113_PathSum {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        treeNode.prettyPrint();
        System.out.println(JSONObject.toJSONString(pathSum(treeNode,22)));
    }
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Integer> path = new LinkedList<>();
        pathSum(root, path, targetSum, 0);
        return result;
    }
    public void pathSum(TreeNode root, Deque<Integer> path, int targetSum, int sum) {
        if (root==null) {
            return;
        }
        path.add(root.val);
        sum+=root.val;
        if (sum==targetSum&&root.left==null&&root.right==null) {
            result.add(new LinkedList<>(path));
        }
        pathSum(root.left, path, targetSum, sum);
        pathSum(root.right, path, targetSum, sum);
        path.pollLast();
    }

}
