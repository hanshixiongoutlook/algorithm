package hans.leetcode.tree.construct;

import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class H_1028_RecoverATreeFromPreorderTraversal {

    @Test
    public void test() {
//        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7});
//        treeNode.prettyPrint();
//        treeNode.preoderPrint();
//        treeNode.postoderPrint();
        // 1-2--3--4-5--6--7
        // 1-2--3---4-5--6---7
        String str = "1-2--3---4-5--6---7";
        TreeNode treeNode1 = recoverFromPreorder("1-2--3---4-5--6---7");
        treeNode1.prettyPrint();
        TreeNode treeNode = new Solution().recoverFromPreorder(str);
        treeNode.prettyPrint();
    }

    /**
     * 			Runtime:57 ms, faster than 5.40% of Java online submissions.
     * 			Memory Usage:41.9 MB, less than 24.82% of Java online submissions.
     * @param traversal
     * @return
     */
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal==null||traversal.length()==0) {
            return null;
        }
        String[] split = traversal.split("-");
        int rootVal = Integer.valueOf(split[0]);

        boolean isLeft = false;
        List<String> left = new LinkedList<>();
        List<String> right = new LinkedList<>();
        for (int i=1; i<split.length; i++) {
            if (!split[i-1].isEmpty()&&!split[i].isEmpty()) {
                isLeft = !isLeft;
            }
            if (isLeft) {
                left.add(split[i].isEmpty()?"-":split[i]);
            } else {
                right.add(split[i].isEmpty()?"-":split[i]);
            }
        }
        String traversalLeft = left.stream().collect(Collectors.joining());
        String traversalRight = right.stream().collect(Collectors.joining());

        TreeNode root = new TreeNode(rootVal);
        root.left = recoverFromPreorder(traversalLeft);
        root.right = recoverFromPreorder(traversalRight);
        return root;
    }
    class Solution {
        /**
         * 			Runtime:70 ms, faster than 5.24% of Java online submissions.
         * 			Memory Usage:39.6 MB, less than 5.24% of Java online submissions.
         * @param traversal
         * @return
         */
        public TreeNode recoverFromPreorder(String traversal) {
            if (traversal==null||traversal.length()==0) {
                return null;
            }
            int rootVal = this.parseRootVal(traversal);
            String[] leftAndRight = parseLeftAndRight(traversal);
            TreeNode node = new TreeNode(rootVal);
            node.left = recoverFromPreorder(leftAndRight[0]);
            node.right = recoverFromPreorder(leftAndRight[1]);
            return node;
        }
        public int parseRootVal(String traversal) {
            return Integer.valueOf(traversal.split("-")[0]);
        }
        public String[] parseLeftAndRight(String traversal) {
            int firstSignIdx=-1,secNumIdx=-1,minSpace=-1,spaceCount=0,splitIdx=-1;
            for (int i=0; i<traversal.length(); i++) {
                if (traversal.charAt(i)=='-') {
                    spaceCount++;
                } else {
                    if (spaceCount==minSpace) {
                        splitIdx=i;
                        break;
                    }
                    spaceCount=0;
                }
                if (traversal.charAt(i)=='-'&&firstSignIdx<0) {
                    firstSignIdx=i;
                }
                if (traversal.charAt(i)!='-'&&firstSignIdx>0&&secNumIdx<0) {
                    secNumIdx=i;
                    minSpace=secNumIdx-firstSignIdx;
                }
            }
            String right = null;
            String left = null;
            if (splitIdx>0) {
                right = traversal.substring(splitIdx);
                left = traversal.substring(secNumIdx, splitIdx-minSpace);
            } else if (secNumIdx>0) {
                left = traversal.substring(secNumIdx);
            }
            String[] leftAndRight = new String[]{left, right};

            return leftAndRight;
        }
    }


}
