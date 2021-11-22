package hans.leetcode.tree.path;

import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * https://leetcode-cn.com/problems/binary-tree-paths/
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
