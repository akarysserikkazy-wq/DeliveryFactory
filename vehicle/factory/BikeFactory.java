package com.delivery.vehicle.factory;

import com.delivery.vehicle.Bike;
import com.delivery.vehicle.Vehicle;

public class BikeFactory extends VehicleFactory {

    @Override
    protected Vehicle createVehicle() {
        return new Bike();
    }
}