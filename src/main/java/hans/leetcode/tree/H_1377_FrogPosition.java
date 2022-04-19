package hans.leetcode.tree;

import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 * <p>
 * <p>
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * <p>
 * <p>
 * 无向树的边用数组 edges 描述，其中 edges[i] = [fromi, toi] 意味着存在一条直接连通 fromi 和 toi 两个顶点的边。
 * <p>
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙在
 * 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * 输出：0.3333333333333333
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 100
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * 1 <= t <= 50
 * 1 <= target <= n
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 图 👍 41 👎 0
 */
public class H_1377_FrogPosition {
    @Test
    public void test() {
        /*
        输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
        输出：0.3333333333333333
         */
        int[][] res = new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 7},
                new int[]{2, 4},
                new int[]{2, 6},
                new int[]{3, 5},
        };
        double t1 = frogPosition(7,res,2, 4);
        Assert.assertEquals(0.167, t1, 3);
        double t2 = frogPosition(7,res,1, 7);
        Assert.assertEquals(0.333, t2, 3);
        Logger.log(frogPosition(3,
                new int[][]{
                        new int[]{3, 1},
                        new int[]{2, 1},
                },
                3, 2));

    }

    /*
    			Runtime:9 ms, faster than 40.54% of Java online submissions.
			Memory Usage:41.7 MB, less than 21.62% of Java online submissions.
     */
    public double frogPosition(int n, int[][] edges, int t, int target) {
        /*
        基本情况edges为空，始终返回1

        基本条件分解：
        1.走过的位置不能返回
        2.起始位置为1
        3.剩余步数为0时不能继续走

        开始罗列判断基本情况
        1.root=target，当前节点值=目标值
            t=0，即步数用尽刚好找到目标值，此时概率为1
            t>0 && edges.isEmpty()，即步数未用尽，但是没有后继，青蛙只能原地踏步，最后仍在目标位置，概率也是1
            t>0 && !edges.isEmpty()，即步数未用尽，后继节存在，青蛙会跳到后继，由于不能再返回，因此青蛙永远不可能再跳回目标值，概率是0
        2.root!=target，当前节点值!=目标值
            t=0，跳到目标值概率为0
            edges.isEmpty()，没有后继了 ，跳到目标值概率为0
         */
        // 基本情况edges为空，始终返回1
        if (edges.length==0) return 1.0;
        // 因为走过的位置不能返回，因此将组转成list，方便将走过的位置都删除避免重复走
        List<Integer[]> list = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            Integer[] sub = new Integer[]{edges[i][0], edges[i][1]};
            list.add(sub);
        }
        // 开始递归求解
        return dfs(1, list, t, target);
    }

    /**
     *
     * @param root 当前位置
     * @param edges 路线
     * @param t 剩余步数
     * @param target 目标值
     * @return
     */
    public double dfs(int root, List<Integer[]> edges, int t, int target) {
        if (root==target && (t==0||edges.isEmpty())) return 1.0;
        if (edges.isEmpty() || t < 0) return 0.0;
        List<Integer> nextList = new LinkedList<>();
        for (int i = 0; i < edges.size(); i++) {
            Integer[] derict = edges.get(i);
            if (derict[0] == root) {
                nextList.add(edges.remove(i)[1]);
                i--;
            }
            if (derict[1]==root) {
                nextList.add(edges.remove(i)[0]);
                i--;
            }
        }
        if (nextList.isEmpty()) return (root == target)?1.0:0.0;
        if (root==target&&!nextList.isEmpty()) return 0.0;
        t--;
        double curProb = 1.0 / nextList.size();
        double prob = 0.0;
        for (Integer next : nextList) {
            prob = prob + curProb * dfs(next, edges, t, target);
        }
        return prob;
    }
}
