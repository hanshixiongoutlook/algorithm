package hans.common.pojo;

import hans.common.utils.Logger;

import java.util.*;

/**
 * 树的节点
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * input a binary tree with array struct,
     * this method will turn this array tree to a linked tree,
     * and return the root of the linked binary tree.
     * <p>
     * if param arr is null or length is 0,will return null.
     *
     * @param arr
     * @return
     */
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int li = 2*i+1;
            int ri = li+1;
            if (node!=null) {
                if (li< arr.length&&arr[li]!=null) {
                    node.left = new TreeNode(arr[li]);
                }
                if (ri< arr.length&&arr[ri]!=null) {
                    node.right = new TreeNode(arr[ri]);
                }
                queue.offer(node.left);
                queue.offer(node.right);
                i++;
            }
        }
        return root;
    }

    /**
     * build a binary search tree
     * @param arr
     * @return
     */
    public static TreeNode buildSearchTree(int[] arr) {
        Arrays.sort(arr);
        return sortedArrayToBST(arr, 0, arr.length-1);
    }
    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start>end) {
            return null;
        }
        TreeNode root = new TreeNode(nums[(end-start)/2+start]);
        root.left = sortedArrayToBST(nums, start, (end-start)/2+start-1);
        root.right = sortedArrayToBST(nums, (end-start)/2+start+1, end);
        return root;
    }

    /**
     * return the max depth of this tree
     *
     * @return
     */
    public int depth() {
        return depth(this);
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(depth(treeNode.left) + 1, depth(treeNode.right) + 1);
    }

    /**
     * print tree with array constructure
     * <pre>
     *     [1,2,3,null,5]
     * </pre>
     */
    public void arrayPrint() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        Deque<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node!=null) {
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                list.add(null);
            }
        }
        while (list.getLast()==null) {
            list.pollLast();
        }
        Logger.log(list);
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

    private StringBuilder prettyPrint(TreeNode root, int currentHeight, int totalHeight) {
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

    public void preoderPrint() {
        preoderPrint(this);
        System.out.println();
    }
    private void preoderPrint(TreeNode treeNode) {
        if (treeNode==null) {
            Logger.logWithoutEnter("#,");
            return;
        }
        Logger.logWithoutEnter(treeNode.val+",");
        preoderPrint(treeNode.left);
        preoderPrint(treeNode.right);
    }

    public void inoderPrint() {
        inoderPrint(this);
        System.out.println();
    }
    private void inoderPrint(TreeNode treeNode) {
        if (treeNode==null) {
            return;
        }
        inoderPrint(treeNode.left);
        Logger.logWithoutEnter(treeNode.val+",");
        inoderPrint(treeNode.right);
    }

    public void postoderPrint() {
        postoderPrint(this);
        System.out.println();
    }
    private void postoderPrint(TreeNode treeNode) {
        if (treeNode==null) {
            return;
        }
        postoderPrint(treeNode.left);
        postoderPrint(treeNode.right);
        Logger.logWithoutEnter(treeNode.val+",");
    }
}
