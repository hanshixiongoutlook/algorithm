package hans.leetcode.tree.typical;


import hans.common.utils.Logger;
import org.junit.Test;

/**
 One way to serialize a binary tree is to use preorder traversal. When we
 encounter a non-null node, we record the node's value. If it is a null node, we record
 using a sentinel value such as '#'.

 For example, the above binary tree can be serialized to the string "9,3,4,#,#,1
 ,#,#,2,#,6,#,#", where '#' represents a null node.

 Given a string of comma-separated values preorder, return true if it is a
 correct preorder traversal serialization of a binary tree.

 It is guaranteed that each comma-separated value in the string must be either
 an integer or a character '#' representing null pointer.

 You may assume that the input format is always valid.


 For example, it could never contain two consecutive commas, such as "1,,3".


 Note: You are not allowed to reconstruct the tree.


 Example 1:
 Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Output: true
 Example 2:
 Input: preorder = "1,#"
 Output: false
 Example 3:
 Input: preorder = "9,#,#,1"
 Output: false


 Constraints:


 1 <= preorder.length <= 10⁴
 preorder consist of integers in the range [0, 100] and '#' separated by commas
 ','.

 Related Topics 栈 树 字符串 二叉树 👍 370 👎 0

 */
public class M_0331_VerifyPreorderSerializationOfaBinaryTree {

    /**
     Runtime:1 ms, faster than 83.25% of Java online submissions.
     Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
     */
    @Test
    public void test() {
        // 9,3,4,#,#,1,#,#,2,#,6,#,#  true
        // 9,#,#,1 false
        String preorder = "1,2,#,#,#";
        Logger.log(isValidSerialization(preorder));

    }

    /**
     * TODO 思路清奇
     * 			执行耗时:3 ms,击败了79.22% 的Java用户
     * 			内存消耗:38.5 MB,击败了33.30% 的Java用户
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder==null||preorder.length()==0) {
            return true;
        }

        /*
        只有前序遍历才能使用这种方式
        对于一棵树，如果根节点为null，则前序结果为#
        每增加一个节点则#的数量也会增加一个
        如
         1 -> 1,#,#
       --------------------------------
         1
       2    -> 1,2,#,#,#
       --------------------------------
         1
       2   3 -> 1,2,#,#,3,#,#
       --------------------------------
          1
         /
       2
        \
         3   ->1,2,#,3,#,#,#

         因此可以认为
         1.当树一个节点都没有的时候，有1个#
         2.每增加一个节点#的数量增加一个，即，#的个数总比数字的个数多一个
         由于采用前序遍历，即 根-左-右
         因此可以用这个关系来判断树的合法性
         即，初始时
         stack=1
         数字增加一个增stack++
         #增加一个stack--，即消耗一个
         最后刚好全部抵消掉，即#的个数为0
         */
        String[] splits = preorder.split(",");
        int stack = 1;
        for (int i=0; i<splits.length; i++) {
            if (splits[i].equals("#")) {
                if (stack==0) {
                    return false;
                }
                stack--;
            } else {
                if (stack==0) {
                    return false;
                }
                stack++;
            }

        }
        return stack==0;
    }

}
