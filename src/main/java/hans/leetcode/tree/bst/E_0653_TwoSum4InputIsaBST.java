package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 Given the root of a Binary Search Tree and a target number k, return true if
 there exist two elements in the BST such that their sum is equal to the given
 target.


 Example 1:


 Input: root = [5,3,6,2,4,null,7], k = 9
 Output: true


 Example 2:


 Input: root = [5,3,6,2,4,null,7], k = 28
 Output: false



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 -10⁴ <= Node.val <= 10⁴
 root is guaranteed to be a valid binary search tree.
 -10⁵ <= k <= 10⁵

 Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 304 👎 0

 */
public class E_0653_TwoSum4InputIsaBST {

    @Test
    public void test() {
        // true 5,3,6,2,4,null,7       9
        // false 5,3,6,2,4,null,7     28
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,1,3});
        treeNode.prettyPrint();
        boolean mode = this.findTarget2(treeNode, 4);
        Logger.log(mode);
    }
    public boolean findTarget2(TreeNode root, int k) {
        if (root==null) {
            return false;
        }
        if (base==null) {
            base=root;
        }
        int tar = k-root.val;
        boolean exist;
        if (tar<root.val) {
            exist = findNode(base, tar);
        } else {
            exist = findNode(base, tar);
        }
        return exist||findTarget2(root.left, k)||findTarget2(root.right, k);
    }
    TreeNode base = null;
    public boolean findTarget(TreeNode root, int k) {
        if (root==null) {
            return false;
        }
        if (base==null) {
            base = root;
        }
        boolean left = false;
        boolean right = false;
        int diff = k-root.val;
        if (root.val>diff&&diff!=root.val) {
            left = findNode(base, diff);
        } else if (root.val<diff&&diff!=root.val){
            right = findNode(base, diff);
        }
        if (left||right) {
            return true;
        }
        if (root.val>k) {
            left = findTarget(root.left, k);
        } else {
            left = findTarget(root.left, k);
            right = findTarget(root.right, k);
        }
        return left||right;
    }

    public boolean findNode(TreeNode root, int target) {
        if (root==null) {
            return false;
        }
        if (root.val==target) {
            return true;
        }
        if (root.val>target) {
            return findNode(root.left, target);
        } else {
            return findNode(root.right, target);
        }
    }


}
