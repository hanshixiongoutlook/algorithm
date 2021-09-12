package hans.algorithm.struct;

import java.util.Stack;

/**
 * this is the struct of linked binary tree node.
 */
public class BinaryTreeNode<T> {
    /**
     * left child
     */
    private BinaryTreeNode<T> left;
    /**
     * right child
     */
    private BinaryTreeNode<T> right;
    /**
     * node value
     */
    private T value;
    /**
     * array index
     */
    private int index;


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
    public static <T> BinaryTreeNode<T> buildBinaryTree(T[] arr) {
        if (arr==null||arr.length==0) {
            return null;
        }
        BinaryTreeNode<T> root = new BinaryTreeNode<>(null, null, arr[0], 0);
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            BinaryTreeNode<T> curRoot = stack.pop();
            int leftIndex = curRoot.getIndex()*2+1;
            int rightIndex = curRoot.getIndex()*2+2;
            if (leftIndex<arr.length) {
                BinaryTreeNode<T> left = new BinaryTreeNode<>(null,null,arr[leftIndex],leftIndex);
                stack.push(left);
                curRoot.setLeft(left);
            }
            if (rightIndex< arr.length) {
                BinaryTreeNode<T> right = new BinaryTreeNode<>(null,null,arr[rightIndex],rightIndex);
                stack.push(right);
                curRoot.setRight(right);
            }
        }
        return root;
    }

    public BinaryTreeNode() {
    }

    /**
     *
     * @param left
     * @param right
     * @param value
     */
    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    /**
     *
     * @param left
     * @param right
     * @param value
     * @param index
     */
    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T value, int index) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.index = index;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
