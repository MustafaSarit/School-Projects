package generics ;

public class BinaryTreeNodeImpl<T> implements BinaryTreeNode<T> {
	
	private T value  ;
	private BinaryTreeNode lvalue  ;
	private BinaryTreeNode rvalue  ;

	public BinaryTreeNodeImpl(T value) {
		this.value = value ; 
	}	
	
	public BinaryTreeNodeImpl() {
		
	}
	
	public void setValue(T value) {
		this.value = value ;
	}
	
	public void setLeft(BinaryTreeNode<T> lvalue) {
		this.lvalue = lvalue ;
	}

	public void setRight(BinaryTreeNode<T> rvalue) {
		this.rvalue = rvalue ;
	}

	public T getValue() {
		return this.value ;
	}

	public BinaryTreeNode getRight() {
		return rvalue ;
	}

	public BinaryTreeNode getLeft() {
		return lvalue ;
	}
}