package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 * TODO 未解答
 */
public class M_0863_AllNodesDistanceKinBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        treeNode.prettyPrint();
        Logger.log(distanceK(treeNode, new TreeNode(5), 2));

    }
    List<Integer> list = new LinkedList<>();

    /**
     * 			Runtime:8 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:41.1 MB, less than 65.07% of Java online submissions.
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        vroot = root;
        distanceK(root, target, null, k);
        return list;
    }
    TreeNode vroot;
    public void distanceK(TreeNode root, TreeNode target, TreeNode parent, int k) {
        if (root==null) {
            return;
        }
        if (root.val==target.val) {
            dfs(root, k, 0);
            if (parent!=null) {
                if (k==1) {
                    list.add(parent.val);
                } else {
                    if (parent.left==root) {
                        parent.left=null;
                    } else {
                        parent.right=null;
                    }
                    distanceK(vroot, parent, k-1);
                }
            }
            return;
        }
        distanceK(root.left, target, root, k);
        distanceK(root.right, target, root, k);
    }
    public void dfs(TreeNode root, int k, int depth) {
        if (root==null) {
            return;
        }
        if (depth==k) {
            list.add(root.val);
            return;
        }
        dfs(root.left, k, depth+1);
        dfs(root.right, k, depth+1);
    }

    class Solotion {
        /**
         * 			Runtime:9 ms, faster than 99.60% of Java online submissions.
         * 			Memory Usage:41.1 MB, less than 58.09% of Java online submissions.
         * @param root
         * @param target
         * @param k
         * @return
         */
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if (root == null) {
                return new ArrayList<>();
            }
            findParent(root, null);
            findAns(target, null, 0, k);
            return ans;
        }

        List<Integer> ans = new LinkedList<>();

        public void findAns(TreeNode node, TreeNode from, int depth, int k) {
            if (node == null) {
                return;
            }
            if (depth == k) {
                ans.add(node.val);
                return;
            }
            if (node.left != from) {
                findAns(node.left, node, depth + 1, k);
            }
            if (node.right != from) {
                findAns(node.right, node, depth + 1, k);
            }
            if (map.get(node.val) != from) {
                findAns(map.get(node.val), node, depth + 1, k);
            }
        }

        Map<Integer, TreeNode> map = new HashMap<>();

        public void findParent(TreeNode root, TreeNode parent) {
            if (root == null) {
                return;
            }
            map.put(root.val, parent);
            findParent(root.left, root);
            findParent(root.right, root);
        }
    }

}
