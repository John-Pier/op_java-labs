import java.util.*;

public class Main {
    // 10
    // Имеется 1000 бутылок лимонада, ровно одна из которых отравлена.
    // Также у вас есть 10 тестовых полосок для обнаружения яда.
    // Даже одна капля яда окрашивает полоску и делает ее непригодной
    // для дальнейшего использования.
    // На тестовую полоску можно одновременно нанести любое количество капель,
    // и одна полоска может использоваться сколько угодно раз
    // (при условии, что все пробы были отрицательными).
    // Однако вы можете проводить испытания не чаще одного раза в день,
    // а для получения результата с момента проведения проходит семь дней.
    // Как найти отравленную бутылку за минимальное количество дней?
    // Напишите программную модель вашего решения.
    public static void main(String[] args) {
        System.out.println("Lab 5. Task 10");

        // i - iй байт отвечает за бутылку)
        // 2^10  комбинаций этих единиц и нулей в 10 битах
        // значит тут можем понять за 1 итерацию

        int numOfPoison = Math.round((float)(Math.random() * 100));
        System.out.println(String.format("Пусть отравлена %d", numOfPoison));
        System.out.println(String.format("В двоичном представлении: %s", toByteString(numOfPoison, 10)));
        System.out.println("Начнем поиск: ");
        List<Integer> numberOfsStrips = foundBottles(numOfPoison);
        if (numberOfsStrips.isEmpty()) {
            System.out.println("Если у нас не окрасилась ни одна полоска,  то это 1я бутылка");
            return;
        }
        System.out.println("Если у нас окрасились слудующие полоски: " + Arrays.toString(numberOfsStrips.toArray()));
        int result = recognizeCount(numberOfsStrips);
        System.out.println("То это полоска с номером: " + result);
        System.out.println(String.format("В двоичном представлении: %s", toByteString(result, 10)));
    }

    static List<Integer> foundBottles(int numOfPoison) {
        int i = 0;
        List<Integer> result = new ArrayList<>(10);
        while (i < 10) {
            int mask = 1 << i;
            if ((numOfPoison & mask) != 0) {
                result.add(i);
            }
            i++;
        }
        return result;
    }

    static int recognizeCount(List<Integer> numberOfsStrips) {
        int result = 0;
        for(Integer i : numberOfsStrips) {
            result = setByte(result, i);
        }

        return result;
    }

    private static int setByte(int value, int i) {
        int mask = 1 << i;
        return (value | mask);
    }

    static String toByteString(int number, int byteVisible) {
        return  String.format("%32s", Integer.toBinaryString(number))
                .replace(' ', '0')
                .substring(32 - byteVisible);
    }
}