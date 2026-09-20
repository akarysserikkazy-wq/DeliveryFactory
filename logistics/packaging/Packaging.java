package com.delivery.logistics.packaging;

public interface Packaging {
    String pack(double weightKg);
    double getMaxWeightKg();
}
