package com.delivery.vehicle.factory;

import com.delivery.vehicle.InvalidDeliveryException;
import com.delivery.vehicle.Vehicle;

public abstract class VehicleFactory {

    protected abstract Vehicle createVehicle();

    public final String dispatch(double distanceKm, double packageKg) {
        validate(distanceKm, packageKg);

        Vehicle vehicle = createVehicle();
        if (packageKg > vehicle.getMaxLoadKg()) {
            throw new InvalidDeliveryException(String.format(
                    "%s cannot carry %.1f kg (max is %.1f kg)",
                    vehicle.getName(), packageKg, vehicle.getMaxLoadKg()));
        }

        return vehicle.deliver(distanceKm);
    }

    private void validate(double distanceKm, double packageKg) {
        if (distanceKm <= 0) {
            throw new InvalidDeliveryException("Distance must be positive, got " + distanceKm);
        }
        if (packageKg <= 0) {
            throw new InvalidDeliveryException("Package weight must be positive, got " + packageKg);
        }
    }
}