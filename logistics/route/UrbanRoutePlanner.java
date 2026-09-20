package com.delivery.logistics.route;

public class UrbanRoutePlanner implements RoutePlanner {

    @Override
    public String planRoute(String from, String to) {
        return String.format(
                "Street-level route from %s to %s via shortest city path", from, to);
    }
}