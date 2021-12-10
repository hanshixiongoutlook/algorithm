package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class M_0652_FindDuplicateSubtrees {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
        treeNode.prettyPrint();
        Logger.log(findDuplicateSubtrees(treeNode));

    }


    Map<String, Integer> map = new HashMap();
    List<TreeNode> nodes = new LinkedList<>();

    /**
     * 			Runtime:12 ms, faster than 99.05% of Java online submissions.
     * 			Memory Usage:48.7 MB, less than 12.71% of Java online submissions.
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return nodes;
        }
        preorder(root);

        return nodes;
    }
    public String preorder(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        StringBuffer buf = new StringBuffer();
        buf.append(root.val).append(",");
        buf.append(preorder(root.left));
        buf.append(preorder(root.right));
        int count = map.getOrDefault(buf.toString(), 0)+1;
        map.put(buf.toString(), count);
        if (count == 2) {
            nodes.add(root);
        }
        return buf.toString();
    }

}
