package hans.leetcode.tree.bst.operate;

import hans.common.pojo.TreeNode;
import org.junit.Test;
/**
 You are given the root node of a binary search tree (BST) and a value to insert
 into the tree. Return the root node of the BST after the insertion. It is
 guaranteed that the new value does not exist in the original BST.

 Notice that there may exist multiple valid ways for the insertion, as long as
 the tree remains a BST after insertion. You can return any of them.


 Example 1:


 Input: root = [4,2,7,1,3], val = 5
 Output: [4,2,7,1,3,5]
 Explanation: Another accepted tree is:



 Example 2:


 Input: root = [40,20,60,10,30,50,70], val = 25
 Output: [40,20,60,10,30,50,70,null,null,25]


 Example 3:


 Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 Output: [4,2,7,1,3,5]



 Constraints:


 The number of nodes in the tree will be in the range [0, 10⁴].
 -10⁸ <= Node.val <= 10⁸
 All the values Node.val are unique.
 -10⁸ <= val <= 10⁸
 It's guaranteed that val does not exist in the original BST.

 Related Topics 树 二叉搜索树 二叉树 👍 251 👎 0

 */
public class M_0701_InsertIntoABinarySearchTree {
    @Test
    public void test() {
        TreeNode integerTreeNode = TreeNode.buildTree(new Integer[]{4,2,7,1,3});
        integerTreeNode.prettyPrint();
        TreeNode treeNode = this.insertIntoBST(integerTreeNode, 5);
        treeNode.prettyPrint();
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:39.2 MB, less than 18.09% of Java online submissions
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        /*
        搜索二叉树特点，所有节点均遵循如下规则：left<root<right
          4
        /   \
       2     10
      / \   / \
     1  3  7   18
          /   /  \
         6   16  20
        思路：
        1.把数据放到叶子节点上
        比如，上例中插入19，有两种方式
            方式一        方式二
            18            18
           /  \          /  \
          16   19       16  20
                \          /
                 20       19
         显然，方式二更简单，为什么，方式二只需要将19挂到20后即可，方式一则需要将19挂到18后在把20挂到19后，显然多了一步
         2.把数据放到刚好空缺的位置
         比如，上例中插入8
            方式一        方式二
            10            10
           /             /  \
          8             7
         /            /  \
        7            6    8
       /
      6
         显然，7的右侧刚好空出一个位置，把8放过去即可

         接下来把思路转化成代码
         1.寻找插入位置
         if (root.val<val)
            // 右侧刚好空出来了
            if (root.right==null)
               root.right = val
            else
               // 否则继续向右找
               root.right = dfs(root.right)
         else if (root.val>val)
            // 左侧刚好空出来了
            if (root.left==null)
               root.left = val
            else
               // 否则继续向左找
               root.left = dfs(root.left)
         // 插入值如果树里已经有了则不需要处理，否则会破坏搜索树结构
         return root;


         */

        if (root==null) {
            return new TreeNode(val);
        }
        if (root.val>val) {
            if (root.left==null) {
                TreeNode node = new TreeNode(val);
                root.left = node;
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        } else if (root.val<val) {
            if (root.right==null) {
                TreeNode node = new TreeNode(val);
                root.right = node;
            } else {
                root.right = insertIntoBST(root.right, val);
            }
        }
        return root;

    }
}
