package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import org.junit.Assert;
import org.junit.Test;


public class Easy0606_ConstructStringFromBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,null,6});
        treeNode.prettyPrint();
        String result = this.tree2str(treeNode);
        System.out.println(result);
    }

    public String tree2str(TreeNode root) {
        if (root==null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(root.val);
        if (root.left!=null) {
            stringBuffer.append("(");
            stringBuffer.append(tree2str(root.left));
            stringBuffer.append(")");
        } else if (root.right!=null) {
            stringBuffer.append("(");
            stringBuffer.append(")");
        }
        if (root.right!=null) {
            stringBuffer.append("(");
            stringBuffer.append(tree2str(root.right));
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }
}
