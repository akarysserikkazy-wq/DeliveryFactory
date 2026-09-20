## Assignment #2 — Factory Method & Abstract Factory
### Student: Serikkazy Akarys
### Group: SE-2514

### About the product.

The application simulates a delivery/logistics service. A delivery job requires a vehicle (Part A — Factory Method: Bike, Car, Drone, each with its own speed and load capacity) and, for a complete regional dispatch, a consistent family of related objects — vehicle, packaging, and route planner — that must never be mixed across regions (Part B — Abstract Factory: Urban family vs Rural family).

The vehicle specs (speed, max load) are fixed and defined via the VehicleSpecs constants class.

### Clean Code Requirements
#### 1. Meaningful, intention-revealing names for classes/methods/variables
vehicleFactory.dispatch(distanceKm, packageKg);

logisticsFactory.getRegionName();

#### 2. Small methods, each doing one thing
protected Vehicle createVehicle() { ... }   - only decides which concrete Vehicle to instantiate

public final String dispatch(...) { ... }   - only validates + delegates to createVehicle() and Vehicle.deliver()

public void completeDelivery(...) { ... }   - only orchestrates the 3 abstract products, no creation logic


#### 3. Consistent formatting and small, focused classes
    private static final double MAX_WEIGHT_KG = 5.0;

    public interface LogisticsFactory {
        Vehicle createVehicle();
        Packaging createPackaging();
        RoutePlanner createRoutePlanner();
        String getRegionName();
    }

Even the vehicle specs themselves are defined in the VehicleSpecs constants class.

#### 4. Validated construction (e.g., build() throws a clear exception on invalid state)

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

#### 5. No magic numbers/strings

    public static final double BIKE_MAX_LOAD_KG = 15.0;
    public static final double CAR_MAX_LOAD_KG = 300.0;
    public static final double DRONE_MAX_LOAD_KG = 5.0;

Vehicle stores no state at all — only behavior (deliver(), getMaxLoadKg()).

VehicleFactory is responsible only for creating a vehicle and dispatching it.

LogisticsFactory is responsible only for producing a consistent product family.

DeliveryService is responsible only for orchestrating a delivery through abstractions, never instantiating concrete classes.
