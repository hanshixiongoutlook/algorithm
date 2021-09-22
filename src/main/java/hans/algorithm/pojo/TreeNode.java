package hans.algorithm.pojo;

import java.util.Stack;

/**
 * 树的节点
 */
public class TreeNode {
    public Integer val;

    public TreeNode left;

    public TreeNode right;

    public int index;

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right, int index) {
        this.val = value;
        this.left = left;
        this.right = right;
        this.index = index;
    }

    /**
     * input a binary tree with array struct,
     * this method will turn this array tree to a linked tree,
     * and return the root of the linked binary tree.
     *
     * if param arr is null or length is 0,will return null.
     *
     * @param arr
     * @return
     */
    public static TreeNode buildTree(Integer[] arr) {
        if (arr==null||arr.length==0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0], null, null,0);
        java.util.Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curRoot = stack.pop();
            int leftIndex = curRoot.index*2+1;
            int rightIndex = curRoot.index*2+2;
            if (leftIndex<arr.length&&arr[leftIndex]!=null) {
                TreeNode left = new TreeNode(arr[leftIndex],null,null, leftIndex);
                stack.push(left);
                curRoot.left = left;
            }
            if (rightIndex< arr.length&&arr[rightIndex]!=null) {
                TreeNode right = new TreeNode(arr[rightIndex],null,null, rightIndex);
                stack.push(right);
                curRoot.right = right;
            }
        }
        return root;
    }
}
