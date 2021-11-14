package hans.leetcode.tree.binary;


import hans.algorithm.pojo.TreeNode;
import hans.algorithm.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 *
 */
public class Hard0297_SerializeAndDeserializeBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,null,4,5});
        treeNode.prettyPrint();
//        TreeNode treeNode = new TreeNode(0);
//        TreeNode next = treeNode;
//        for (int i=1;i<5;i++) {
//            next.right = new TreeNode(i);
//            next = next.right;
//        }
        Codec codec = new Codec();

        String str = codec.serialize(treeNode);
        Logger.log(str);
        TreeNode decode = codec.deserialize(str);
        decode.prettyPrint();
    }

    /**
     * Runtime:22 ms, faster than 34.56% of Java online submissions.
     * 			Memory Usage:41.2 MB, less than 17.45% of Java online submissions.
     */
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null) {
                return null;
            }
            StringBuffer buffer = new StringBuffer();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int count = 0;
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                buffer.append(node.val);
                if (node.left!=null) {
                    count++;
                    queue.offer(node.left);
                    buffer.append("@").append("l").append(count);
                }
                if (node.right!=null) {
                    count++;
                    queue.offer(node.right);
                    buffer.append("@").append("r").append(count);
                }
                buffer.append(",");
            }
            return buffer.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data==null||data.length()==0) {
                return null;
            }
            String[] split = data.split(",");
            String[] element = split[0].split("@");
            TreeNode root = new TreeNode(Integer.valueOf(element[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            for (int i=0; i<split.length; i++) {
                TreeNode node = queue.poll();
                String[] elements = split[i].split("@");
                for (int j=0;j<elements.length;j++) {
                    if (elements[j].contains("l")) {
                        int index = Integer.valueOf(elements[j].split("l")[1]);
                        int value = Integer.valueOf(split[index].split("@")[0]);
                        node.left = new TreeNode(value);
                        queue.offer(node.left);
                    }
                    if (elements[j].contains("r")) {
                        int index = Integer.valueOf(elements[j].split("r")[1]);
                        int value = Integer.valueOf(split[index].split("@")[0]);
                        node.right = new TreeNode(value);
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }


}
