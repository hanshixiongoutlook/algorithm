package hans.leetcode.tree.bst;

import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 穷举问题
 */
public class Medium0095_UniqueBinaySearchTree {

    @Test
    public void test() {
        List<TreeNode> trees = this.generateTrees(5);
        for (TreeNode tree : trees) {
            tree.prettyPrint();
        }

    }

    public List<TreeNode> generateTrees(int n) {
        return generateTree(1,n);
    }
    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start>end) {
            list.add(null);
            return list;
        }
        for (int i=start;i<=end;i++) {
            List<TreeNode> leftList = generateTree(start, i-1);
            List<TreeNode> rightList = generateTree(i+1, end);

            for (TreeNode left: leftList) {
                for (TreeNode right: rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }

}
