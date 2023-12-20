package lab5;

public class ArbolAvl<T extends Comparable<T>> {
    private Node<T> root;

    public ArbolAvl() {
        this.root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            node.leftNode = insert(node.leftNode, data);
        } else if (compareResult > 0) {
            node.rightNode = insert(node.rightNode, data);
        } else {
            return node;
        }

        updateHeight(node);
        return balance(node);
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        int compareResult = data.compareTo(node.data);

        if (compareResult < 0) {
            node.leftNode = delete(node.leftNode, data);
        } else if (compareResult > 0) {
            node.rightNode = delete(node.rightNode, data);
        } else {
            if (node.leftNode == null || node.rightNode == null) {
                node = (node.leftNode != null) ? node.leftNode : node.rightNode;
            } else {
                Node<T> successor = findMin(node.rightNode);
                node.data = successor.data;
                node.rightNode = delete(node.rightNode, successor.data);
            }
        }
        updateHeight(node);
        return balance(node);
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        }
        
        int compareResult = data.compareTo(node.data);

        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return search(node.leftNode, data);
        } else {
            return search(node.rightNode, data);
        }
    }

    private Node<T> findMin(Node<T> node) {
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }

    private int height(Node<T> node) {
        return (node != null) ? node.height : 0;
    }

    private void updateHeight(Node<T> node) {
        if (node != null) {
            node.height = Math.max(height(node.leftNode), height(node.rightNode)) + 1;
        }
    }

    private int balanceFactor(Node<T> node) {
        if (node != null) {
            return height(node.leftNode) - height(node.rightNode);
        }
        return 0;
    }

    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.leftNode;
        Node<T> T2 = x.rightNode;

        x.rightNode = y;
        y.leftNode = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.rightNode;
        Node<T> T2 = y.leftNode;

        y.leftNode = x;
        x.rightNode = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private Node<T> balance(Node<T> node) {
        updateHeight(node);
        int balance = balanceFactor(node);
        if (balance > 1) {
            if (balanceFactor(node.leftNode) < 0) {
                node.leftNode = rotateLeft(node.leftNode);
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balanceFactor(node.rightNode) > 0) {
                node.rightNode = rotateRight(node.rightNode);
            }
            return rotateLeft(node);
        }
        return node;
    }
    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node<T> node) {
        if (node == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        result.append(toString(node.leftNode));
        result.append(node.toString());
        result.append(toString(node.rightNode));

        return result.toString();
    }
}
