package com.geomap;

public class GeoMapServiceImpl implements GeoMapService {

    private final Graph graph;

    public GeoMapServiceImpl(Graph graph) {
        this.graph = graph;
    }

    public int findDistance(String source, String destination) {
        return graph.findDistance(source,destination);
    }
}
