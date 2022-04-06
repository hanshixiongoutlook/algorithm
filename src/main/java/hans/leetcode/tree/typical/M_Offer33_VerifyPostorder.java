package hans.leetcode.tree.typical;


import hans.common.utils.Logger;
import org.junit.Test;

/**
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。



 参考以下这颗二叉搜索树：

 5
 / \
 2   6
 / \
 1   3

 示例 1：

 输入: [1,6,3,2,5]
 输出: false

 示例 2：

 输入: [1,3,2,6,5]
 输出: true



 提示：


 数组长度 <= 1000

 Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 479 👎 0

 */
public class M_Offer33_VerifyPostorder {

    @Test
    public void test() {
        // 9,3,4,#,#,1,#,#,2,#,6,#,#  true
        // 9,#,#,1 false
        int[] postorder = new int[]{1,2,5,10,6,9,4,3};
        Logger.log(verifyPostorder(postorder));
    }
    public boolean verifyPostorder(int[] postorder) {
        /*
        分治法

        基本情况：空数组是合法的搜索二叉树
                 5
            3        9
          1  4     8   10

        后续遍历结果：[1,4,3,8,10,9,5]
        特点：
        1.根在最后
        2.小于根连续值为左子树
        3.剩余值为右子树
        4.可以认为左子树总是合法的，就可以通过判断右子树是否合法检验整棵树，即右子树所有值均大于根
        同理，左子树和右子树也需要满足该规则

        boolean dfs(int[] postorder) {
            // 根
            root=postorder[postorder.length-1]
            // 左子树有效末尾索引，默认不存在
            int leftLastIndex = -1;
            foreach(i in postorder.length-1) {
                // 找到第一个>=root的索引后，前一个就是目标索引
                if (postorder[i]>=root) leftLastIndex=i-1;
            }
            leftTree = postorder[0...leftLastIndex]
            rightTree = postorder[leftLastIndex+1...postorder.length-2]
            // 剩下的元素都是右子树的，需要保证他们都大于root
            foreach(i=leftLastIndex+1 in postorder.length-2) {
                if(postorder[i]<=root) return false;
            }

            // 继续检查左右子树，并且两颗树都要合法才行
            return dfs(leftTree)&&dfs(rightTree);

        }
         */
        if (postorder.length==0) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length-1);
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了17.53%的用户
     * @param postorder
     * @param sidx
     * @param eidx
     * @return
     */
    public boolean verifyPostorder(int[] postorder, int sidx, int eidx) {
        if (sidx>=eidx) {
            return true;
        }
        // 左子树合法范围
        int lend = -1;
        for (int i=sidx; i<=eidx; i++) {
            if (postorder[i]>=postorder[eidx]) {
                lend = i-1;
                break;
            }
        }
        // 判断右子树是否合法
        for (int i=lend+1; i<eidx; i++) {
            if (postorder[i]<postorder[eidx]) {
                return false;
            }
        }
        return verifyPostorder(postorder, sidx, lend) && verifyPostorder(postorder, lend+1, eidx-1);
    }
}
