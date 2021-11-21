package hans.common.pojo;

/**
 * 单链表节点
 */
public class SingleLinkNode<T> {
    
    public T value;
    public SingleLinkNode next;
    public SingleLinkNode(T value, SingleLinkNode next) {
        this.value = value;
        this.next = next;
    }

    
}
