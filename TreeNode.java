public class TreeNode<E> {

	private E myData;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode(E data) {
		myData = data;
		left = null;
		right = null;
	}
	
	public E getData() {
		return myData;
	}
	
	public TreeNode<E> getLeft(){
		return left;
	}
	
	public TreeNode<E> getRight(){
		return right;
	}
	
	public void setLeft(TreeNode<E> theleft) {
		left = theleft;
	}
	
	public void setRight(TreeNode<E> theright) {
		right = theright;
	}
}
