package hans.leetcode.tree.level;


import com.alibaba.fastjson.JSONObject;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

public class M_0103_TreeZigzagLevelOrderTraversal {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7});
        treeNode.prettyPrint();
        Logger.log(new Solution1().zigzagLevelOrder(treeNode));
    }
    class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root==null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            double count = 1;
            int level = 1;
            List<List<Integer>> result = new LinkedList<>();
            while (!queue.isEmpty()) {
                List<Integer> levelList = new LinkedList<>();
                double countNext = 2*count;
                for (int i=0;i<count;i++) {
                    TreeNode node = queue.remove();
                    if (level%2==0) {
                        levelList.add(0,node.val);
                    } else {
                        levelList.add(node.val);
                    }
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
                level++;
                if (levelList.size()>0) {
                    result.add(levelList);
                }
            }
            return result;
        }
    }

}
