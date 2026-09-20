package com.delivery.vehicle.factory;

import com.delivery.vehicle.Drone;
import com.delivery.vehicle.Vehicle;

public class DroneFactory extends VehicleFactory {

    @Override
    protected Vehicle createVehicle() {
        return new Drone();
    }
}