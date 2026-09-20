package com.delivery.client;

import com.delivery.logistics.LogisticsFactory;
import com.delivery.logistics.packaging.Packaging;
import com.delivery.logistics.route.RoutePlanner;
import com.delivery.vehicle.Vehicle;

public class DeliveryService {

    private final LogisticsFactory factory;

    public DeliveryService(LogisticsFactory factory) {
        this.factory = factory;
    }

    public void completeDelivery(double weightKg, double distanceKm, String from, String to) {
        Vehicle vehicle = factory.createVehicle();
        Packaging packaging = factory.createPackaging();
        RoutePlanner routePlanner = factory.createRoutePlanner();

        System.out.println("== " + factory.getRegionName() + " delivery ==");
        System.out.println(packaging.pack(weightKg));
        System.out.println(routePlanner.planRoute(from, to));
        System.out.println(vehicle.deliver(distanceKm));
        System.out.println();
    }
}