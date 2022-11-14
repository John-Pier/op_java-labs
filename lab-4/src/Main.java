public class Main {
    // 8
    public static void main(String[] args) {
        System.out.println("Lab 4. Task 8");

        drawLine(Image, 16, 5, 16, 4);
        printImage(Image, 16);
    }


    private static final byte[] Image = new byte[]{0b1011111, 0b1000000, 0b0001001, 0b0001001, 0b0010001, 0b1010111, 0b1001000, 0b0000001, 0b0100001, 0b0110001};

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
        int height = screen.length / (width / 8);
        int realWidth = width / 8;
        byte mask = 0b1111111;

        for (int x = x1; x <= x2; x++){
            screen[x + realWidth * (x / realWidth)] = 0; // TODO:
        };
    }

    private static void printImage(byte[] screen, int width) {
        int realWidth = width / 8;
        for (int i = 0; i < screen.length; i++) {
            if ((i + 1) % realWidth == 0) {
                System.out.println(Integer.toBinaryString(screen[i]));
            } else {
                System.out.print(Integer.toBinaryString(screen[i]) + "\t\t");
            }
        }
    }
}