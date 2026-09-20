package com.delivery.vehicle;

public class Car implements Vehicle {

    @Override
    public String deliver(double distanceKm) {
        double hours = distanceKm / getSpeedKmh();
        return String.format(
                "Car drove %.1f km in %.1f h (max load %.0f kg)",
                distanceKm, hours, getMaxLoadKg());
    }

    @Override
    public double getMaxLoadKg() {
        return VehicleSpecs.CAR_MAX_LOAD_KG;
    }

    @Override
    public double getSpeedKmh() {
        return VehicleSpecs.CAR_SPEED_KMH;
    }

    @Override
    public String getName() {
        return "Car";
    }
}