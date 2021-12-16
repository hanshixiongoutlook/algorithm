package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class E_0118_PascalTrangle {
    @Test
    public void test() {
        List<List<Integer>> num = generate(8);
        for (List<Integer> l: num) {
            Logger.log(l);
        }
    }

    /**
     * 			Runtime:0 ms, faster than 100.00% of Java online submissions.
     * 			Memory Usage:36.2 MB, less than 54.10% of Java online submissions.
     *
     * max_n=l-1;
     * f(l)(0) = 1
     * f(l)(max_n) = 1;
     * f(l)(n) = f(l-1)(n) + f(l-1)(n-1)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        if (numRows==0) {
            return list;
        }
        List<Integer> l1List = new ArrayList<>();
        l1List.add(1);
        list.add(l1List);
        if (numRows==1) {
            return list;
        }
        List<Integer> preSubList = l1List;
        for (int i=2; i<=numRows; i++) {
            List<Integer> subList = new ArrayList<>(i);
            for (int j=0; j<i; j++) {
                int num = 1;
                if ((j!=0)&&j!=(i-1)) {
                    num = preSubList.get(j)+preSubList.get(j-1);
                }
                subList.add(num);
            }
            preSubList = subList;
            list.add(subList);
        }
        return list;
    }

}
