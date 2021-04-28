/*   Created by IntelliJ IDEA.
 *   Author: Priyanshi Jaiswal
 *   Date: 25-04-2021
 *   Time: 16:42
 *   File: BSTImplementation.java
 */

package implementation;

import MyInterface.BSTADT;

public class BSTImplementation implements BSTADT {
    Node root;

    public BSTImplementation() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }


    @Override
    public void insert(int Data) {
        Node node = new Node(Data);

        if (isEmpty()) {
            root = node;
        } else {
            Node temp = root;
            Node parent = null;

            while (temp != null) {
                parent = temp;

                if (Data <= temp.getData()) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }

            if (Data < parent.getData()) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return getRoot() == null;
    }

    @Override
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.getData() + ", ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    @Override
    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getData() + ", ");
        inorder(node.getRight());
    }

    @Override
    public void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getData() + ", ");
    }

    public void reverseInorder(Node node) {
        if (node != null) {
            reverseInorder(node.getRight());
            System.out.print(node.getData() + ", ");
            reverseInorder(node.getLeft());
        }
    }

    @Override
    public boolean search(int Data) {
        boolean response = false;
        Node temp = root;

        while (temp != null) {
            if (Data == temp.getData()) {
                response = true;
                break;
            } else if (Data < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return response;
    }

    @Override
    public void delete(int data) {
        Node temp = root;
        Node parent = null;

        //Searching
        while (temp != null) {
            if (data == temp.getData()) {
                break;
            } else {
                parent = temp;
                if (data < temp.getData()) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        //deleting value is present in BST
        if (temp != null) {
            // Case 1 : If the value is leaf node
            if (isLeaf(temp)) {
                //if deleting node is root node
                if (parent == null) {
                    temp = null;
                } else {
                    if (data < parent.getData()) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }
            }
            // Case 2 : Has 2 parts
            // case 2A : has left child
            else if (hasLeftChild(temp)) {
                // Root condition
                if (parent == null) {
                    root = root.getLeft();
                } else {
                    if (data < temp.getData()) {
                        parent.setLeft(temp.getLeft());
                    } else {
                        parent.setRight(temp.getLeft());
                    }
                }
                //case 2B : has right child
            } else if (hasRightChild(temp)) {
                // Root condition
                if (parent == null) {
                    root = root.getRight();
                } else {
                    if (data < temp.getData()) {
                        parent.setLeft(temp.getRight());
                    } else {
                        parent.setRight(temp.getRight());
                    }
                }
            }
            // Case 3 :
            else {
                Node successor = getSuccessor(temp);
                // Root Condition
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                if (parent == null) {
                    root = successor;
                } else {
                    if (data < parent.getData()) {
                        parent.setLeft(successor);
                    } else {
                        parent.setRight(successor);
                    }
                }
            }
        }
        else{
            System.out.println("deleting element is not present!");
        }
    }

    private boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    @Override
    public int getRootData() {
        if (getRoot() != null) {
            return root.getData();
        }
        return -1;
    }

    private boolean hasLeftChild(Node node) {
        return node.getLeft() != null && node.getRight() == null;
    }

    private boolean hasRightChild(Node node) {
        return node.getRight() != null && node.getLeft() == null;
    }

    private Node getSuccessor(Node node) {
        Node temp = node.getRight();
        while ((temp.getLeft() != null)) {
            temp = temp.getLeft();
        }
        return temp;
    }
    public void deleteAll(){
        root=null;
    }
}
