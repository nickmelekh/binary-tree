import java.util.Stack;

public class Tree {
    // корневой узел
    private Node rootNode;
    private int nodeNumber;

    public Tree(int size) {
        rootNode = null;
        nodeNumber = size;
    }

    public void insertNode(double value) {
        // создание новой ноды и запись значения
        Node newNode = new Node();
        newNode.setValue(value);

        if (rootNode == null) {
            rootNode = newNode;
        }
        else {
            Node currentNode = rootNode;
            Node parentNode = new Node();
            while (true) {
                parentNode = currentNode;
                // если такой элемент в дереве уже есть, он игнорируется
                if (value == currentNode.getValue()) {
                    return;
                }
                // иначе задаем левого или правого соседа
                else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void printTree() {
        Stack outerStack = new Stack();
        outerStack.push(rootNode);
        int gaps = nodeNumber * 2;
        boolean isEmpty = false;

        while (isEmpty == false) {
            Stack innerStack = new Stack();
            isEmpty = true;

            for (int i = 0; i < gaps; i++) {
                System.out.print(' ');
            }
            while (outerStack.isEmpty() == false) {
                Node temp = (Node) outerStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    innerStack.push(temp.getLeftChild());
                    innerStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isEmpty = false;
                    }
                }
                else {
                    System.out.print("-");
                    innerStack.push(null);
                    innerStack.push(null);
                }

                for (int i = 0; i < gaps * 2; i++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            gaps /= 2;
            while (innerStack.isEmpty() == false) {
                outerStack.push(innerStack.pop());
            }
        }
    }

    public Node findByValue(double value) {
        Node curNode = rootNode;
        while (curNode.getValue() != value) {
            if (value < curNode.getValue()) {
                curNode = curNode.getLeftChild();
            }
            else {
                curNode = curNode.getRightChild();
            }

            if (curNode == null) {
                return null;
            }
        }
        return curNode;
    }

    public Node getParentNode(Node childNode) {
        Node curNode = rootNode;
        Node parentNode = curNode;

        while (curNode != childNode) {
            parentNode = curNode;
            if (curNode.getLeftChild() != null) {
                if (childNode.getValue() < curNode.getValue()) {
                    curNode = curNode.getLeftChild();
                } else {
                    curNode = curNode.getRightChild();
                }
            }
        }
        return parentNode;
    }
}
