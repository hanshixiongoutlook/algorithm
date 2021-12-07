package hans.leetcode.tree;


import hans.common.pojo.ListNode;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 */
public class M_1379_FindACorrespondingNodeOfaBinaryTreeInaCloneOfThatTree {

    @Test
    public void test() {
        TreeNode treeNode1 = TreeNode.buildTree(new Integer[]{1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3});
        treeNode1.prettyPrint();
        ListNode list = ListNode.build(new Integer[]{4,2,8});
//        Logger.log(getTargetCopy(list, treeNode1));
//        Logger.log("target = {}", listStr);
//        Logger.log("find = {}", findStr);

    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned==null) {
            return null;
        }
        if (cloned.val==target.val) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original, cloned.left, target);
        TreeNode right = getTargetCopy(original, cloned.right, target);
        return left==null?right:left;
    }


}
