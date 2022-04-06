package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 You are given the root of a binary tree where each node has a value in the
 range [0, 25] representing the letters 'a' to 'z'.

 Return the lexicographically smallest string that starts at a leaf of this
 tree and ends at the root.

 As a reminder, any shorter prefix of a string is lexicographically smaller.


 For example, "ab" is lexicographically smaller than "aba".


 A leaf of a node is a node that has no children.


 Example 1:


 Input: root = [0,1,2,3,4,3,4]
 Output: "dba"


 Example 2:


 Input: root = [25,1,3,1,3,0,2]
 Output: "adz"


 Example 3:


 Input: root = [2,2,1,null,1,0,null,0]
 Output: "abc"



 Constraints:


 The number of nodes in the tree is in the range [1, 8500].
 0 <= Node.val <= 25

 Related Topics 树 深度优先搜索 字符串 二叉树 👍 78 👎 0

 */
public class M_0988_SmallestStringStartingFromLeaf {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{25,1,3,1,3,0,2});
        treeNode1.prettyPrint();

        Logger.log(smallestFromLeaf(treeNode1));
    }

    String[] dict = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q"
            ,"r","s","t","u","v","w","x","y","z"};
    String smallest = null;

    /**
     * 			执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.1 MB,击败了77.69% 的Java用户
     * @param root
     * @return
     */
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return smallest;
    }
    public void dfs(TreeNode root, String str) {
        if (root==null) {
            return;
        }
        str = dict[root.val]+str;
        if (root.left==null&&root.right==null) {
            if (smallest==null) {
                smallest = str;
            } else if (smallest.compareTo(str)>0) {
                smallest = str;
            }
        }
        dfs(root.left, str);
        dfs(root.right, str);
    }
}
