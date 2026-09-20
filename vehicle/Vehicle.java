package com.delivery.vehicle;

public interface Vehicle {
    String deliver(double distanceKm);
    double getMaxLoadKg();
    double getSpeedKmh();
    String getName();
}