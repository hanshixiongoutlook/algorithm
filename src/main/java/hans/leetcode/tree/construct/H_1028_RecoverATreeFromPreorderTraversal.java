package hans.leetcode.tree.construct;

import hans.common.pojo.TreeNode;
import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        TreeNode treeNode1 = recoverFromPreorder("1-2--3---4-5--6---7");
        treeNode1.prettyPrint();
    }

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
