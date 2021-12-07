package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class M_1457_PseudoPalindromicPathsInaBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{2,1,1,1,3,null,null,null,null,null,1});
        Logger.log(pseudoPalindromicPaths(treeNode));
    }
    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new HashMap<>(),0);
        return count;
    }
    int count =0 ;
    public void dfs(TreeNode root, Map<Integer, Integer> map, int pathLen) {
        if (root==null) {
            return;
        }
        pathLen++;
        Map<Integer, Integer> tMap = new HashMap<>(map);
        tMap.put(root.val, tMap.getOrDefault(root.val, 0)+1);
        if (root.left==null&&root.right==null) {
            if (isPalindrome(tMap, pathLen)) {
                count++;
            }
        }
        dfs(root.left, tMap, pathLen);
        dfs(root.right, tMap, pathLen);
    }

    public boolean isPalindrome(Map<Integer, Integer> map, int pathLen) {
        // 统计出现奇数次的数字个数
        long oddCount=map.values().stream().filter(ele->ele%2==1).count();
        // 组成回文数，要求，如果list有奇数个，则有且只能有一个数字出现奇数次
        // 如果list有偶数个，则不能有数字出现奇数次
        return (pathLen%2==1&&oddCount==1) || (pathLen%2==0&&oddCount==0);
    }
}
