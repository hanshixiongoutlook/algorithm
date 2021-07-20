package hans.algorithm.tree;

import hans.algorithm.pojo.Stack;
import hans.algorithm.pojo.TreeNode;
import org.junit.Test;

/**
 * 树的三种遍历方法
 * 前序、中序、后序
 */
public class TreeTraval {
    
    @Test
    public void test() {
        TreeNode root = TreeTraval.build();
        System.out.println("\r\n---- 前序");
        preOrder(root);
        System.out.println("\r\n---- 中序");
        inOrder(root);
        System.out.println("\r\n---- 后序");
        postOrder(root);
    }
    @Test
    public void testPreOrder() {
        TreeNode root = TreeTraval.build();
        System.out.println("---- 前序非递归");
        preOrder2(root);
        System.out.println("\r\n---- 前序递归");
        preOrder(root);
    }
    /**
     * recursive pre order
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root==null) {
            return;
        }
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder2(TreeNode root) {
        if (root==null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        while (true) {
            while (root!=null) {
                System.out.print(root.value+" ");
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.right;
        }
    }
    @Test
    public void testInOrder() {
        TreeNode root = TreeTraval.build();
        System.out.println("---- 中序非递归");
        inOrder2(root);
        System.out.println("\r\n---- 中序递归");
        inOrder(root);
    }
    public void inOrder(TreeNode root) {
        if (root==null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.value+" ");
        preOrder(root.right);
    }

    public void inOrder2(TreeNode root) {
        if (root==null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            System.out.print(root.value+" ");
            root = root.right;
        }
    }
    @Test
    public void testPostOrder() {
        TreeNode root = TreeTraval.build();
        System.out.println("---- 后序非递归");
        postOrder2(root);
        System.out.println("\r\n---- 后序递归");
        postOrder(root);
    }
    public void postOrder(TreeNode root) {
        if (root==null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.value+" ");
    }
    public void postOrder2(TreeNode root) {
        if (root==null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.right;
            if (root!=null) {

                System.out.print(root.value+" ");
            }
        }
    }

    /*
           1
     2          3
  4    5      6    7
8  9 10 11  12 13 14 15
     */
    public static TreeNode build() {
        TreeNode n8 = new TreeNode(8, null, null);
        TreeNode n9 = new TreeNode(9, null, null);
        TreeNode n10 = new TreeNode(10, null, null);
        TreeNode n11 = new TreeNode(11, null, null);
        TreeNode n12 = new TreeNode(12, null, null);
        TreeNode n13 = new TreeNode(13, null, null);
        TreeNode n14 = new TreeNode(14, null, null);
        TreeNode n15 = new TreeNode(15, null, null);

        TreeNode n4 = new TreeNode(4, n8, n9);
        TreeNode n5 = new TreeNode(5, n10, n11);

        TreeNode n6 = new TreeNode(6, n12, n13);
        TreeNode n7 = new TreeNode(7, n14, n15);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);

        TreeNode n1 = new TreeNode(1, n2, n3);

        return n1;
    }

}
