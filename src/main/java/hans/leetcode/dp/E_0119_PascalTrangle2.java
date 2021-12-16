package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E_0119_PascalTrangle2 {
    @Test
    public void test() {
        List<Integer> num = getRow(1);
        Logger.log(num);
    }

    /**
     *
     Runtime:1 ms, faster than 78.75% of Java online submissions.
     Memory Usage:36.1 MB, less than 53.62% of Java online submissions.
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        if (rowIndex==0) {
            return list;
        }
        List<Integer> preSubList = list;
        for (int i=1; i<=rowIndex+1; i++) {
            List<Integer> subList = new ArrayList<>(i);
            for (int j=0; j<i; j++) {
                int num = 1;
                if ((j!=0)&&j!=(i-1)) {
                    num = preSubList.get(j)+preSubList.get(j-1);
                }
                subList.add(num);
            }
            preSubList = subList;
        }
        return preSubList;
    }

}
