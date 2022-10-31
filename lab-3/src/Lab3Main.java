import models.*;

import java.util.Arrays;

public class Lab3Main {
    static CustomTree<Double> tree = new DefaultCustomTree();
    static int treeLength = 20;

    static {
        init();
    }

    private static void init() {
        Double[] values = new Double[20];

        for (int i = 0; i < 20; i++) {
            values[i] = i + 1d;
        }

        Arrays.sort(values, (a, b) -> (int) (Math.signum(Math.random() - Math.random())));

        Arrays.stream(values).forEach(a -> tree.add(a));
    }

    // 6
    // Напишите алгоритм поиска «следующего» узла для заданного узла в бинарном дереве поиска.
    // Считайте, что у каждого узла есть ссылка на его родителя.
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println("Testing...");
        for (double i = 1d; i < treeLength; i++) {
            System.out.println("First: " + i);
            System.out.println("Second: " + tree.searchNext(tree.searchNode(i)));
            System.out.println("--------");
        }
    }
}