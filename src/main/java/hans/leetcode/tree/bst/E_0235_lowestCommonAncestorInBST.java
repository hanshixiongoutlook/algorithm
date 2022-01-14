package hans.leetcode.tree.bst;

import hans.common.pojo.TreeNode;
import org.junit.Test;

/**
 Given a binary search tree (BST), find the lowest common ancestor (LCA) of two
 given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor
 is defined between two nodes p and q as the lowest node in T that has both p and
 q as descendants (where we allow a node to be a descendant of itself).”


 Example 1:


 Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 Output: 6
 Explanation: The LCA of nodes 2 and 8 is 6.


 Example 2:


 Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 Output: 2
 Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of
 itself according to the LCA definition.


 Example 3:


 Input: root = [2,1], p = 2, q = 1
 Output: 2



 Constraints:


 The number of nodes in the tree is in the range [2, 10⁵].
 -10⁹ <= Node.val <= 10⁹
 All Node.val are unique.
 p != q
 p and q will exist in the BST.

 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 738 👎 0

 */

public class E_0235_lowestCommonAncestorInBST {

    @Test
    public void test() {
        Integer[] arr = new Integer[]{3,1,4,Integer.MIN_VALUE,2};
        TreeNode integerTreeNode = TreeNode.buildTree(arr);
        integerTreeNode.prettyPrint();
        TreeNode treeNode = this.lowestCommonAncestor(integerTreeNode, new TreeNode(2), new TreeNode(3));
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        搜索二叉树特点，所有节点均遵循如下规则：left<root<right
        有了这个规则，找最小祖先就很简单了
              4
            /   \
           2     10
          / \   / \
         1  3  9   18
              /   /  \
             6   16  20
            / \     /  \
           5   7   19   21
         引申一下BST的特点，即: (root-left) * (root-right) < 0
         因为左侧都比root小，所以root-left>0; 右侧都比root大，所以root-right<0，那么乘积一定<0
         从题意看出，输入1,2 会返回2，即ancestor是给出的节点之一，则乘积为0

         归纳：
         判断最小公共祖先方法：(ancestor-p)*(ancestor-q)<=0
         接下来遍历BST
         从跟开始
         ancestor=root
         while (ancestor!=null)
             // 匹配上了，直接返回
             if ( (ancestor-p)*(ancestor-q)<=0 )
                return ancestor
             // 选其中一个点，不断向其逼近
             if ( ancestor<p ) {
                ancestor = ancestor.right
             } else {
                ancestor = ancestor.left
             }
         */
        if (root==null) {
            return null;
        }
        TreeNode next = root;
        while (next!=null) {
            if ((next.val-p.val)*(next.val- q.val)<=0) {
                break;
            }
            if (next.val<p.val) {
                next = next.right;
            } else {
                next = next.left;
            }
        }
        return next;
    }
}
