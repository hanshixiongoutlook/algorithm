package hans.leetcode.tree;


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
        for (int i=10000000; i<10000002; i++) {
            pathInZigZagTree(i);
        }
    }
    List<Integer> list = new LinkedList<>();
    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.1 MB,击败了20.23% 的Java用户
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        int depth = calcDepth(label);
        int index = depth%2==1?label:(int) (Math.pow(2,depth)-1-label+Math.pow(2, depth-1));
        dfs(index, depth);
        return list;
    }
    public void dfs(int index, int depth) {

        /*
                   1
              2            3
          4      5      6      7
        8  9  10  11  12 13  14  15

        根=1时，二叉树有以下特点
        1.由根计算左右子节点值的计算公式为
        left  = root*2
        right = root*2+1

        2.由子节点计算root的公式为(其中left总是为偶数，right总是为奇数)
        root = left/2
        root = (right-1)/2

        3.每一层的取值范围计算公式
        其中level为层，且根节点所在层为1
        [2^(level-1), 2^level-1]

        因此对于普通二叉树，给出一个节点，寻找root->node路径方式为，如，给出节点为10
        则路径为：10->(10/2=5)->((5-1)/2=2)->2/2=1，即1->2->5->10

        # 回到题目，数的结构变成了之字型，因此需要考虑通过节点值推算索引及逆推方式
                   1
              3            2
          4      5      6      7
        15  14 13 12  11  10  9  8
        在之字型树中，奇数层的节点值即为索引值，而偶数层则需要进行转换，公式如下
        value=(2^level-1) - (index-2^(level-1))
        index=(2^level-1)-value+2^(level-1)
         */

        if (index<1) {
            return;
        }
        int curVal = index;
        // 偶数层，需要将索引转换成值
        if (depth%2==0) {
            curVal = (int)((Math.pow(2, depth)-1) - (index-Math.pow(2, depth-1)));
        }
        list.add(0, curVal);
        int pindex = index%2==0?index/2:(index-1)/2;
        dfs(pindex, depth-1);
    }
    public int calcDepth(int node) {
        int depth = 0;
        while(node!=0) {
            node=node>>1;
            depth++;
        }
        return depth;
    }


}
