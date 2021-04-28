/*   Created by IntelliJ IDEA.
 *   Author: Priyanshi Jaiswal
 *   Date: 25-04-2021
 *   Time: 16:46
 *   File: Node.java
 */

package implementation;

import MyInterface.NodeADT;

public class Node implements NodeADT {
    private Node Left;
    private Node Right;
    private int data;

    public Node(int data) {
        this.data = data;
    }
    @Override
    public int getData() {
        return data;
    }
    @Override
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public Node getLeft() {
        return Left;
    }

    @Override
    public void setLeft(Node left) {
        Left = left;
    }

    @Override
    public Node getRight() {
        return Right;
    }

    @Override
    public void setRight(Node right) {
        Right = right;
    }
}
