package hans.algorithm.pojo;

/**
 * 树的节点
 */
public class TreeNode<T> {
    public T value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(T value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
