package hans.algorithm.traversal;

import hans.algorithm.struct.BinaryTreeNode;
import org.junit.Test;

import java.util.Stack;

public class BinaryTreeTraversal {


    @Test
    public void test() {
        /*
               1
            2     3
          4   5  6 7
         8 9 n 10

         */
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,null,10};
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildBinaryTree(arr);

        System.out.print("preorder traversal  : ");
        preOrder(root);
        System.out.print("\r\nnon-recursive preorder traversal : ");
        nonRecursivePre(root);

        System.out.print("\r\ninorder traversal   : ");
        inOrder(root);
        System.out.print("\r\nnon-recursive inorder traversal : ");
        nonRecursiveIn(root);

        System.out.print("\r\npostorder traversal : ");
        postOrder(root);
        System.out.print("\r\nnon-recursive postorder traversal : ");
        nonRecursivePost(root);
    }


    /**
     * It's very easy to traversal the binary tree by recursive.
     * Here are three ways(these are one of the Depth First Search traversal[DFS]):
     * 1.preorder, root->left->right
     * 2.inorder, left->root->right
     * 3.postorder, left->right->root
     */
    public void preOrder(BinaryTreeNode root) {
        if (root==null) {
            return;
        }
        System.out.print(root.getValue()+" ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public void inOrder(BinaryTreeNode root) {
        if (root==null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue()+" ");
        inOrder(root.getRight());
    }
    public void postOrder(BinaryTreeNode root) {
        if (root==null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue()+" ");
    }


    /**
     * Imitate the recursive push stack process,
     * We can restore the traversal of binary tree by non-recursive method with stack.
     * If you can imagine the process of recursive,
     * You can try debugging the recursive method and find the principle.
     */
    public void nonRecursivePre(BinaryTreeNode<Integer> root) {
        int[] flag = new int[11];
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> cur = root;
        while (!stack.isEmpty()||cur!=null) {
            while (cur!=null) {
                if (flag[cur.getIndex()]==0) {
                    System.out.print(cur.getValue()+" ");
                }
                stack.push(cur);
                cur = cur.getLeft();
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (flag[cur.getIndex()]==0) {
                    stack.push(cur);
                }
                flag[cur.getIndex()]=++flag[cur.getIndex()];
                cur = cur.getRight();
            }
        }
    }
    public void nonRecursiveIn(BinaryTreeNode<Integer> root) {
        int[] flag = new int[11];
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> cur = root;
        while (!stack.isEmpty()||cur!=null) {
            while (cur!=null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (flag[cur.getIndex()]==0) {
                    stack.push(cur);
                }
                flag[cur.getIndex()]=++flag[cur.getIndex()];
                if (flag[cur.getIndex()]==1) {
                    System.out.print(cur.getValue()+" ");
                }
                cur = cur.getRight();
            }
        }
    }
    public void nonRecursivePost(BinaryTreeNode<Integer> root) {
        int[] flag = new int[11];
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> cur = root;
        while (!stack.isEmpty()||cur!=null) {
            while (cur!=null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (flag[cur.getIndex()]==0) {
                    stack.push(cur);
                }
                flag[cur.getIndex()]=++flag[cur.getIndex()];
                if (flag[cur.getIndex()]==2) {
                    System.out.print(cur.getValue()+" ");
                }
                cur = cur.getRight();
            }
        }
    }
    /**
     * Breadth First Search -> BFS
     */

}
