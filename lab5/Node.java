package lab5;

class Node<T> {
    T data;
    Node<T> leftNode;
    Node<T> rightNode;
    int height;

    public Node(T data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
        this.height = 0;
    }
	public T getData() { return data; }
	public void setData(T data) { this.data = data; }
	public Node<T> getLeftNode() { return leftNode; }
	public void setLeftNode(Node<T> leftNode) { this.leftNode = leftNode; }
	public Node<T> getRightNode() { return rightNode; }
	public void setRightNode(Node<T> rightNode) { this.rightNode = rightNode; }
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	@Override 
	public String toString() {
		 return data + "," + height + "  ";
    }
}

