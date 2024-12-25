package org.bitwise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @BeforeEach
    void beforeEach() {
        bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
    }

    @Test
    void testInsert() {
        Assertions.assertEquals(50, bst.getRoot().getValue());
        Assertions.assertEquals(30, bst.getRoot().getLeft().getValue());
        Assertions.assertEquals(20, bst.getRoot().getLeft().getLeft().getValue());
        Assertions.assertEquals(40, bst.getRoot().getLeft().getRight().getValue());
        Assertions.assertEquals(70, bst.getRoot().getRight().getValue());
        Assertions.assertEquals(60, bst.getRoot().getRight().getLeft().getValue());
        Assertions.assertEquals(80, bst.getRoot().getRight().getRight().getValue());
    }

    @Test
    void testSearch() {
        Assertions.assertTrue(bst.search(50));
        Assertions.assertTrue(bst.search(30));
        Assertions.assertTrue(bst.search(20));
        Assertions.assertTrue(bst.search(40));
        Assertions.assertTrue(bst.search(70));
        Assertions.assertTrue(bst.search(60));
        Assertions.assertTrue(bst.search(80));

        Assertions.assertFalse(bst.search(100));
    }

    @Test
    void testInorder() {
        List<Integer> expectedList = Arrays.asList(
            20, 30, 40, 50, 60, 70, 80
        );

        List<Integer> inorderList = bst.inorder();

        Assertions.assertEquals(expectedList, inorderList);
    }

    @Test
    void testPreorder() {
        List<Integer> expectedList = Arrays.asList(
            50, 30, 20, 40, 70, 60, 80
        );

        List<Integer> preorderList = bst.preorder();

        Assertions.assertEquals(expectedList, preorderList);
    }

    @Test
    void testPostorder() {
        List<Integer> expectedList = Arrays.asList(
            20, 40, 30, 60, 80, 70, 50
        );

        List<Integer> postorderList = bst.postorder();

        Assertions.assertEquals(expectedList, postorderList);
    }

    @Test
    void testNullTreeHeight() {
        bst = new BinarySearchTree();

        int height = bst.height();

        Assertions.assertEquals(0, height);
    }

    @Test
    void testBalancedTreeHeight() {
        bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        int height = bst.height();

        Assertions.assertEquals(3, height);
    }

    @Test
    void testUnbalancedTreeHeight() {
        bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);
        bst.insert(60);
        bst.insert(70);
        bst.insert(80);

        int heightBefore = bst.height();

        Assertions.assertEquals(7, heightBefore);

        bst.balanceTree();

        int heightAfter = bst.height();

        Assertions.assertEquals(3, heightAfter);
    }

    @Test
    void testBalancedTreeIsBalanced() {
        bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        Assertions.assertTrue(bst.isTreeBalanced());
    }

    @Test
    void testUnbalancedTreeIsNotBalanced() {
        bst = new BinarySearchTree();

        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);
        bst.insert(60);
        bst.insert(70);
        bst.insert(80);

        Assertions.assertFalse(bst.isTreeBalanced());
    }
}
