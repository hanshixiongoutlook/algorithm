package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 */
public class M_1361_ValidateBinaryTreeNodes {

    @Test
    public void test() {
//        1,-1,3,-1    2,-1,-1,-1
//        1,-1,3,-1    2,3,-1,-1
        boolean b = validateBinaryTreeNodes(4, new int[]{-1,-1,0,-1}, new int[]{3,-1,1,-1});
        Logger.log(b);
    }

    /**
     * TODO ???
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(0);
        queue.offer(root);
        map.put(0, root);
        for (int i=0; i<n; i++) {
            if (queue.isEmpty()) {
                return false;
            }
            TreeNode next = queue.poll();
            if (leftChild[i]>=0) {
                if (map.containsKey(leftChild[i])) {
                    return false;
                }
                next.left = new TreeNode(leftChild[i]);
                queue.offer(next.left);
                map.put(next.left.val, next.left);
            }
            if (rightChild[i]>=0) {
                if (map.containsKey(rightChild[i])) {
                    return false;
                }
                next.right = new TreeNode(rightChild[i]);
                queue.offer(next.right);
                map.put(next.right.val, next.right);
            }
        }
        return true;
    }


}
