import models.SmallSet;

import java.time.*;
import java.util.*;

public class Lab1Main {
    private static SetFabric<Integer> setFabric = HashSet::new;

    public static void main(String[] args) {
        List<TestData<Integer>> testsData = getTestData();

        System.out.println("Тестирование с HashSet<Integer>");
        testSet(testsData);

        setFabric = SmallSet::new;
        System.out.println("Тестирование с SmallSet<Integer>");
        testSet(testsData);
    }

    private static int[] getIntersection(Integer[] a, Integer[] b) {
        if (b.length > a.length) {
            return getIntersection(b, a);
        }

        Set<Integer> smallSet = setFabric.getSet(b.length);

        for (int element : b) {
            smallSet.add(element);
        }

        int size = 0;
        int[] result = new int[b.length];
        for (int element : a) {
            if (smallSet.contains(element)) {
                result[size++] = element;
            }
        }

        return Arrays.copyOf(result, size);
    }

    private static List<TestData<Integer>> getTestData() {
        int testCount = 1000000;
        List<TestData<Integer>> testsData = new ArrayList<>(testCount);
        for (int i = 0; i < testCount; i++) {
            Integer[] a = new Integer[(int)(500 + Math.random() * 500)];
            Integer[] b = new Integer[(int)(500 + Math.random() * 500)];

            int support = (int)(Math.random() * 400);
            fillArray(a, 0);
            fillArray(b, support);

            testsData.add(new TestData<>() {
                @Override
                public Integer[] getA() {
                    return a;
                }

                @Override
                public Integer[] getB() {
                    return b;
                }
            });
        }
        return testsData;
    }

    private static void fillArray(Integer[] array, int start) {
        for (int i = 0; i < array.length; i ++) {
            array[i] = start + i;
        }
    }

    private static void testSet(List<TestData<Integer>> testsData) {
        Instant start = Instant.now();
        for (TestData<Integer> testData : testsData) {
            getIntersection(testData.getA(), testData.getB());
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();
        System.out.println("Время выполнения для " + testsData.size() + " попыток, мс: " + elapsed / 1_000_000d);
    }

    @FunctionalInterface
    private interface SetFabric<T> {
        Set<T> getSet(int size);
    }

    private interface TestData<T> {
        T[] getA();

        T[] getB();
    }
}
