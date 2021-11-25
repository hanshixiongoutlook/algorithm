package hans.common.pojo;

import java.util.Scanner;
import java.util.Stack;

public class LinkedTreeNode {
    public LinkedTreeNode left;
    public LinkedTreeNode right;
    public LinkedTreeNode next;
    public Integer val;
    public int index;

    public LinkedTreeNode() {
    }

    public LinkedTreeNode(Integer value, LinkedTreeNode left, LinkedTreeNode right, int index) {
        this.val = value;
        this.left = left;
        this.right = right;
        this.index = index;
    }

    public static LinkedTreeNode buildTreeWithoutConnect(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        LinkedTreeNode root = new LinkedTreeNode(arr[0], null, null, 0);
        java.util.Stack<LinkedTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            LinkedTreeNode curRoot = stack.pop();
            int leftIndex = curRoot.index * 2 + 1;
            int rightIndex = curRoot.index * 2 + 2;
            if (leftIndex < arr.length && arr[leftIndex] != null) {
                LinkedTreeNode left = new LinkedTreeNode(arr[leftIndex], null, null, leftIndex);
                stack.push(left);
                curRoot.left = left;
            }
            if (rightIndex < arr.length && arr[rightIndex] != null) {
                LinkedTreeNode right = new LinkedTreeNode(arr[rightIndex], null, null, rightIndex);
                stack.push(right);
                curRoot.right = right;
            }
        }
        return root;
    }
    /**
     * print tree with pretty constructure</br>
     * example: [1,2,3,null,5] </br>
     * <pre>
     *      1
     *     / \
     *    /   \
     *   2     3
     *    \
     *     5
     * </pre>
     */
    public void prettyPrint() {
        int height = this.depth();
        System.out.println(prettyPrint(this, 1, height));
    }

    private StringBuilder prettyPrint(LinkedTreeNode root, int currentHeight, int totalHeight) {
        StringBuilder sb = new StringBuilder();
        int spaces = getSpaceCount(totalHeight - currentHeight + 1);
        if (root == null) {
            //create a 'spatial' block and return it
            String row = String.format("%" + (2 * spaces + 1) + "s%n", "");
            //now repeat this row space+1 times
            String block = new String(new char[spaces + 1]).replace("\0", row);
            return new StringBuilder(block);
        }
        if (currentHeight == totalHeight) return new StringBuilder(root.val + "");
        int slashes = getSlashCount(totalHeight - currentHeight + 1);
        sb.append(String.format("%" + (spaces + 1) + "s%" + spaces + "s", root.val + "", ""));
        sb.append("\n");
        //now print / and \
        // but make sure that left and right exists
        char leftSlash = root.left == null ? ' ' : '/';
        char rightSlash = root.right == null ? ' ' : '\\';
        int spaceInBetween = 1;
        for (int i = 0, space = spaces - 1; i < slashes; i++, space--, spaceInBetween += 2) {
            for (int j = 0; j < space; j++) sb.append(" ");
            sb.append(leftSlash);
            for (int j = 0; j < spaceInBetween; j++) sb.append(" ");
            sb.append(rightSlash + "");
            for (int j = 0; j < space; j++) sb.append(" ");
            sb.append("\n");
        }
        //now get string representations of left and right subtrees
        StringBuilder leftTree = prettyPrint(root.left, currentHeight + 1, totalHeight);
        StringBuilder rightTree = prettyPrint(root.right, currentHeight + 1, totalHeight);
        // now line by line print the trees side by side
        Scanner leftScanner = new Scanner(leftTree.toString());
        Scanner rightScanner = new Scanner(rightTree.toString());
        // spaceInBetween+=1;
        while (leftScanner.hasNextLine()) {
            if (currentHeight == totalHeight - 1) {
                sb.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
                sb.append("\n");
                spaceInBetween -= 2;
            } else {
                sb.append(leftScanner.nextLine());
                sb.append(" ");
                sb.append(rightScanner.nextLine() + "\n");
            }
        }

        return sb;
    }
    private int getSpaceCount(int height) {
        return (int) (3 * Math.pow(2, height - 2) - 1);
    }

    private int getSlashCount(int height) {
        if (height <= 3) return height - 1;
        return (int) (3 * Math.pow(2, height - 3) - 1);
    }
    /**
     * return the max depth of this tree
     *
     * @return
     */
    public int depth() {
        return depth(this);
    }

    private int depth(LinkedTreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left) + 1, depth(node.right) + 1);
    }
}
