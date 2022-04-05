package hans.leetcode.tree.path;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 You are given the root of a binary tree where each node has a value 0 or 1.
 Each root-to-leaf path represents a binary number starting with the most
 significant bit.


 For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01
 101 in binary, which is 13.


 For all leaves in the tree, consider the numbers represented by the path from
 the root to that leaf. Return the sum of these numbers.

 The test cases are generated so that the answer fits in a 32-bits integer.


 Example 1:


 Input: root = [1,0,1,0,1,0,1]
 Output: 22
 Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


 Example 2:


 Input: root = [0]
 Output: 0



 Constraints:


 The number of nodes in the tree is in the range [1, 1000].
 Node.val is 0 or 1.

 Related Topics 树 深度优先搜索 二叉树 👍 141 👎 0

 */
public class E_1022_SumOfRootToLeafBinaryNumbers {

    @Test
    public void test() {
//        System.out.println(binaryToDecimal("100"));
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,0,1,0,1,0,1});
        treeNode.prettyPrint();

        int result = this.sumRootToLeaf(treeNode);
        Logger.log(result);
    }
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root==null) {
            return 0;
        }
        sumRootToLeaf(root, 0);
        return sum;
    }
    // resolution 1
    public void sumRootToLeaf(TreeNode root, int parentSum) {
        if (root==null) {
            return;
        }
        int curSum = parentSum*2+root.val;
        if (root.left==null&&root.right==null) {
            sum +=curSum;
            return;
        }
        sumRootToLeaf(root.left, curSum);
        sumRootToLeaf(root.right, curSum);

    }
    // resolution 2
    public void sumRootToLeaf(TreeNode root, String binaryStr, int depth) {
        if (root==null) {
            return;
        }
        if (binaryStr.length()>=depth) {
            binaryStr.substring(0, depth);
        }
        binaryStr+=root.val;
        if (root.left==null&&root.right==null) {
            sum +=binaryToDecimal(binaryStr.toString());
        }
        sumRootToLeaf(root.left, binaryStr, depth+1);
        sumRootToLeaf(root.right, binaryStr, depth+1);

    }
    private int binaryToDecimal(String binary) {
        Double decimal = 0.0;
        for (int i=0; i<binary.length(); i++) {
            if (binary.charAt(i)=='1') {
                decimal+=Math.pow(2, binary.length()-i-1);
            }
        }
        return decimal.intValue();
    }

}
