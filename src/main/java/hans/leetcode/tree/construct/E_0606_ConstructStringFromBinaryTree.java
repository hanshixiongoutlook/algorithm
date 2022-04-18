package hans.leetcode.tree.construct;


import hans.common.pojo.TreeNode;
import org.junit.Test;


public class E_0606_ConstructStringFromBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,2,null,null,null,5});
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
        }
        // 左树空，但右树不为空，需要把左侧填充上()
        if (root.left==null && root.right!=null) {
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
