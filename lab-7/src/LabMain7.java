import java.util.*;

public class LabMain7 {
    // 4 - все подмножества заданного множества
    public static void main(String[] args) {
        System.out.println("4 Вариант. Все подмножества заданного множества");
        var test = new String[] {"a","b","c","d","e","f","g"};
        var result = getAllSubSets(test);
        printResults(result);
    }

    private static void printResults(ArrayList<ArrayList<String>> results) {
        System.out.println("Общее число комбинаций - " + results.size());
        for (ArrayList<String> item: results) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    private static ArrayList<ArrayList<String>> getAllSubSets(String[] set) {
        int length = (int)Math.pow(2, set.length) + 2;
        int setLength = set.length;
        var results = new ArrayList<ArrayList<String>>();

        return results;
    }
}