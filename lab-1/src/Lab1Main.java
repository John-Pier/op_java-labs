import models.SmallSet;

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
        int testCount = 1;
        List<TestData<Integer>> testsData = new ArrayList<>(testCount);
        for (int i = 0; i < testCount; i++) {
            TestData<Integer> test = new TestData<>() {
                @Override
                public Integer[] getA() {
                    // TODO
                    return new Integer[]{1, 3, 4, 5, 6, 7, 8};
                }

                @Override
                public Integer[] getB() {
                    // TODO
                    return new Integer[]{9, 10, 1, 5, 6, 7, 8};
                }
            };

            testsData.add(test);
        }
        return testsData;
    }

    private static void testSet(List<TestData<Integer>> testsData) {
        // TODO
        for (TestData<Integer> testData : testsData) {
            System.out.println(Arrays.toString(getIntersection(testData.getA(), testData.getB())));
        }
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
