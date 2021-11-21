package hans.leetcode.tree.design;


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
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,-13,null,null,4,5});
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
     * 			执行耗时:11 ms,击败了75.87% 的Java用户
     * 			内存消耗:40.2 MB,击败了79.99% 的Java用户
     */
    public class Codec {
        /**
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            StringBuffer buffer = new StringBuffer();
            if (root==null) {
                buffer.append("#,");
                return buffer.toString();
            }
            buffer.append(root.val).append(",");
            buffer.append(serialize(root.left));
            buffer.append(serialize(root.right));
            return buffer.toString();
        }
        public TreeNode deserialize(String data) {
            if (data==null||data.length()==0) {
                return null;
            }
            List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(list);
        }
        public TreeNode deserialize(List<String> data) {
            if (data.isEmpty()) {
                return null;
            }
            if (data.get(0).equals("#")) {
                data.remove(0);
                return null;
            }
            Integer value = Integer.valueOf(data.remove(0));
            TreeNode root = new TreeNode(value);
            root.left = deserialize(data);
            root.right = deserialize(data);
            return root;
        }
    }
    /**
     * 			执行耗时:7 ms,击败了96.03% 的Java用户
     * 			内存消耗:40.4 MB,击败了68.39% 的Java用户
     */
    public class Codec1 {
        /**
         * 序列化思路可参考 0606
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            if (root==null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(root.val);
            if (root.left!=null) {
                stringBuffer.append("(");
                stringBuffer.append(serialize(root.left));
                stringBuffer.append(")");
            } else if (root.right!=null) {
                stringBuffer.append("(");
                stringBuffer.append(")");
            }
            if (root.right!=null) {
                stringBuffer.append("(");
                stringBuffer.append(serialize(root.right));
                stringBuffer.append(")");
            }
            return stringBuffer.toString();
        }
        public TreeNode deserialize(String data) {
            if (data==null||data.length()==0) {
                return null;
            }

            int lEnd = -1;
            int lCount = 0;
            int rCount = 0;
            String leftStr = null;
            String rightStr = null;
            for (int i=0; i<data.length(); i++) {
                if (data.charAt(i)=='(') {
                    lCount++;
                    if (lEnd<0) {
                        lEnd=i;
                    }
                }
                if (data.charAt(i)==')') {
                    rCount++;
                }
                if (lCount>0&&rCount==lCount) {
                    leftStr = data.substring(lEnd+1, i);
                    if ((i+2)<data.length()) {
                        rightStr = data.substring(i+2, data.length()-1);
                    }
                    break;
                }
            }
            TreeNode root = null;
            if (lEnd<0&&data.length()>0) {
                root = new TreeNode(Integer.valueOf(data));
            }
            if (lEnd>0) {
                String val = data.substring(0,lEnd);
                root = new TreeNode(Integer.valueOf(val));
                root.left = deserialize(leftStr);
                root.right = deserialize(rightStr);
            }
            return root;
        }
    }
    /**
     * Runtime:22 ms, faster than 34.56% of Java online submissions.
     * 			Memory Usage:41.2 MB, less than 17.45% of Java online submissions.
     */
    public class Codec2 {
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
