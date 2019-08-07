package Algorithms.Greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Есть множество радиостанций, покрывающих определенные штаты. Задача - найти минимальный
 * набор станций, который покрывал бы все заданные штаты.
 * <p>
 * Алгоритм следующий:
 * <p>
 * 1. Выбрать станцию, покрывающую наибольшее количество еще не покрытых штатов
 * 2. Повторять, пока остаются штаты, не входящие в покрытие
 */
public class RadioStations {

    /**
     * Вычисляет минимальный набор станций, который бы покрыл все указанные штаты.
     *
     * @param targetStates штаты, которые необходимо полностью покрыть радиостанкциями
     * @param stations     список штатов, которые покрывает каждая существующая станция.
     * @return минимальный набор станций, покрывающий все необходимые штаты.
     */
    public Set<String> cover(Set<String> targetStates, Map<String, Set<String>> stations) {

        // Копируем входное множество данных
        Set<String> statesNeededToCover = new HashSet<>(targetStates);

        // Итоговое множество станций
        Set<String> finalStations = new HashSet<>();

        // Пока остаются штаты, не входящие в покрытие
        while (!statesNeededToCover.isEmpty()) {

            // Станкция, покрывающая наибольшее количество не покрытых штатов
            String bestStation = "";

            // Покрытые на данной итерации штаты
            Set<String> statesCovered = new HashSet<>();

            // Вычисляем станцию, покрывающее наибольшее количество еще не покрытых штатов.
            // Обычный алгоритм поиска наибольшего элемента.
            for (Map.Entry<String, Set<String>> entry : stations.entrySet()) {
                // Пересечение множеств штатов для данной станции с общим множеством целевых штатов для покрытия.
                // Это - все не покрытые штатов, которые покрывает данная станция.
                Set<String> covered = intersection(statesNeededToCover, entry.getValue());
                // При необходимости перезаписываем очередной наибольший элемент.
                if (covered.size() > statesCovered.size()) {
                    bestStation = entry.getKey();
                    statesCovered = covered;
                }
            }

            finalStations.add(bestStation);

            // Убираем покрытые на данной итерации штаты из списка штатов, которые нужно покрыть.
            statesNeededToCover.removeAll(statesCovered);
        }

        return finalStations;

    }

    private Set<String> intersection(Set<String> first, Set<String> second) {
        return first.stream().filter(second::contains).collect(Collectors.toSet());
    }


}
