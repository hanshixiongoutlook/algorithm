package hans.leetcode;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class H_0987_VerticalTraversal {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,6,5,7});

        treeNode.prettyPrint();

        List<List<Integer>> result = this.verticalTraversal(treeNode);
        // [3.00000,14.50000,11.00000]
        Logger.log(result);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        return colMap.keySet().stream().sorted()
                .map(key-> colMap.get(key).stream().sorted((o1, o2) -> {
                    int i1 = rowMap.get(o1);
                    int i2 = rowMap.get(o2);
                    if (i1==i2) {
                        return o1.val-o2.val;
                    }
                    return i1-i2;
                }).map(n->n.val).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    Map<TreeNode, Integer> rowMap = new HashMap<>();
    Map<Integer,List<TreeNode>> colMap = new HashMap<>();
    public void dfs(TreeNode root, Integer row, Integer col) {
        if (root==null) {
            return;
        }
        List<TreeNode> list = colMap.getOrDefault(col, new LinkedList<>());
        list.add(root);
        rowMap.put(root, row);
        colMap.put(col, list);
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
}
