package hans.leetcode.tree;


import hans.common.utils.Logger;
import org.junit.Test;

/**
 Runtime:1 ms, faster than 83.25% of Java online submissions.
 Memory Usage:36.7 MB, less than 97.59% of Java online submissions.
 */
public class M_Offer33_VerifyPostorder {

    @Test
    public void test() {
        // 9,3,4,#,#,1,#,#,2,#,6,#,#  true
        // 9,#,#,1 false
        int[] postorder = new int[]{1,6,3,2,5};
        Logger.log(verifyPostorder(postorder));

    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length==0) {
            return false;
        }
        return verifyPostorder(postorder, 0, postorder.length-1);
    }
    public boolean verifyPostorder(int[] postorder, int sidx, int eidx) {
        if (sidx>=eidx) {
            return true;
        }
        int root = postorder[eidx];
        int lendidx=sidx-1;
        for (int i=eidx-1; i>=sidx; i--) {
            if (postorder[i]<root) {
                lendidx = i;
                break;
            }
        }
        boolean check = check(postorder, root, sidx, lendidx, lendidx + 1, eidx - 1);
        if (!check) {
            return false;
        }
        return verifyPostorder(postorder, sidx, lendidx)&&verifyPostorder(postorder, lendidx+1, eidx-1);
    }
    public boolean check(int[] postorder, int root, int lsidx, int leidx, int rsidx, int reidx) {
        // 左子树需要全部小于根
        for (int i=lsidx; i<leidx; i++) {
            if (postorder[i]>=root) {
                return false;
            }
        }
        // 右子树需要全部大于根
        for (int i=rsidx; i<reidx; i++) {
            if (postorder[i]<=root) {
                return false;
            }
        }
        return true;
    }

}
