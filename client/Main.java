package com.delivery.client;

import com.delivery.logistics.LogisticsFactory;
import com.delivery.logistics.RuralLogisticsFactory;
import com.delivery.logistics.UrbanLogisticsFactory;
import com.delivery.vehicle.InvalidDeliveryException;
import com.delivery.vehicle.factory.BikeFactory;
import com.delivery.vehicle.factory.CarFactory;
import com.delivery.vehicle.factory.DroneFactory;
import com.delivery.vehicle.factory.VehicleFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("***** Part A: Factory Method *****\n");
        demoFactoryMethod();

        System.out.println("\n***** Part B: Abstract Factory *****\n");
        demoAbstractFactory();

        System.out.println("\n***** Validated construction *****\n");
        demoValidation();
    }

    private static void demoFactoryMethod() {
        VehicleFactory[] factories = {
                new BikeFactory(),
                new CarFactory(),
                new DroneFactory()
        };

        for (VehicleFactory factory : factories) {
            System.out.println(factory.dispatch(12.0, 3.0));
        }
    }

    private static void demoAbstractFactory() {
        LogisticsFactory[] families = {
                new UrbanLogisticsFactory(),
                new RuralLogisticsFactory()
        };

        for (LogisticsFactory family : families) {
            DeliveryService service = new DeliveryService(family);
            service.completeDelivery(3.0, 8.0, "Warehouse", "Customer");
        }
    }

    private static void demoValidation() {
        VehicleFactory droneFactory = new DroneFactory();
        try {
            droneFactory.dispatch(10.0, 20.0);
        } catch (InvalidDeliveryException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}