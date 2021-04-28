package MyInterface;

import implementation.Node;

public interface BSTADT {
    void insert(int Data);
    boolean isEmpty();
    void preorder(Node node);
    void inorder(Node node);
    void postorder(Node node);
    boolean search(int Data);
    void delete(int Data);
    int getRootData();
}
