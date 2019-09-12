package hans.leetcode.medium;

import org.junit.Test;

public class MaxArea {
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     *
     *
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     *  
     *
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int area = 0;
        int w = 0;
        int h = 0;
        for (int index=0; index<height.length-1; index++) {
            for (int i=index+1; i<height.length; i++) {
                h = height[index]>height[i] ? height[i] : height[index];
                w = i-index;
                area = area<(w*h)?(w*h):area;
            }
        }
        return area;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
