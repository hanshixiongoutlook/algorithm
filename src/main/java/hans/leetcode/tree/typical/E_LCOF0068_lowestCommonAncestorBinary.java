package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 * 同236
 */
public class E_LCOF0068_lowestCommonAncestorBinary {

    @Test
    public void test() {
//        1,2,2,3,3,null,null,4,4
        // 3,9,20,null,null,15,7
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        treeNode.prettyPrint();

        TreeNode result = this.lowestCommonAncestor(treeNode, new TreeNode(2), new TreeNode(4));
        Logger.log(result.val);
        TreeNode result2 = this.lowestCommonAncestor2(treeNode, new TreeNode(2), new TreeNode(4));
        Logger.log(result2.val);
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        if (root.val==p.val||root.val==q.val) {
            return root;
        }
        int left = find2(root.left, p, q);
        if (left==1) {
            return root;
        } else if (left==0) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return lowestCommonAncestor2(root.left, p, q);
    }
    public int find2(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return 0;
        }
        if (root.val==p.val || root.val==q.val) {
            return find2(root.left,p,q)+find2(root.right,p,q)+1;
        }
        return find2(root.left,p,q)+find2(root.right,p,q);
    }
    /**
     * 			Runtime:6 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:40.6 MB, less than 37.35% of Java online submissions.
     */
    TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        find(root, p, q);
        return ancestor;
    }
    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return false;
        }
        boolean left = find(root.left,p,q);
        boolean right = find(root.right,p,q);
        if (((root.val==p.val||root.val==q.val)&&(left||right)) || (left&&right)) {
            ancestor = root;
        }
        return (root.val==p.val||root.val==q.val)||(left||right);
    }

    /**
     * 穷举法
     */
    public static class MySolution1{
        TreeNode ancestor = null;
        boolean pFind = false;
        boolean qFind = false;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root==null) {
                return null;
            }
            isAncestor(root, p, q);
            if (pFind&&qFind) {
                ancestor = root;
            }
            pFind=false;
            qFind=false;
            lowestCommonAncestor(root.left, p, q);
            lowestCommonAncestor(root.right, p, q);
            return ancestor;
        }

        public void isAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root==null) {
                return;
            }
            if (root.val==p.val) {
                pFind = true;
            }
            if (root.val==q.val) {
                qFind = true;
            }
            isAncestor(root.left, p, q);
            isAncestor(root.right, p, q);
        }
    }

}
