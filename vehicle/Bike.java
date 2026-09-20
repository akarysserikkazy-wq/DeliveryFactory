package com.delivery.vehicle;

public class Bike implements Vehicle {

    @Override
    public String deliver(double distanceKm) {
        double hours = distanceKm / getSpeedKmh();
        return String.format(
                "Bike courier pedaled %.1f km in %.1f h (max load %.0f kg)",
                distanceKm, hours, getMaxLoadKg());
    }

    @Override
    public double getMaxLoadKg() {
        return VehicleSpecs.BIKE_MAX_LOAD_KG;
    }

    @Override
    public double getSpeedKmh() {
        return VehicleSpecs.BIKE_SPEED_KMH;
    }

    @Override
    public String getName() {
        return "Bike";
    }
}