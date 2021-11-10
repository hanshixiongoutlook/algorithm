package hans.leetcode.tree.binary;


import com.alibaba.fastjson.JSONObject;
import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 前序、后续兼顾
 */
public class Medium0113_PathSum {

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
