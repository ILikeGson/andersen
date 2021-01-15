package com.andersen.patterns.creational.factorymethod.creator;

import com.andersen.patterns.creational.factorymethod.product.Connection;

public interface Driver {
    Connection createDatabaseConnection();
}
