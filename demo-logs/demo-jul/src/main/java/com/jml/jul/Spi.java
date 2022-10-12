package com.jml.jul;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.ServiceLoader;


public class Spi {
    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        //Option<Driver> first = loader.
    }
}
