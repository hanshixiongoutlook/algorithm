package hans.algorithm.sorts;

import hans.algorithm.struct.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeNodeTest {

    @Test
    public void buildBinaryTree() {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
        BinaryTreeNode<Integer> root = BinaryTreeNode.buildBinaryTree(arr);

        Assert.assertEquals(new Integer(1), root.getValue());
    }

}
