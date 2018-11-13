package trees;

public class LargestBstinBinaryTree {
	
	public static void main(String[] args) {
		
		  Node root = new Node(60); 
		    root.left = new Node(55); 
		    root.right = new Node(70); 
		    root.left.left = new Node(50); 
		    
		    System.out.println(new LargestBstinBinaryTree().largestBstSize(root));
	}
	
	public int largestBstSize(Node root) {
		int size =  findLargestBst(root).getTotalSize();
		System.out.println("size "+size);
		return size;
	}
	
	public LargestBst findLargestBst(Node root) {
		
		
		if(root == null) {
			return new LargestBst().setIsBst(true).setMin(Integer.MIN_VALUE)
					.setMax(Integer.MAX_VALUE).setTotalSize(0).setNode(root);
		}
		
		if(root.left == null && root.right == null) {
			return new LargestBst().setIsBst(true).setMin(root.val)
					.setMax(root.val).setTotalSize(1).setNode(root);
		}
		
		LargestBst left = findLargestBst(root.left);
		LargestBst right = findLargestBst(root.right);
		
		int totalSize = left.totalSize + right.totalSize + 1;
		
		if(left.isBst && right.isBst && left.max < root.val && root.val < right.min) {
			
			return  new LargestBst().setIsBst(true).setMin(Math.min(left.min, Math.min(right.min, root.val)))
					.setMax(Math.min(left.max, Math.min(right.max, root.val)))
					.setTotalSize(totalSize).setNode(root).setSubTreeSize(totalSize);
		}
		
		return new LargestBst().setIsBst(false).setTotalSize(Math.max(left.totalSize,right.totalSize));
		
	}
	
	
	private static class LargestBst{
		
		boolean isBst;
		int min;
		int max;
		int totalSize;
		Node node;
		int subTreeSize;
		
		public LargestBst setIsBst(boolean isBst) {
			this.isBst = isBst;
			return this;
		}
		
		public LargestBst setMin(int min) {
			this.min = min;
			return this;
		}
		
		public LargestBst setMax(int max) {
			this.max = max;
			return this;
		}
		
		public LargestBst setNode(Node node) {
			this.node = node;
			return this;
		}
		public LargestBst setTotalSize(int totalSize) {
			this.totalSize = totalSize;
			return this;
		}
		
		public LargestBst setSubTreeSize(int subTreeSize) {
			this.subTreeSize = subTreeSize;
			return this;
		}
		public boolean isBst() {
			return isBst;
		}
		
		public int getMax() {
			return max;
		}
		
		public int getMin() {
			return min;
		}
		
		
		public Node getNode() {
			return node;
		}
		public int getTotalSize() {
			return totalSize;
		}
		
		public int getSubTreeSize() {
			return subTreeSize;
		}
	}

}
