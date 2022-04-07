package hans.leetcode.tree;


import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;

/**
 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。

 返回到目标结点 target 距离为 k 的所有结点的值的列表。 答案可以以 任何顺序 返回。






 示例 1：




 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 输出：[7,4,1]
 解释：所求结点为与目标结点（值为 5）距离为 2 的结点，值分别为 7，4，以及 1


 示例 2:


 输入: root = [1], target = 1, k = 3
 输出: []




 提示:


 节点数在 [1, 500] 范围内
 0 <= Node.val <= 500
 Node.val 中所有值 不同
 目标结点 target 是树上的结点。
 0 <= k <= 1000



 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 513 👎 0

 */
public class M_0863_AllNodesDistanceKinBinaryTree {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6,7,8,9,10,null,null,null,null,null,11,12});
        treeNode.prettyPrint();
        Logger.log(distanceK(treeNode, new TreeNode(4), 2));

    }
    List<Integer> list = new LinkedList<>();

    /**
     * 			Runtime:8 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:41 MB, less than 71.25% of Java online submissions.
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
        /*
                                   1
                                  / \
                                 /   \
                                /     \
                               /       \
                              /         \
                             /           \
                            /             \
                           /               \
                          /                 \
                         /                   \
                        /                     \
                       2                       3
                      / \                     / \
                     /   \                   /   \
                    /     \                 /     \
                   /       \               /       \
                  /         \             /         \
                 4           5           6           7
                / \         /
               /   \       /
              8     9    10
             / \
            11 12
            tree: [1,2,3,4,5,6,7,8,9,10,null,null,null,null,null,11,12]
            input: 2  3
            output: [11,12,6,7]

            直接看例子
            对于节点2，与它相距3的节点可以有两个方向
            方向1：自己的子树
            方向2：自己的父节点及父节点的子树（不能包含2所在的子树）

            寻找目标节点
            方向1，直接找到以2为根的子树然后遍历，找到所有深度为3的子节点即可
            方向2，此时将基准从2切换到了其父节点1，也就是以节点1为基准需要寻找距离其3-1=2的子节点，此时发现了最小子问题
            但是这里需要将以2为根的子树排除掉

            方向1实现：参考dfs方法
         */
        if (root==null) {
            return;
        }
        // 这里先遍历原始树，先找到基准节点
        if (root.val==target.val) {
            // 找到以后，先朝着方向1，把所有满足的节点找到
            dfs(root, k, 0);
            // 然后开始找方向2
            // 这里需要判断下，如果基准节点刚好是树的根节点，即parent为null，就不用找方向2 了
            if (parent!=null) {
                // 为了排除基准节点的干扰，需要将该节点所在子树摘除
                if (parent.left==root) {
                    parent.left=null;
                } else {
                    parent.right=null;
                }
                // 重新开始寻找过程，只是此时基准节点变成了父节点，距离也需要-1
                distanceK(vroot, parent, k-1);
            }
            return;
        }
        distanceK(root.left, target, root, k);
        distanceK(root.right, target, root, k);
    }

    /**
     *
     * @param root
     * @param k 目标距离
     * @param depth 实际距离
     */
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
}
