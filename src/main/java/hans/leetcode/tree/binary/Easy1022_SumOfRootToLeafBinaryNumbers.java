package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;


public class Easy1022_SumOfRootToLeafBinaryNumbers {

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
