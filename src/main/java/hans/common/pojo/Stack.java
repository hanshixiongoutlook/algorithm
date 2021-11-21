package hans.common.pojo;

public class Stack<T> {

	public SingleLinkNode<T> node;

	public void push(T value) {
		if (node==null) {
//			System.out.println("push :"+((TreeNode)value).value);
			node = new SingleLinkNode(value, null);
			return;
		}
//		System.out.println("push :"+((TreeNode)value).value);
		node = new SingleLinkNode(value, node);
	}

	public T pop() {
		if (node==null) {
			return null;
		}
		T v = node.value;
		node = node.next;
//		System.out.println("pop :" + ((TreeNode)v).value);
		return v;
	}
	public boolean isEmpty() {
		return node==null;
	}
}
