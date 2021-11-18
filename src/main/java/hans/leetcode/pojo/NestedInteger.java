package hans.leetcode.pojo;

import hans.leetcode.tree.binary.serialize.Medium0341_Flatten_Nested_List_Iterator;

import java.util.List;

public class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    public NestedInteger() {
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    public NestedInteger(Integer value) {
        this.value = value;
    }

    public NestedInteger(Integer value, List<NestedInteger> list) {
        this.value = value;
        this.list = list;
    }

    public boolean isInteger() {
        return value!=null;
    }
    public Integer getInteger() {
        return value;
    }
    public List<NestedInteger> getList() {
        return list;
    }
}
