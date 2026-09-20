package com.delivery.logistics.packaging;

import com.delivery.vehicle.InvalidDeliveryException;

public class RuggedPackaging implements Packaging {

    private static final double MAX_WEIGHT_KG = 250.0;

    @Override
    public String pack(double weightKg) {
        if (weightKg > MAX_WEIGHT_KG) {
            throw new InvalidDeliveryException(String.format(
                    "Rugged packaging cannot hold %.1f kg (max %.1f kg)",
                    weightKg, MAX_WEIGHT_KG));
        }
        return String.format("Crated %.1f kg in a reinforced, cushioned box", weightKg);
    }

    @Override
    public double getMaxWeightKg() {
        return MAX_WEIGHT_KG;
    }
}