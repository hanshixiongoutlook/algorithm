package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
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
