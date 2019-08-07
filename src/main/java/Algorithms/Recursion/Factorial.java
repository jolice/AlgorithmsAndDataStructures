package Algorithms.Recursion;

public class Factorial {

    /**
     * Рекурсивно вычисляет факториал заданного числа
     *
     * @param i число
     * @return факториал числа
     */
    public int factorial(int i) {
        return i == 1 ? i : i * factorial(i - 1);
    }

}
