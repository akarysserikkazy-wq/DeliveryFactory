package com.delivery.logistics;

import com.delivery.logistics.packaging.Packaging;
import com.delivery.logistics.route.RoutePlanner;
import com.delivery.vehicle.Vehicle;

public interface LogisticsFactory {
    Vehicle createVehicle();
    Packaging createPackaging();
    RoutePlanner createRoutePlanner();
    String getRegionName();
}