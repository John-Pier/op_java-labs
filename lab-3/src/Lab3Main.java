import models.*;

public class Lab3Main {

    // Напишите алгоритм поиска «следующего» узла для заданного узла в бинарном дереве поиска.
    // Считайте, что у каждого узла есть ссылка на его родителя.
    public static void main(String[] args) {
        // 6
        System.out.println("Hello world!");
        CustomTree<Double> tree = new DefaultCustomTree();

        tree.add(10d);
        tree.add(12d);
        tree.add(9d);
        tree.add(8d);
        tree.add(6d);
        tree.add(7d);
        tree.add(5d);
        tree.add(4d);
        tree.add(11d);
        tree.add(13d);//
        tree.add(15d);
        tree.add(14d);


        System.out.println("First: " + 9);
        System.out.println("Second: " + tree.searchNext(tree.searchNode(9d)));
    }
}