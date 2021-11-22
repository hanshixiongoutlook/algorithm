package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M_0515_FindLargestValueInEachTreeRow {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,6,7});
        treeNode.prettyPrint();
        Logger.log(largestValues(treeNode));
    }

    /**
     * 			执行耗时:2 ms,击败了88.90% 的Java用户
     * 			内存消耗:38.5 MB,击败了76.94% 的Java用户
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
