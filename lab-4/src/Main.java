public class Main {
    public static void main(String[] args) {
        System.out.println("Lab 4. Task 8");
        System.out.println("Test line");
        byte start = -128;
        System.out.println(Integer.toBinaryString(setBytes(start, 2, 7)));
        System.out.println("Test image");
        printImage(Image, 16);
        drawLine(Image, 16, 3, 3, 3); // oт 0 отсчет
        System.out.println("--------\t\t--------");
        printImage(Image, 16);
    }

    private static final byte[] Image = new byte[]{-128, -128, -128, -128, -128, -128, -128, -128, -128, -128};

    /**
     * Содержимое монохромного экрана хранится в одномерном массиве байтов,
     * так что в одном байте содержится информация о восьми соседних пикселах.
     * Ширина изображения w кратна 8 (то есть байты не переходят между столбцами).
     * Высоту экрана можно рассчитать, зная длину массива и ширину экрана.
     * Реализуйте функцию, которая рисует горизонтальную линию из точки (x1,у) в точку ( х2, у).
     * Сигнатура метода должна выглядеть примерно так:
     * drawLine(byte[] screen, int width, int x1, int х2, int у)
     */
    private static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int realWidth = width / 8;
        int dx = x2 - x1;
        while (dx >= 0) {
            int i = x2 - dx;
            int index = y*realWidth + i / 8;
            int di = i % 8;
            byte element = screen[index];

            if (dx <= (8 - di)) {
                element = setBytes(element, di, di + dx);
                dx = -1;
            }
            else {
                element = setBytes(element, di, 7);
                dx -= 8 - di;
            }

            screen[index] = element;
        }
    }

    private static byte setBytes(byte value, int i1, int i2) {
        int mask1 = (1 << (8 - i1)) - 1;
        int mask2 = (1 << (7 - i2)) - 1;
        return (byte) (value | (mask1 ^ mask2));
    }

    private static void printImage(byte[] screen, int width) {
        int realWidth = width / 8;
        for (int i = 0; i < screen.length; i++) {
            if ((i + 1) % realWidth == 0) {
                System.out.println(Integer.toBinaryString(screen[i]).substring(24));
            } else {
                System.out.print(Integer.toBinaryString(screen[i]).substring(24) + "\t\t");
            }
        }
    }
}