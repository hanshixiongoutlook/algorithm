package hans.leetcode.dp;

import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

/**
 给定一个二叉树，我们在树的节点上安装摄像头。

 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

 计算监控树的所有节点所需的最小摄像头数量。



 示例 1：



 输入：[0,0,null,0,0]
 输出：1
 解释：如图所示，一台摄像头足以监控所有节点。


 示例 2：



 输入：[0,0,null,0,null,0,null,null,0]
 输出：2
 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。



 提示：


 给定树的节点数的范围是 [1, 1000]。
 每个节点的值都是 0。

 Related Topics 树 深度优先搜索 动态规划 二叉树 👍 379 👎 0

 */
public class H_0968_MinCameraCover {
    @Test
    public void test() {
        // 1,2,3
        // 1,2,null,3,null,4,null,null,5
        // 0,0,null,0,0
        // 1,2,3,4,5,6,7,8,9
        // 0,0,null,null,0,0,null,null,0,0
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3});
        treeNode.prettyPrint();
        int i = minCameraCover(treeNode);
        Logger.log(i);
    }

    public int minCameraCover(TreeNode root) {
        /*
                         1 11-3,01-2,00-2
                        /
                       2   11-2,01-2,00-2
                        \
                        3  11-2,01-2,00-1
                        /
                       4   11-2,01-1,00-1
                        \
                         5 11-1,01-1,00-1
                        /
                       6   11-1,01-1,00-0

         一个节点有两种状态：安装-0、不安装-被父节点监控-1、不安装-被子节点监控-2
         安装：自身、父、子，均被监控
         不安装：则要求，父或子中有一个必须安装太能被监控

         因此
         // 安装，只需要取子的最小和即可
         f(n)[0] = 1+MIN(f(left)[0],f(left)[1],f(left)[2]) + MIN(f(right)[0]+f(right)[1],f(right)[2])
         // 不安装-被父监控，则子需要安装或者被孙监控
         f(n)[1] = min(f(left)[0]+f(right)[0], f(left)[0]+f(right)[2], f(left)[2]+f(right)[0], f(left)[2]+f(right)[2])
         // 不安装-被子节点监控，则至少有一个子安装，且不安装的子需要被孙监控
         f(n)[1] = min(f(left)[0]+f(right)[0], f(left)[0]+f(right)[2], f(left)[2]+f(right)[0])
         */
        int[] dfs = dfs(root);
        return Math.min(dfs[0], dfs[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root==null) {
            return null;
        }
        // 叶子
        if (root.left==null&&root.right==null) {
            return new int[]{1,1,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] dp = new int[3];
        dp[0] = 1
                + (left!=null?Math.min(Math.min(left[0],left[1]),left[2]):0)
                + (right!=null?Math.min(Math.min(right[0],right[1]),right[2]):0);
        if (left==null) {
            dp[1] = right[0];
        }
        if (right==null) {
            dp[1] = left[0];
        }
        if (left!=null&&right!=null) {
            dp[1] = Math.min(left[0]+right[1], right[0]+left[1]);
        }
        dp[2] = (left!=null?left[1]:0)+(right!=null?right[1]:0);
        return dp;
    }
}
