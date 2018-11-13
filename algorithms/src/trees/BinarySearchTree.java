package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearchTree {
	
	protected Node root;
	
	
	public Node insert(int val,Node node) {
		
		if(node == null) {
			node = new Node().setVal(val);
			return node;
					
		}
		if(val < node.val) {
			node.left =  insert(val, node.left);
		}else if(val > node.val) {
			node.right = insert(val, node.right);
		}
		return node;
	}
	
	
	public void delete(int val) {
		root = delete(root, val);
	}
	private Node delete(Node root, int val) {
		
		if(root == null) {
			return null;
		}
		if(val < root.val ) {
			root.left = delete(root.left, val);
		}else if(val > root.val ) {
			root.right = delete(root.right, val);
		}else {
			//found node
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			
			root.val = findMinValue(root.right);
			delete(root.right, root.val);
		}
		return root;
	}
	
	private int findMinValue(Node root) {
		int minVal = root.val;
		while(root.left != null) {
			minVal = root.left.val;
			root = root.left;
			
		}
		return minVal;
	}
	
	public void insert(int val) {
	
		
		root = insert(val, root);
		//System.out.println("root val "+ root.val);
	}
	
	
	public void inorder(Node root) {
		if(root!= null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<10;i++) {
			int val = random.nextInt(100);
			System.out.println("val "+val);
			binarySearchTree.insert(val);
			list.add(val);
			
		}
		binarySearchTree.inorder(binarySearchTree.root);
		System.out.println();
		for(int val : list) {
			System.out.println("del "+val);
			binarySearchTree.delete(val);
		}
		System.out.println("\n after dle " + binarySearchTree.root);
		binarySearchTree.inorder(binarySearchTree.root);
	}
}
