package trees;

public class Node {

	int val;
	Node left;
	Node right;
	public Node() {
		
	}
	public Node(int val) {
		this.val = val;
	}
	public Node setVal(int val) {
		this.val = val;
		return this;
	}
}
