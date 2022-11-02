package models;

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
                    continue;
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
    public Double searchNext(CustomTreeModel<Double> node) {
        var currentNode = node;

        if (currentNode.right != null) {
            return searchMinInSubtree(currentNode.right);
        }
        currentNode = currentNode.parent;

        while (currentNode != null) {
            if (node.value >= currentNode.value) {
                currentNode = currentNode.parent;
            } else {
                return currentNode.value;
            }
        }

        return null;
    }

    private Double searchMinInSubtree(CustomTreeModel<Double> node) {
        if (node.left == null) {
            return node.value;
        }
        var currentNode = node.left;

        while (currentNode.left != null) {
           currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    @Override
    public CustomTreeModel<Double> searchNode(Double element) {
        var currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.value.equals(element)) {
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
