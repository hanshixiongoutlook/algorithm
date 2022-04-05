package hans.leetcode.tree.path;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given the root of a binary tree and an integer targetSum, return the number of
 paths where the sum of the values along the path equals targetSum.

 The path does not need to start or end at the root or a leaf, but it must go
 downwards (i.e., traveling only from parent nodes to child nodes).


 Example 1:


 Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 Output: 3
 Explanation: The paths that sum to 8 are shown.


 Example 2:


 Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 Output: 3



 Constraints:


 The number of nodes in the tree is in the range [0, 1000].
 -10⁹ <= Node.val <= 10⁹
 -1000 <= targetSum <= 1000

 Related Topics 树 深度优先搜索 二叉树 👍 1288 👎 0

 */
public class M_0437_PathSum {

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
