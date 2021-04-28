/*   Created by IntelliJ IDEA.
 *   Author: Priyanshi Jaiswal
 *   Date: 25-04-2021
 *   Time: 16:48
 *   File: NodeADT.java
 */

package MyInterface;

import implementation.Node;

public interface NodeADT {
    int getData();
    void setData(int data);
    Node getLeft();
    void setLeft(Node left);
    Node getRight();
    void setRight(Node right);
}
