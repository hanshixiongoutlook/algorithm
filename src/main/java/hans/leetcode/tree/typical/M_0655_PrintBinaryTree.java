package hans.leetcode.tree.typical;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 Given the root of a binary tree, construct a 0-indexed m x n string matrix res
 that represents a formatted layout of the tree. The formatted layout matrix
 should be constructed using the following rules:


 The height of the tree is height and the number of rows m should be equal to
 height + 1.
 The number of columns n should be equal to 2ʰᵉⁱᵍʰᵗ⁺¹ - 1.
 Place the root node in the middle of the top row (more formally, at location
 res[0][(n-1)/2]).
 For each node that has been placed in the matrix at position res[r][c], place
 its left child at res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] and its right child at res[r+1][c+2ʰᵉⁱᵍ
 ʰᵗ⁻ʳ⁻¹].
 Continue this process until all the nodes in the tree have been placed.
 Any empty cells should contain the empty string "".


 Return the constructed matrix res.


 Example 1:


 Input: root = [1,2]
 Output:
 [["","1",""],
  ["2","",""]]


 Example 2:


 Input: root = [1,2,3,null,4]
 Output:
 [["","","","1","","",""],
  ["","2","","","","3",""],
  ["","","4","","","",""]]



 Constraints:


 The number of nodes in the tree is in the range [1, 2¹⁰].
 -99 <= Node.val <= 99
 The depth of the tree will be in the range [1, 10].

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 118 👎 0

 */
public class M_0655_PrintBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,4,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18});
        treeNode.prettyPrint();
        Logger.log(depth(treeNode));
        List<List<String>> lists = printTree(treeNode);
        for (List<String> l: lists) {
            for (String v: l) {
                if (v.isEmpty()) {
                    System.out.print(" ");
                } else {
                    System.out.print(v);
                }
            }
            System.out.println();
        }
        Logger.log(lists);
    }

    /**
     * Runtime:5 ms, faster than 55.52% of Java online submissions.
     * Memory Usage:38.7 MB, less than 39.47% of Java online subm
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        /*
        分治法
         */
        if (root==null) {
            return new ArrayList<>();
        }
        int height = depth(root);
        String[][] res = new String[height][(1<<height)-1];
        for (String[] arr: res) {
            Arrays.fill(arr, "");
        }
        fill(res, root, 0, 0, res[0].length);
        List<List<String>> printList = new ArrayList<>(height);
        for (String[] arr: res) {
            printList.add(Arrays.asList(arr));
        }
        return printList;
    }
    public void fill(String[][] res, TreeNode root, int h, int l, int r) {
        if (root==null) {
            return;
        }
        res[h][(l+r)/2] = root.val+"";
        fill(res, root.left, h+1, l, (l+r)/2);
        fill(res, root.right, h+1, (l+r)/2+1, r);
    }

    public int depth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        return Math.max(depth(root.left)+1, depth(root.right)+1);
    }
    class Mysolution {
        /**
         * 			Runtime:6 ms, faster than 17.06% of Java online submissions.
         * 			Memory Usage:38.7 MB, less than 30.77% of Java online submissions.
         * @param root
         * @return
         */
        public List<List<String>> printTree(TreeNode root) {
            if (root==null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            int height = depth(root);
            int max = Double.valueOf(Math.pow(2, height)-1).intValue();
            List<List<String>> printList = new ArrayList<>(height);

            queue.offer(root);
            List<Integer> nextIndex = new LinkedList<>();
            int index = Double.valueOf(max/2).intValue();
            int level = 1;
            while(!queue.isEmpty()) {
                List<String> levelList = new ArrayList<>(max);
                int size = queue.size();
                int pollCount = 0;
                for (int i=0; i<max; i++) {
                    if (index==i&&pollCount<size) {
                        TreeNode node = queue.poll();
                        if (node.left!=null) {
                            queue.offer(node.left);
                            int leftIdx = Double.valueOf(i-Math.pow(2, height-level-1)).intValue();
                            nextIndex.add(leftIdx);
                        }
                        if (node.right!=null) {
                            queue.offer(node.right);
                            int rightIdx = Double.valueOf(i+Math.pow(2, height-level-1)).intValue();
                            nextIndex.add(rightIdx);
                        }
                        if (pollCount<size&&!nextIndex.isEmpty()) {
                            index = nextIndex.remove(0);
                        }
                        levelList.add(node.val+"");
                        pollCount++;
                    } else {
                        levelList.add("");
                    }
                }
                printList.add(levelList);
                level++;
            }
            return printList;
        }

        public int depth(TreeNode root) {
            if (root==null) {
                return 0;
            }
            return Math.max(depth(root.left)+1, depth(root.right)+1);
        }
    }


}
