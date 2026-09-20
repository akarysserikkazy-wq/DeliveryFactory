package com.delivery.logistics;

import com.delivery.logistics.packaging.Packaging;
import com.delivery.logistics.packaging.RuggedPackaging;
import com.delivery.logistics.route.HighwayRoutePlanner;
import com.delivery.logistics.route.RoutePlanner;
import com.delivery.vehicle.Car;
import com.delivery.vehicle.Vehicle;

public class RuralLogisticsFactory implements LogisticsFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Packaging createPackaging() {
        return new RuggedPackaging();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new HighwayRoutePlanner();
    }

    @Override
    public String getRegionName() {
        return "Rural";
    }
}