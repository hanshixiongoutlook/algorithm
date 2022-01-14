package hans.leetcode.tree.easy;


import com.alibaba.fastjson.JSONObject;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 Given the root of a binary search tree (BST) with duplicates, return all the
 mode(s) (i.e., the most frequently occurred element) in it.

 If the tree has more than one mode, return them in any order.

 Assume a BST is defined as follows:


 The left subtree of a node contains only nodes with keys less than or equal to
 the node's key.
 The right subtree of a node contains only nodes with keys greater than or
 equal to the node's key.
 Both the left and right subtrees must also be binary search trees.



 Example 1:


 Input: root = [1,null,2,2]
 Output: [2]


 Example 2:


 Input: root = [0]
 Output: [0]



 Constraints:


 The number of nodes in the tree is in the range [1, 10⁴].
 -10⁵ <= Node.val <= 10⁵



 Follow up: Could you do that without using any extra space? (Assume that the
 implicit stack space incurred due to recursion does not count). Related Topics 树 深度
 优先搜索 二叉搜索树 二叉树 👍 397 👎 0

 */
public class E_0501_FindModeInBinarySearch {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,2,null,null,2});
        treeNode.prettyPrint();
        int[] mode = this.findMode(treeNode);
        Logger.log(JSONObject.toJSONString(mode)+":"+max);
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max=0;
    public int[] findMode(TreeNode root) {
        if (root==null) {
            return null;
        }
        this.traversal(root);
        List<Integer> list = new ArrayList<>();
        map.forEach((v,c)->{
            if (c==max) {
                list.add(v);
            }
        });
        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void traversal(TreeNode root) {
        if (root==null) {
            return;
        }
        Integer count = map.get(root.val);
        count = count==null?1:++count;
        if (count>max) {
            max = count;
        }
        map.put(root.val, count);
        findMode(root.left);
        findMode(root.right);
    }

}
