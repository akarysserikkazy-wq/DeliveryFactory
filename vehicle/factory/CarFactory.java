package com.delivery.vehicle.factory;

import com.delivery.vehicle.Car;
import com.delivery.vehicle.Vehicle;

public class CarFactory extends VehicleFactory {

    @Override
    protected Vehicle createVehicle() {
        return new Car();
    }
}