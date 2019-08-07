package Algorithms.Sort;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class ShellSort implements Sort {

    /**
     * Интервальная последовательность Дональда Кнута
     */
    private static final IntUnaryOperator KNUTH_SEQUENCE = h -> h * 3 + 1;

    /**
     * Обратная интервальная последовательность
     */
    private static final IntUnaryOperator KNUTH_REVERSE_SEQUENCE = h -> (h - 1) / 3;


    @Override
    public void sort(int[] array) {

        int outer;
        // Вычисление исходного интервала

        int h = 1;
        while (h <= array.length / 3)
            // Интервальная последовательность кнута
            h = KNUTH_SEQUENCE.applyAsInt(h);


        // Пока интервал N-сортировки превышает 0

        while (h > 0) {

            // Выполняем этап N-сортировки
            for (outer = h; outer < array.length; outer++) {

                // Запоминаем элемент на текущей позиции
                int temp = array[outer];

                int inner;

                // Сдвигаем элементы вправо на участке рассматриваемой подгруппы для освобождения места для текущего элемента
                for (inner = outer; inner >= h && array[inner - h] >= temp; inner -= h) {
                    array[inner] = array[inner - h];
                }

                // Вставляем элемент в нужное место в своей подгруппе
                array[inner] = temp;

            }

            // уменьшаем интервал
            h = KNUTH_REVERSE_SEQUENCE.applyAsInt(h);
        }
    }
}
