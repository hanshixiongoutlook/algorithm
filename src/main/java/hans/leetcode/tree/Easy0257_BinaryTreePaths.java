package hans.leetcode.tree;

import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class Easy0257_BinaryTreePaths {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new int[]{1,2,3,Integer.MIN_VALUE,5});
        System.out.println(this.binaryTreePaths(treeNode));
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
