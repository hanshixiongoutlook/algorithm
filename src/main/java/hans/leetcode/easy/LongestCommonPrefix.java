package hans.leetcode.easy;

import org.junit.Test;

public class LongestCommonPrefix {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs==null||strs.length==0 || strs[0].isEmpty()) return "";

        int index = 0;
        String preStr = "";
        String tryStr = strs[0].charAt(0) +"";
        for (int i=0; i<strs[0].length(); i++) {
            boolean isOk = true;
            for (int j=0; j<=strs.length/2; j++) {
                if (!strs[j].startsWith(tryStr) || !strs[strs.length-1-j].startsWith(tryStr)) {
                    isOk = false;
                }
            }
            if (!isOk) {
                break;
            }
            preStr=tryStr;
            if (i+1<strs[0].length())
                tryStr+=strs[0].charAt(i+1);
        }
        return preStr;
    }
    @Test
    public void test() {
        String[] strs = new String[]{"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix(strs));
    }
}
