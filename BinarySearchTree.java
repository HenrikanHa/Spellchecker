public class BinarySearchTree<E extends Comparable<E>> {

	private TreeNode<E> root;
	private int size = 0;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(E data) {
		TreeNode<E> toAdd = new TreeNode<E>(data);
		root = add(root, toAdd);
	}
	
	private TreeNode<E> add(TreeNode<E> currentRoot, TreeNode<E> toAdd){
		if(currentRoot == null) {
			size++;
			return toAdd;
		}
		int c = currentRoot.getData().compareTo(toAdd.getData());
		if(c < 0) {
			currentRoot.setRight(add(currentRoot.getRight(), toAdd));
		}else if (c > 0){
			currentRoot.setLeft(add(currentRoot.getLeft(), toAdd));
		}
		return currentRoot;	
	}
	
	public E search(E findMe) {
		return search(root, findMe);
	}
	
	private E search(TreeNode<E> currentRoot, E findMe) {
		if(currentRoot == null) {
			return null;
		}// object not in tree
		if(findMe.equals(currentRoot.getData())) {
			return currentRoot.getData();
		}// found the object
		if(findMe.compareTo(currentRoot.getData()) < 0) {
			return search(currentRoot.getLeft(), findMe);
		}
		return search(currentRoot.getRight(), findMe);
	}	
	
}