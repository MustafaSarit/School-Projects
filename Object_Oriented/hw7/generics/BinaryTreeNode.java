package generics ;

public interface BinaryTreeNode<T> {
	
	public void setValue(T value) ;
	
	public void setLeft(BinaryTreeNode<T> lvalue) ;

	public void setRight(BinaryTreeNode<T> rvalue) ;

	public T getValue() ;

	public BinaryTreeNode getRight() ;

	public BinaryTreeNode getLeft() ;

	
}