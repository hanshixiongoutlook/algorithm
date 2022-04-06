package hans.leetcode.tree.operate;

import hans.common.pojo.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;
/**
 Given a root node reference of a BST and a key, delete the node with the given
 key in the BST. Return the root node reference (possibly updated) of the BST.

 Basically, the deletion can be divided into two stages:


 Search for a node to remove.
 If the node is found, delete the node.



 Example 1:


 Input: root = [5,3,6,2,4,null,7], key = 3
 Output: [5,4,6,2,null,null,7]
 Explanation: Given key to delete is 3. So we find the node with value 3 and
 delete it.
 One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also
 accepted.



 Example 2:


 Input: root = [5,3,6,2,4,null,7], key = 0
 Output: [5,3,6,2,4,null,7]
 Explanation: The tree does not contain a node with value = 0.


 Example 3:


 Input: root = [], key = 0
 Output: []



 Constraints:


 The number of nodes in the tree is in the range [0, 10⁴].
 -10⁵ <= Node.val <= 10⁵
 Each node has a unique value.
 root is a valid binary search tree.
 -10⁵ <= key <= 10⁵



 Follow up: Could you solve it with time complexity O(height of tree)?
 Related Topics 树 二叉搜索树 二叉树 👍 618 👎 0

 */
public class M_0450_DeleteNodeInABST {
    @Test
    public void test() {
        TreeNode integerTreeNode = TreeNode.buildSearchTree(new int[]{1,2,3,4,5,6,7,8});
        integerTreeNode.prettyPrint();
        TreeNode treeNode = this.deleteNode(integerTreeNode, 4);
        treeNode.prettyPrint();
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:38.9 MB, less than 54.43% of Java online submissions.
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        /*
        搜索二叉树特点，所有节点均遵循如下规则：left<root<right
          4
        /   \
       2     10
      / \   / \
     1  3  9   18
          /   /  \
         6   16  20
        / \     /  \
       5   7   19   21

        思路：
        1.第一步，一定是先找到目标节点，简单的搜索二叉树遍历即可
          if (root>key)
              dfs(left, key)
          else if (root<key)
              dfs(right,key)
        2.第二步，找到目标节点后，执行删除操作，即 root==key
          > 叶子节点删除，显然直接删即可
          > 非叶子节点删除，
            - 无右孩子，比如删除9，需要用7来填补9的位置，即从左侧找到最大值
            - 有右孩子，比如删18，需要以19来填补18的位置，即从右侧找到最小值

        伪代码可以写出来了
          func del(root, key) {
              if (root==null) return;

              if (root>key)
                  root.left = del(left, key)
              else if (root<key)
                  root.right = del(right,key)
              else {
                  if (root is leaf) return null;
                  if (root has right) {
                     int minOfRight = findMin(root.right);
                     root.right = del(root.right, minOfRight);
                  } else {
                     int maxOfLeft = findMax(root.left);
                     root.left = del(root.left, maxOfLeft);
                  }
              }
          }
          // 最大，不停向右遍历，最右边的就是最大值
          func findMax(root) {
             loop root->right
             return mostRight;
          }
          // 最小，不停向左遍历，最左边的就是最大值
          func findMin(root) {
             loop root->left
             return mostLeft;
          }
         */
        if (root==null) {
            return root;
        }
        if (root.val>key) {
            root.left = deleteNode(root.left, key);
        }else if (root.val<key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 叶子节点直接删除
            if (root.left==null&&root.right==null) {
                return null;
            } else if (root.right!=null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = precursor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    /**
     * 获取前驱，即比当前节点小的最大节点
     * @param root
     * @return
     */
    public int precursor(TreeNode root) {
        root = root.left;
        while (root.right!=null) root = root.right;
        return root.val;
    }

    /**
     * 获取后继，即比当前节点大的最小节点
     * @param root
     * @return
     */
    public int successor(TreeNode root) {
        root = root.right;
        while(root.left!=null) root = root.left;
        return root.val;
    }
}
