package hans.leetcode.dp;

import hans.common.utils.Logger;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class E_LCCI0503_ReverseBits {
    @Test
    public void test() {
        int num = reverseBits(-1);
        Logger.log(num);
    }

    public int reverseBits(int num) {
        if (num==0) {
            return 1;
        }
        Integer[] integers = convertBitCounter(num);
        if (integers.length==1) {
            return integers[0]+1;
        }
        int max = 0;
        int count = 0;
        for (int i=0; i<integers.length; i++) {
            if (integers[i]<0) {
                if (integers[i]==-1) {
                    count = ((i-1)>=0?integers[i-1]:0)+((i+1)<integers.length?integers[i+1]:0) + 1;
                } else if (integers[i]<-1) {
                    count = Math.max((i-1)>=0?integers[i-1]:0,(i+1)<integers.length?integers[i+1]:0)+1;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public Integer[] convertBitCounter(int num) {

        List<Integer> list = new LinkedList<>();
        int zeroCounter = 0;
        int oneCounter = 0;
        while(num>0) {
            if (num%2==0) {
                zeroCounter--;
                if (oneCounter!=0) {
                    list.add(oneCounter);
                }
                oneCounter=0;
            } else {
                oneCounter++;
                if (zeroCounter!=0) {
                    list.add(zeroCounter);
                }
                zeroCounter=0;
            }
            num=num/2;
        }
        if (zeroCounter!=0) {
            list.add(zeroCounter);
        }
        if (oneCounter!=0) {
            list.add(oneCounter);
        }
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        return arr;
    }

}
