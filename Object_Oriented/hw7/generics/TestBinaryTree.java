package generics ;

public class TestBinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode<String> root = new BinaryTreeNodeImpl<String>();
		root.setValue("abc");

		BinaryTreeNode<String> left = new BinaryTreeNodeImpl<String>("xyz");
		root.setLeft(left);
		
		System.out.println(root.getValue());
		//Output: abc
		System.out.println(root.getLeft().getValue());
		//Output: xyz

		

		BinaryTreeNode<Integer> rootInt = new BinaryTreeNodeImpl<Integer>(7);

		BinaryTreeNode<Integer> node = new BinaryTreeNodeImpl<Integer>(5);
		rootInt.setLeft(node);
		
		node = new BinaryTreeNodeImpl<Integer>(11);
		rootInt.setRight(node);
		
		rootInt.getLeft().setLeft(new BinaryTreeNodeImpl<Integer>(3)); 
		rootInt.getLeft().setRight(new BinaryTreeNodeImpl<Integer>(6)); 

		rootInt.getRight().setLeft(new BinaryTreeNodeImpl<Integer>(2)); 
		rootInt.getRight().setRight(new BinaryTreeNodeImpl<Integer>(9)); 
		rootInt.getRight().getRight().setRight(new BinaryTreeNodeImpl<Integer>(5)); 
		
		System.out.println(sum(rootInt));
		//Output: 48
	}

	/**
	 * A recursive function calculating the total of values in a Binary tree
	 * @param root
	 * @return
	 */
	public static int sum(BinaryTreeNode<Integer> root){
		if (root == null){
			return 0;
		}
		return root.getValue() + sum(root.getLeft()) + sum(root.getRight());
	}
	
}