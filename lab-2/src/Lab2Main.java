import models.SortedStack;

import java.util.*;

public class Lab2Main {
    public static void main(String[] args) {
        // 1-7, 3-5
        runFirst();
        runSecond();
    }

    // 1-7
    private static void runFirst() {
        System.out.println("1-7");
        final int size = 4;
        int[][] image = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                image[i][j] = 10+ i + j;
            }
        }

        pintImg(image, size);

        for (int i = 0; i < (int) Math.ceil(size / 2.0); i++) {
            for (int j = 0; j < (int) Math.floor(size / 2.0); j++) {
                int tmp = image[i][j];
                image[i][j] = image[j][size - 1 - i];
                image[j][size - 1 - i] = image[size - 1 - i][size - 1 - j];
                image[size - 1 - i][size - 1 - j] = image[size - 1 - j][i];
                image[size - 1 - j][i] = tmp;
            }
        }
        System.out.println("old -> new");

        pintImg(image, size);
    }

    private static void pintImg(int[][] image, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(image[i][j] + "\t");
            }
            System.out.println("\t");
        }
    }

    // 3-5
    private static void runSecond() {
        System.out.println("3-5");
        System.out.println("Test sorted stack");
        var array = Arrays.stream((new Double[10])).map(i -> Math.random() * 100).toArray(Double[]::new);

        System.out.println(Arrays.toString(array));

        var stack = new SortedStack(array);
        System.out.println("After sort");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
