import java.util.*;

public class LabMain7 {
    // 4 - все подмножества заданного множества
    public static void main(String[] args) {
        System.out.println("4 Вариант. Все подмножества заданного множества");
        var test = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        var result = getAllSubSets(test);
        printResults(result);
    }

    private static void printResults(ArrayList<ArrayList<String>> results) {
        System.out.println("Общее число комбинаций - " + results.size());
        for (ArrayList<String> item : results) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    private static ArrayList<ArrayList<String>> getAllSubSets(String[] set) {
        int length = 1 << set.length;
        var results = new ArrayList<ArrayList<String>>(length);
        results.add(new ArrayList<>());

        for (int i = 1; i < length; i++) {
            results.add(getSetsWithLength(set, i));
        }
        return results;
    }

    private static ArrayList<String> getSetsWithLength(String[] set, int maxLength) {
        var result = new ArrayList<String>();
        int i = 0;
        while (maxLength > 0) {
            if ((maxLength & 1) > 0) {
                result.add(set[i]);
            }
            maxLength >>= 1;
            i++;
        }
        return result;
    }
}