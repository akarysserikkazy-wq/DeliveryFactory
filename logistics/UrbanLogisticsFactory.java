package com.delivery.logistics;

import com.delivery.logistics.packaging.CompactPackaging;
import com.delivery.logistics.packaging.Packaging;
import com.delivery.logistics.route.RoutePlanner;
import com.delivery.logistics.route.UrbanRoutePlanner;
import com.delivery.vehicle.Drone;
import com.delivery.vehicle.Vehicle;

public class UrbanLogisticsFactory implements LogisticsFactory {

    @Override
    public Vehicle createVehicle() {
        return new Drone();
    }

    @Override
    public Packaging createPackaging() {
        return new CompactPackaging();
    }

    @Override
    public RoutePlanner createRoutePlanner() {
        return new UrbanRoutePlanner();
    }

    @Override
    public String getRegionName() {
        return "Urban";
    }
}