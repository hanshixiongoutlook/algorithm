package hans.leetcode.tree.path;

import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 Given the root of a binary tree, return all root-to-leaf paths in any order.

 A leaf is a node with no children.


 Example 1:


 Input: root = [1,2,3,null,5]
 Output: ["1->2->5","1->3"]


 Example 2:


 Input: root = [1]
 Output: ["1"]



 Constraints:


 The number of nodes in the tree is in the range [1, 100].
 -100 <= Node.val <= 100

 Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 700 👎 0

 */
public class E_0257_BinaryTreePaths {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,5});
        treeNode.prettyPrint();
        Logger.log(this.binaryTreePaths(treeNode));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        binaryTreePathBuild(root, "", result);
        return result;
    }

    public void binaryTreePathBuild(TreeNode root, String path, List<String> list) {
        if (root==null) {
            return;
        }
        String newPath = path+root.val;
        if (root.right==null&&root.left==null) {
            list.add(newPath);
        } else {
            newPath+="->";
        }
        binaryTreePathBuild(root.left, newPath, list);
        binaryTreePathBuild(root.right, newPath, list);
    }
}
