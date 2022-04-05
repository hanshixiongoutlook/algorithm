package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given the roots of two binary trees root and subRoot, return true if there is a
 subtree of root with the same structure and node values of subRoot and false
 otherwise.

 A subtree of a binary tree tree is a tree that consists of a node in tree and
 all of this node's descendants. The tree tree could also be considered as a
 subtree of itself.


 Example 1:


 Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 Output: true


 Example 2:


 Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 Output: false



 Constraints:


 The number of nodes in the root tree is in the range [1, 2000].
 The number of nodes in the subRoot tree is in the range [1, 1000].
 -10⁴ <= root.val <= 10⁴
 -10⁴ <= subRoot.val <= 10⁴

 Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 685 👎 0

 */
public class E_0572_SubtreeOfAnotherTree {

    /**
     * TODO Time Complexity can be more optimized
     */
    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,4,5,1,2});
        TreeNode subTree = TreeNode.buildTree(new Integer[]{4,1,2});

//
        System.out.println(this.isSubtree(treeNode, subTree));
        System.out.println(this.isSubtree2(treeNode, subTree));

    }

    /**
     * 			执行耗时:4 ms,击败了16.20% 的Java用户
     * 			内存消耗:41.6 MB,击败了14.75% 的Java用户
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        }
        if (root!=null) {
            boolean l = isSubtree(root.left, subRoot);
            boolean r= isSubtree(root.right, subRoot);
            return l||r;
        }
        return false;
    }

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root==null||subRoot==null) {
            return root==subRoot;
        }
        if (root.val!=subRoot.val) {
            return false;
        }
        boolean l = isSame(root.left, subRoot.left);
        boolean r = isSame(root.right, subRoot.right);

        return l&&r;

    }

    /**
     * 			执行耗时:9 ms,击败了5.60% 的Java用户
     * 			内存消耗:41.5 MB,击败了28.70% 的Java用户
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        String str1 = ","+serialize(root);
        String str2 = ","+serialize(subRoot);
        return str1.contains(str2);
    }
    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        if (root==null) {
            buffer.append("#,");
            return buffer.toString();
        }
        buffer.append(root.val).append(",");
        buffer.append(serialize(root.left));
        buffer.append(serialize(root.right));
        return buffer.toString();
    }

}
