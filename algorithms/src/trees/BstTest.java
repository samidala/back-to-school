package trees;

public class BstTest {

	Node root;
	public boolean isBst(Node root) {
		
		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isBst(Node root, int min,int max) {
		
		if(root == null) {
			return true;
		}
		
		if(root.val < min || root.val > max) {
			return false;
		}
		
		return isBst(root.left,min,  root.val) && isBst(root.right,  root.val,max);
	}
	
	public boolean isBstInorder(Node root) {
		return isBstInorder(root,null);
	}
	
	private boolean isBstInorder(Node root, Node prev) {
		
		if(root == null) {
			return true;
		}
		
		
		if(!isBstInorder(root.left, prev)) {
			return false;
		}
		
		if(prev != null && prev.val > root.val) {
			return false;
		}
		
		prev = root;
		return isBstInorder(root.right, prev);
	}
	
	public static void main(String[] args) {
			BstTest tree = new BstTest(); 
	        tree.root = new Node(4); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(5); 
	        tree.root.left.left = new Node(1); 
	        tree.root.left.right = new Node(3); 
	        
	        System.out.println("isBst "+tree.isBst(tree.root));
	        System.out.println("using inorder: isBst "+ tree.isBstInorder(tree.root));
	  
	}
}
