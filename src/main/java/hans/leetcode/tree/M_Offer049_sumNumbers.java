package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class M_Offer049_sumNumbers {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4,9,0,5,1});
        treeNode.prettyPrint();
        System.out.println(this.sumNumbers(treeNode));
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:35.9 MB, less than 41.11% of Java online submissions.
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    int sum = 0;
    public void dfs(TreeNode root, int pathNum) {
        if (root==null) {
            return;
        }
        pathNum = pathNum*10+root.val;
        if (root.left==null&&root.right==null) {
            sum+=pathNum;
        }
        dfs(root.left, pathNum);
        dfs(root.right, pathNum);
    }

}
