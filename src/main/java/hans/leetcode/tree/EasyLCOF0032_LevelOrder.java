package hans.leetcode.tree;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class EasyLCOF0032_LevelOrder {

    @Test
    public void test() {
//        1,2,2,3,3,null,null,4,4
        // 3,9,20,null,null,15,7
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7});
        treeNode.prettyPrint();

        List<List<Integer>> result = this.levelOrder(treeNode);
        Logger.log(result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root==null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()||!queue2.isEmpty()) {
            List<Integer> values = new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                values.add(node.val);
                if (node.left!=null) {
                    queue2.add(node.left);
                }
                if (node.right!=null) {
                    queue2.add(node.right);
                }
                list.add(values);
            }
            values = new LinkedList<>();
            while(!queue2.isEmpty()) {
                TreeNode node = queue2.remove();
                values.add(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            list.add(values);
        }
        return list;
    }
}
