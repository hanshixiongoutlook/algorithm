package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M_0623_AddOneRowToTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4,2,6,3,1,5});
        treeNode.prettyPrint();
        treeNode = addOneRow(treeNode,1,1);
        treeNode.prettyPrint();
    }

    /**
     * 			执行耗时:1 ms,击败了53.66% 的Java用户
     * 			内存消耗:38.3 MB,击败了61.22% 的Java用户
     * @param root
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth==1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if ((depth-1)==level) {
                    TreeNode nodel = new TreeNode(val);
                    nodel.left = cur.left;
                    cur.left = nodel;

                    TreeNode noder = new TreeNode(val);
                    noder.right = cur.right;
                    cur.right = noder;
                }
                if (cur.left!=null) {
                    queue.offer(cur.left);
                }
                if (cur.right!=null) {
                    queue.offer(cur.right);
                }
            }
            if (depth==level) {
                return root;
            }
            level++;
        }
        return root;
    }
}
