package hans.leetcode.tree.typical;


import hans.common.pojo.NTreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given an n-ary tree, return the level order traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal,
 each group of children is separated by the null value (See examples).


 Example 1:




 Input: root = [1,null,3,2,4,null,5,6]
 Output: [[1],[3,2,4],[5,6]]


 Example 2:




 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,1
 2,null,13,null,null,14]
 Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]



 Constraints:


 The height of the n-ary tree is less than or equal to 1000
 The total number of nodes is between [0, 10⁴]

 Related Topics 树 广度优先搜索 👍 210 👎 0

 */
public class M_0429_NaryTreeLevelOrderTraversal {

    @Test
    public void test() {
//        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,5,5});
//        treeNode.prettyPrint();
//        int i = levelOrder(treeNode);
//        Logger.log(i);
    }

    /**
     * 			Runtime:3 ms, faster than 70.10% of Java online submissions.
     * 			Memory Usage:39.5 MB, less than 5.23% of Java online submissions.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(NTreeNode root) {
        if (root==null) {
            return new LinkedList<>();
        }
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> list = new LinkedList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i=0; i<size; i++) {
                NTreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.children!=null) {
                    for (NTreeNode n: node.children) {
                        queue.offer(n);
                    }
                }
            }
            list.add(levelList);
        }
        return list;
    }
}
