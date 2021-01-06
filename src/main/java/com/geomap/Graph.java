package com.geomap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {

    private List<String> vertex = new ArrayList<>();

    {
        vertex.add("PUNE");
        vertex.add("MUMBAI");
        vertex.add("NASIK");
        vertex.add("GOA");
    }

    private int[][] matrix = new int[][]{
            {0, 120, 200, -1},
            {120, 0, 180, 350},
            {200, 180, 0, -1},
            {-1, 350, -1, 0}
    };

    public int findDistance(final String source, final String destination) {
        validateInput(source, destination);
        final int sourceIndex = vertex.indexOf(source);
        final int destinationIndex = vertex.indexOf(destination);
        return matrix[sourceIndex][destinationIndex];
    }

    private void validateInput(String source, String destination) {
        final Set<String> allCities = vertex.stream().collect(Collectors.toSet());
        if (!allCities.contains(source) || !allCities.contains(destination)) {
            throw new IllegalArgumentException("unknown source or destination");
        }
    }

}
