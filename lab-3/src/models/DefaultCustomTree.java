package models;

import org.w3c.dom.Node;

import java.util.*;

public class DefaultCustomTree implements CustomTree<Double> {
    CustomTreeModel<Double> root;

    public DefaultCustomTree() {
        root = null;
    }

    @Override
    public void add(Double element) {
        var newNode = new CustomTreeModel<>(element, null);
        if (root == null) {
            this.root = newNode;
            return;
        }

        var currentNode = root;

        while (currentNode != null) {
            if (newNode.value > currentNode.value) {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    newNode.parent = currentNode;
                    currentNode.right = newNode;
                    return;
                }
            }

            if (newNode.value < currentNode.value) {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    newNode.parent = currentNode;
                    currentNode.left = newNode;
                    return;
                }
            } else {
                currentNode = null;
            }
        }
    }

    @Override
    public void searchNext(CustomTreeModel<Double> node) {
        var currentNode = this.root;

        while (currentNode != null) {
            if (node.value > currentNode.value) {
                // todo
            }
        }
    }

    public CustomTreeModel<Double> searchNode(Double element) {
        var currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.value == element) {
                return currentNode;
            }

            if (element > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }

        return null;
    }
}
