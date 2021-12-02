package hans.leetcode.tree.level;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 *
 * 同 103
 *
 */
public class M_1104_PathInZigzagLabelledBinaryTree {

    @Test
    public void test() {
        Logger.log(Math.pow(2, Math.sqrt(26)+1));
        Logger.log(pathInZigZagTree(2));
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        if (label<=0) {
            return list;
        }
        int level = 2,
                levelNum = 2,
                total=levelNum*2-1,
                levelCounter=0,
                targetIndex=-1;
        int[] tree = new int[label*2];
        tree[0] = 1;
        for (int i=1; i<label*2; i++) {
            if (level%2==0) {
                tree[i] = total+levelNum-1-i;
            } else {
                tree[i] = i+1;
            }
            if (tree[i]==label) {
                targetIndex=i;
                break;
            }
            levelCounter++;
            if (levelCounter==levelNum) {
                level++;
                levelNum = levelNum<<1;
                total=levelNum*2-1;
                levelCounter=0;
            }
        }

        int parent = targetIndex;
        while (parent>0) {
            parent = (parent-1)/2;
            if (parent>=0) {
                list.add(0,tree[parent]);
            }
        }
        list.add(label);
        return list;
    }


}
