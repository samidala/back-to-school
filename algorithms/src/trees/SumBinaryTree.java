package trees;

public class SumBinaryTree {
	
	public static int sumBinTree(Node root) {
		
		
		if(root == null) {
			return 0;
		}
		int oldVal = root.val;
		int sumLeft = sumBinTree(root.left);
		int sumRight = sumBinTree(root.right);
		root.val = sumLeft + sumRight;
		
		return root.val + oldVal;
		
	}
	
	public static void main(String[] args) {
		 
			BinarySearchTree tree = new BinarySearchTree();
		   
	        /* Constructing tree given in the above figure */
	        tree.root = new Node(10); 
	        tree.root.left = new Node(-2); 
	        tree.root.right = new Node(6); 
	        tree.root.left.left = new Node(8); 
	        tree.root.left.right = new Node(-4); 
	        tree.root.right.left = new Node(7); 
	        tree.root.right.right = new Node(5);
	        sumBinTree(tree.root);
	        inorder(tree.root);
	        
	}
	
	public static void inorder(Node root) {
		if(root != null) {
			
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

}
