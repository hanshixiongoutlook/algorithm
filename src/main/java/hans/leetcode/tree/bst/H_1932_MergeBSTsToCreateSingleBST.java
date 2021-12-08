package hans.leetcode.tree.bst;


import hans.common.pojo.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 同783
 */
public class H_1932_MergeBSTsToCreateSingleBST {

    @Test
    public void test() {
        // [[2,1],[3,2,5],[5,4]]
        // [[5,3,8],[3,2,6]]
        // [[2,1],[3,2,5],[5,4]]
        // [[2,null,3],[5,1],[4,2],[1,null,4]]
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{4,1});
        treeNode.prettyPrint();
        TreeNode treeNode2 = TreeNode.buildTree(new Integer[]{1,null,2});
        treeNode2.prettyPrint();
        TreeNode treeNode3 = TreeNode.buildTree(new Integer[]{2,null,3});
        treeNode3.prettyPrint();
        TreeNode treeNode4 = TreeNode.buildTree(new Integer[]{1,null,4});
        treeNode4.prettyPrint();
        List<TreeNode> list = new ArrayList<>();
        list.add(treeNode);
        list.add(treeNode2);
        list.add(treeNode3);
//        list.add(treeNode4);
        TreeNode mode = this.canMerge(list);
        mode.prettyPrint();
    }
    public TreeNode canMerge(List<TreeNode> trees) {
        while(trees.size()>1) {
            Map<String, TreeNode> map = findTree(trees);
            if (map.isEmpty()) {
                return null;
            }
            TreeNode root = map.get("root");
            TreeNode tomerge = map.get("tomerge");
            TreeNode parent = map.get("parent");
            if (parent.val>tomerge.val) {
                parent.left = tomerge;
            } else {
                parent.right = tomerge;
            }
            if (root.val>tomerge.val) {
                int max = find(tomerge, true);
                if (root.val<=max||parent.val<=max) {
                    return null;
                }
            } else {
                int min = find(tomerge, false);
                if (root.val>=min||parent.val>=min) {
                    return null;
                }
            }
            trees.remove(tomerge);
        }
        return trees.get(0);
    }
    public int find(TreeNode node, boolean isMax) {
        TreeNode next = node;
        while(next!=null) {
            if (isMax) {
                if (next.right==null) {
                    break;
                }
                next = next.right;
            } else {
                if (next.left==null) {
                    break;
                }
                next = next.left;
            }
        }
        return next.val;
    }
    public Map<String, TreeNode> findTree(List<TreeNode> list) {
        Map<String,TreeNode> map = new HashMap<>();
        TreeNode node0 = list.get(0);
        for (int i=1; i<list.size(); i++) {
            TreeNode node = list.get(i);
            if ((node.left!=null&&node0.val==node.left.val)||
                    (node.right!=null&&node0.val==node.right.val)) {
                map.put("root", node);
                map.put("tomerge", node0);
                map.put("parent", node);
                break;
            }
            TreeNode parent = findParent(node0, node.val);
            if (parent!=null) {
                map.put("root", node0);
                map.put("tomerge", node);
                map.put("parent", parent);
                break;
            }
        }
        return map;
    }
    public TreeNode findParent(TreeNode root, int target) {
        if (root==null) {
            return null;
        }
        if (root.left!=null&&root.left.val==target) {
            return root;
        }
        if (root.right!=null&&root.right.val==target) {
            return root;
        }
        if (root.val>target) {
            return findParent(root.left, target);
        }
        if (root.val<target) {
            return findParent(root.right, target);
        }
        return null;
    }
    public boolean isBst(TreeNode root, TreeNode min, TreeNode max) {
        if (root==null) {
            return true;
        }
        if (min!=null&&root.val<=min.val) return false;
        if (max!=null&&root.val>=max.val) return false;
        return isBst(root.left, min, root)&&isBst(root.right, root, max);
    }



}
