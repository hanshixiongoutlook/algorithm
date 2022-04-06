package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 Given a binary tree root, a node X in the tree is named good if in the path
 from root to X there are no nodes with a value greater than X.

 Return the number of good nodes in the binary tree.


 Example 1:




 Input: root = [3,1,4,3,null,1,5]
 Output: 4
 Explanation: Nodes in blue are good.
 Root Node (3) is always a good node.
 Node 4 -> (3,4) is the maximum value in the path starting from the root.
 Node 5 -> (3,4,5) is the maximum value in the path
 Node 3 -> (3,1,3) is the maximum value in the path.

 Example 2:




 Input: root = [3,3,null,4,2]
 Output: 3
 Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

 Example 3:


 Input: root = [1]
 Output: 1
 Explanation: Root is considered as good.


 Constraints:


 The number of nodes in the binary tree is in the range [1, 10^5].
 Each node's value is between [-10^4, 10^4].
 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 51 👎 0

 */
public class M_1448_CountGoodNodesInBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1});
        treeNode1.prettyPrint();
        goodNodes(treeNode1);
        Logger.log(count);
    }

    public int goodNodes(TreeNode root) {
        dfs(root, new ArrayList<>());
        return count;
    }
    int count=1;
    public void dfs(TreeNode root, List<Integer> path) {
        if (root==null) {
            return;
        }
        List<Integer> tPath = new ArrayList<>(path.size()+1);
        tPath.addAll(path);
        Optional<Integer> max = tPath.stream().max(Integer::compareTo);
        if (max.isPresent()&&max.get()<=root.val) {
            count++;
        }
        tPath.add(root.val);
        dfs(root.left, tPath);
        dfs(root.right, tPath);
    }
}
