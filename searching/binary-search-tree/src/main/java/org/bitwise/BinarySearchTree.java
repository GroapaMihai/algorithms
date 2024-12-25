package org.bitwise;

import lombok.Getter;
import org.bitwise.model.Node;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BinarySearchTree {
    private Node root;

    public void insert(final int value) {
        if (root == null) {
            root = new Node(value, null, null);
        } else {
            insertRecursively(root, value);
        }
    }

    private void insertRecursively(Node node, final int value) {
        if (node.getValue() == value) {
            // value already exists in the BST
            return;
        }

        if (value < node.getValue()) {
            if (node.getLeft() == null) {
                // create Left children node
                node.setLeft(new Node(value, null, null));
            } else {
                // the new node should be added in the left subtree
                insertRecursively(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                // create Right children node
                node.setRight(new Node(value, null, null));
            } else {
                // the new node should be added in the right subtree
                insertRecursively(node.getRight(), value);
            }
        }
    }

    public boolean search(final int value) {
        return searchRecursively(root, value);
    }

    private boolean searchRecursively(final Node node, final int value) {
        if (node == null) {
            return false;
        }

        if (value == node.getValue()) {
            return true;
        } else if (value < node.getValue()) {
            return searchRecursively(node.getLeft(), value);
        } else {
            return searchRecursively(node.getRight(), value);
        }
    }

    // At first traverse left subtree then visit the root and then traverse the right subtree.
    // LEFT, ROOT, RIGHT traversal
    public List<Integer> inorder() {
        List<Integer> inorderList = new ArrayList<>();

        inorder(root, inorderList);

        return inorderList;
    }

    private void inorder(final Node node, List<Integer> inorderList) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft(), inorderList);
        inorderList.add(node.getValue());
        inorder(node.getRight(), inorderList);
    }

    // At first visit the root then traverse left subtree and then traverse the right subtree.
    // ROOT, LEFT, RIGHT
    public List<Integer> preorder() {
        List<Integer> preorderList = new ArrayList<>();

        preorder(root, preorderList);

        return preorderList;
    }

    private void preorder(final Node node, List<Integer> preorderList) {
        if (node == null) {
            return;
        }

        preorderList.add(node.getValue());
        preorder(node.getLeft(), preorderList);
        preorder(node.getRight(), preorderList);
    }

    // At first traverse left subtree then traverse the right subtree and then visit the root.
    // LEFT, RIGHT, ROOT
    public List<Integer> postorder() {
        List<Integer> postorderList = new ArrayList<>();

        postorder(root, postorderList);

        return postorderList;
    }

    private void postorder(final Node node, List<Integer> postorderList) {
        if (node == null) {
            return;
        }

        postorder(node.getLeft(), postorderList);
        postorder(node.getRight(), postorderList);
        postorderList.add(node.getValue());
    }

    public int height() {
        return heightRecursively(root);
    }

    private int heightRecursively(final Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(
            heightRecursively(node.getLeft()),
            heightRecursively(node.getRight())
        );
    }

    public void balanceTree() {
        List<Integer> inorderList = inorder();

        root = balanceTreeRecursively(inorderList, 0, inorderList.size() - 1);
    }

    private Node balanceTreeRecursively(final List<Integer> inorderList,
                                        final int left,
                                        final int right) {
        if (left > right) {
            return null;
        }

        int middle = left + (right - left) / 2;

        Node node = new Node();

        node.setValue(inorderList.get(middle));
        node.setLeft(balanceTreeRecursively(inorderList, left, middle - 1));
        node.setRight(balanceTreeRecursively(inorderList, middle + 1, right));

        return node;
    }

    public boolean isTreeBalanced() {
        return isTreeBalancedRecursively(root);
    }

    private boolean isTreeBalancedRecursively(Node node) {
        if (node == null || node.isLeaf()) {
            return true;
        }

        int leftHeight = heightRecursively(node.getLeft());
        int rightHeight = heightRecursively(node.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1 &&
            isTreeBalancedRecursively(node.getLeft()) &&
            isTreeBalancedRecursively(node.getRight());
    }
}
