package hans.leetcode.tree.path;


import hans.algorithm.pojo.TreeNode;
import org.junit.Test;


public class Medium0437_PathSum {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
//
        treeNode.prettyPrint();
        System.out.println(this.pathSum(treeNode,8));
    }

    /**
     * 			执行耗时:25 ms,击败了44.62% 的Java用户
     * 			内存消耗:38.3 MB,击败了23.46% 的Java用户
     */
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) {
            return count;
        }
        pathSum(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }
    public void pathSum(TreeNode root, int targetSum, int sum) {

        if (root==null) {
            return ;
        }
        if ((sum+root.val)==targetSum) {
            count++;
        }
        pathSum(root.left, targetSum, sum+root.val);
        pathSum(root.right, targetSum, sum+root.val);
    }
}
