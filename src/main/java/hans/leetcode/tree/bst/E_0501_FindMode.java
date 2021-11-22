package hans.leetcode.tree.bst;


import com.alibaba.fastjson.JSONObject;
import hans.common.pojo.TreeNode;
import hans.common.utils.Logger;
import org.junit.Test;

import java.util.*;


public class E_0501_FindMode {

    @Test
    public void test() {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,null,2,null,null,2});
        treeNode.prettyPrint();
        int[] mode = this.findMode(treeNode);
        Logger.log(JSONObject.toJSONString(mode)+":"+max);
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max=0;
    public int[] findMode(TreeNode root) {
        if (root==null) {
            return null;
        }
        this.traversal(root);
        List<Integer> list = new ArrayList<>();
        map.forEach((v,c)->{
            if (c==max) {
                list.add(v);
            }
        });
        int[] arr = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void traversal(TreeNode root) {
        if (root==null) {
            return;
        }
        Integer count = map.get(root.val);
        count = count==null?1:++count;
        if (count>max) {
            max = count;
        }
        map.put(root.val, count);
        findMode(root.left);
        findMode(root.right);
    }

}
