package Algorithms.Greedy;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RadioStationsTest {

    @Test
    public void cover() {
        Set<String> statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new HashMap<>();

        stations.put("one", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("two", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("three", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("four", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("five", new HashSet<>(Arrays.asList("ca", "az")));

        assertEquals(new RadioStations().cover(statesNeeded, stations), new HashSet<>(Arrays.asList("one", "two", "three", "five")));
    }

}