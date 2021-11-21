package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 */
public class Medium0129_SumRootToLeafNumbers {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3});
        treeNode.prettyPrint();
        System.out.println(sumNumbers(treeNode));

    }

    int sum;
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }
    public void sumNumbers(TreeNode root, int concatNum) {
        if (root==null) {
            return;
        }
        concatNum = concatNum*10+root.val;
        if (root.left==null&&root.right==null) {
            sum+=concatNum;
            return;
        }
        sumNumbers(root.left, concatNum);
        sumNumbers(root.right, concatNum);
    }

}
