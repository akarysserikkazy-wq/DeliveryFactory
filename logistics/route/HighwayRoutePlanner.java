package com.delivery.logistics.route;

public class HighwayRoutePlanner implements RoutePlanner {

    @Override
    public String planRoute(String from, String to) {
        return String.format(
                "Highway route from %s to %s via the fastest long-haul road", from, to);
    }
}