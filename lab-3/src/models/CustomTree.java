package models;

public interface CustomTree<T extends Number> {
    void add(T element);

    Double searchNext(CustomTreeModel<Double> node);

    CustomTreeModel<Double> searchNode(Double element);

    class CustomTreeModel<T> {
        T value;
        CustomTreeModel<T> left;
        CustomTreeModel<T> right;
        CustomTreeModel<T> parent;

        public CustomTreeModel(T value, CustomTreeModel<T> parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
