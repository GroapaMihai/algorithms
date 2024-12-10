package org.bitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node {
    private int value;

    private Node left;

    private Node right;

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
