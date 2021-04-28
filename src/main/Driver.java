/*   Created by IntelliJ IDEA.
 *   Author: Priyanshi Jaiswal
 *   Date: 25-04-2021
 *   Time: 16:43
 *   File: Driver.java
 */

package main;

import implementation.BSTImplementation;

public class Driver {
    public static void main(String[] args) {
        BSTImplementation bst=new BSTImplementation();
        bst.insert(10);
        bst.insert(20);
        bst.insert(120);
        bst.insert(110);
        bst.insert(21);
        bst.insert(9);
        bst.insert(4);
        bst.insert(3);
        bst.insert(1);
        bst.preorder(bst.getRoot());
        System.out.println();
        bst.inorder(bst.getRoot());
        System.out.println();
        bst.postorder(bst.getRoot());
        System.out.println();
        bst.reverseInorder(bst.getRoot());
        System.out.println();
        System.out.println(bst.isEmpty());
        bst.delete(10);
        bst.delete(111);
        bst.deleteAll();
        System.out.println(bst.isEmpty());

    }
}
