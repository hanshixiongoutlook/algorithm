package hans.leetcode.tree.path;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 */
public class Hard0124_TreeMaximumPathSum {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,-6,-7});
        treeNode.prettyPrint();
        System.out.println(maxPathSum(treeNode));
        System.out.println(new MySolution().maxPathSum(treeNode));
    }

    /**
     * Runtime:1 ms, faster than 56.50% of Java online submissions.
     * Memory Usage:40.4 MB, less than 26.61% of Java online submissions.
     */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root==null) {
            return -1;
        }
        maxGain(root);
        return max;

    }

    public Integer maxGain(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int lmax = Math.max(maxGain(root.left),0);
        int rmax = Math.max(maxGain(root.right),0);
        max = Math.max(max, root.val+lmax+rmax);
        return root.val+Math.max(lmax,rmax);
    }


    /**
     * Runtime:339 ms, faster than 56.50% of Java online submissions.
     * Memory Usage:42 MB, less than 5.01% of Java online submissions.
     */
    class MySolution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if (root==null) {
                return -1;
            }
            int lmax = Math.max(maxPathSum(root.left, 0, Integer.MIN_VALUE),0);
            int rmax = Math.max(maxPathSum(root.right, 0, Integer.MIN_VALUE),0);
            max = Math.max(lmax+rmax+root.val, max);
            maxPathSum(root.left);
            maxPathSum(root.right);
            return max;

        }
        public Integer maxPathSum(TreeNode root, int sum, int max) {
            if (root==null) {
                return max;
            }
            sum+=root.val;
            max = Math.max(max, sum);
            return Math.max(maxPathSum(root.left, sum, max),maxPathSum(root.right, sum, max));
        }
    }




}
