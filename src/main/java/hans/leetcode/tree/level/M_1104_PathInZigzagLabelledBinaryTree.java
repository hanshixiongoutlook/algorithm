package hans.leetcode.tree.level;


import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 In an infinite binary tree where every node has two children, the nodes are
 labelled in row order.

 In the odd numbered rows (ie., the first, third, fifth,...), the labelling is
 left to right, while in the even numbered rows (second, fourth, sixth,...), the
 labelling is right to left.



 Given the label of a node in this tree, return the labels in the path from the
 root of the tree to the node with that label.


 Example 1:


 Input: label = 14
 Output: [1,3,4,14]


 Example 2:


 Input: label = 26
 Output: [1,2,6,10,26]



 Constraints:


 1 <= label <= 10^6

 Related Topics 树 数学 二叉树 👍 172 👎 0

 */
public class M_1104_PathInZigzagLabelledBinaryTree {

    @Test
    public void test() {
        int a = 9;
        int c = 0;
        while(a!=0) {
            a=a>>1;
            c++;
        }
        boolean isReverse = c%2==0;
        int levelTotal = (int)Math.pow(2, c-1);
        int start = (int)Math.pow(2, c)-1-levelTotal;
        int end = (int)Math.pow(2, c)-1;


        Logger.log(a+".."+c);
        Logger.log(pathInZigZagTree(5));
    }
    public List<Integer> pathInZigZagTree2(int label) {
        return null;
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
