package hans.leetcode.dp.typical.bit;

import hans.common.utils.Logger;
import org.junit.Test;


public class E_LCCI0503_ReverseBits {
    @Test
    public void test() {
        int n = 1<<3;
        Logger.log(n);
        int num = reverseBits(1);
        Logger.log(num);
    }

    /**
     * TODO 位运算
     * @param num
     * @return
     */
    public int reverseBits(int num) {
        int cur = 0;
        int insert = 0;
        int res = 1;
        for(int i = 0; i < 32; i++){
            if((num & (1 << i)) != 0){
                cur += 1;
                insert += 1;
            }else{
                insert = cur + 1;
                cur = 0;
            }
            res = Math.max(res , insert);
        }
        return res;
    }

}
