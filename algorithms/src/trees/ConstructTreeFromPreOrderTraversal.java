package trees;

import java.util.Stack;

public class ConstructTreeFromPreOrderTraversal {
	
	
	
	public Node construct(int[] a){
		
		Node root = new Node().setVal(a[0]);
		int n = a.length;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		for(int i=1;i<n;i++) {
			Node node = null;
			while(!stack.isEmpty() && a[i] > stack.peek().val) {
				node = stack.pop();
			}
			if(node != null) {
				node.right = new Node().setVal(a[i]);
				stack.push(node.right);
			}else {
				node = stack.peek();
				node.left = new Node().setVal(a[i]);
				stack.push(node.left);
			}
		}
		
		return root;
	}
	
	public void preOrder(Node root) {
		if(root == null) {return;}
		System.out.print(root.val+ " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String[] args) {
		int[] a = {10, 5, 1, 7, 40, 50};
		
		ConstructTreeFromPreOrderTraversal constructTreeFromPreOrderTraversal = new ConstructTreeFromPreOrderTraversal();
		Node root = constructTreeFromPreOrderTraversal.construct(a);
		constructTreeFromPreOrderTraversal.preOrder(root);
	}

}
